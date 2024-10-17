package com.test.sicredi.service;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayOutputStream;

import com.test.sicredi.dto.CompraDTO;
import com.test.sicredi.dto.ItemDTO;
import com.test.sicredi.dto.PesquisarCompraDTO;
import com.test.sicredi.entities.Compra;
import com.test.sicredi.entities.CompraProduto;
import com.test.sicredi.entities.Pessoa;
import com.test.sicredi.entities.Produto;
import com.test.sicredi.model.ConsultaCompra;
import com.test.sicredi.repository.CompraRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CompraService {

    @Autowired
    CompraRepository compraRepository;

    @Autowired
    ProdutoService produtoService;

    @Autowired
    PessoaService pessoaService;

    @Autowired
    CompraProdutoService compraProdutoService;


    private BigDecimal valorCompra = BigDecimal.ZERO;


    @Transactional(readOnly = true)
    public List<Compra> findAll() {
        return compraRepository.findAll();
    }

    public ResponseEntity<Object> registrarCompra(CompraDTO compraDTO) {

        //validar se os produtos existem
        try {
            this.validaProdutoExistenteESomaValor(compraDTO.getItems());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(this.criarObjetoResposta(e.getMessage()));
        }
        //validar se a pessoa existe
        try {
            this.validaPessoaExistente(compraDTO.getCpf());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(this.criarObjetoResposta(e.getMessage()));
        }

        //registrar a compra
        try {
            Compra novaCompra = compraRepository.save(new Compra(compraDTO.getCpf(), this.valorCompra, new Date()));
            compraDTO.getItems().forEach(item -> {
                compraProdutoService.save(new CompraProduto(item.getProdutoId(), novaCompra.getId(), item.getQuantidade()));
            });
        } catch (Exception e) {
            log.error("Erro ao registrar a compra com os dados: " + compraDTO.toString() + ". Ex: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(this.criarObjetoResposta("Erro ao registrar a compra, tente novamente."));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(this.criarObjetoResposta("Compra cadastrada com sucesso."));
    }


    public ResponseEntity<Object> consultarComprasPorCpfENomeProdutoEDataInicialEDataFinal(PesquisarCompraDTO pesquisarCompraDTO) {
        List<ConsultaCompra> consultaCompra = null;
        try {
            List<Object[]> objects = compraRepository.consultarComprasPorCpfEDataInicialEDataFinal(
                    pesquisarCompraDTO.getCpf(),
                    pesquisarCompraDTO.getDataInicial(),
                    pesquisarCompraDTO.getDataFinal());
            consultaCompra = popularRelatorioCompra(objects, pesquisarCompraDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(this.criarObjetoResposta(e.getMessage()));
        }
        return ResponseEntity.status(HttpStatus.OK).body(consultaCompra);
    }

    private List<ConsultaCompra> popularRelatorioCompra(List<Object[]> objects, PesquisarCompraDTO pesquisarCompraDTO) {

        List<ConsultaCompra> consultaCompra = objects.stream().map(result -> {
            Pessoa pessoa = new Pessoa((String) result[1], (String) result[2]);
            Compra compra = new Compra(((BigInteger) result[0]).longValueExact(), (BigDecimal) result[3], (Date) result[4]);
            return new ConsultaCompra(compra, pessoa);
        }).collect(Collectors.toList());

        //busca os produtos da compra
        for (ConsultaCompra item : consultaCompra) {
            item.setProduto(produtoService.findByCompraIdAndProdutoNome(
                    "%".concat(pesquisarCompraDTO.getNome().toUpperCase().concat("%")),
                    item.getCompra().getId()));
        }
        //todas as compras que tem produto
        return consultaCompra.stream()
                .filter(item -> item.getProduto().size() > 0)
                .collect(Collectors.toList());
    }

    private void validaProdutoExistenteESomaValor(List<ItemDTO> items) throws RuntimeException {
        this.valorCompra = BigDecimal.ZERO;
        Map<Long, Integer> produtoPorQuantidade = new HashMap<>();

        items.forEach(item -> {
            Produto produto = produtoService.findById(item.getProdutoId());
            if (produto == null) {
                throw new RuntimeException("Produto com id " + item.getProdutoId() + " inexistente. Solicite o cadastro.");
            }
            produtoPorQuantidade.put(produto.getId(),
                    produtoPorQuantidade.get(produto.getId()) != null ? produtoPorQuantidade.get(produto.getId()) + item.getQuantidade() : item.getQuantidade());
            this.valorCompra = this.valorCompra.add((produto.getValor().multiply(new BigDecimal(item.getQuantidade()))));
        });

        produtoPorQuantidade.forEach((key, value) -> {
            if (value > 3) {
                throw new RuntimeException("Só é permitido 3 produtos iguais por CPF na mesma compra.");
            }
        });
    }

    private void validaPessoaExistente(String pessoaId) throws Exception {
        if (pessoaService.findById(pessoaId) == null) {
            throw new Exception("Pessoa com cpf " + pessoaId + " inexistente. Solicite o cadastro.");
        }
    }

    private Map<String, String> criarObjetoResposta(String mensagem) {
        Map<String, String> resposta = new HashMap<>();
        resposta.put("mensagem", mensagem);
        return resposta;
    }

}
