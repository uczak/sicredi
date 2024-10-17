package com.test.sicredi.service;

import com.test.sicredi.dto.CompraDTO;
import com.test.sicredi.dto.PesquisarCompraDTO;
import com.test.sicredi.entities.Compra;
import com.test.sicredi.entities.CompraProduto;
import com.test.sicredi.entities.Pessoa;
import com.test.sicredi.entities.Produto;
import com.test.sicredi.fixture.*;
import com.test.sicredi.model.ConsultaCompra;
import com.test.sicredi.repository.CompraRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CompraServiceTest {


    @InjectMocks
    private CompraService compraService;

    @Mock
    private CompraRepository compraRepository;

    @Mock
    private ProdutoService produtoService;

    @Mock
    private PessoaService pessoaService;

    @Mock
    private CompraProdutoService compraProdutoService;


    private Map<String, String> criarObjetoResposta(String mensagem) {
        Map<String, String> resposta = new HashMap<>();
        resposta.put("mensagem", mensagem);
        return resposta;
    }


    @Test
    void registrarCompraWithErrorProdutoNull() throws Exception {

        CompraDTO compraDTO = CompraDTOFixture.build();
        ResponseEntity excpected = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(criarObjetoResposta("Produto com id " + compraDTO.getItems().get(0).getProdutoId() + " inexistente. Solicite o cadastro."));

        when(produtoService.findById(any())).thenReturn(null);

        ResponseEntity<Object> actual = compraService.registrarCompra(compraDTO);

        assertEquals(excpected, actual);
        verify(produtoService).findById(any());

    }

    @Test
    void registrarCompraWithErrorPessoaNull() throws Exception {

        CompraDTO compraDTO = CompraDTOFixture.build();
        Produto produto = ProdutoFixture.build();
        ResponseEntity excpected = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(criarObjetoResposta("Pessoa com cpf " + compraDTO.getCpf() + " inexistente. Solicite o cadastro."));

        when(produtoService.findById(any())).thenReturn(produto);
        when(pessoaService.findById(any())).thenReturn(null);

        ResponseEntity<Object> actual = compraService.registrarCompra(compraDTO);

        assertEquals(excpected, actual);
        verify(produtoService).findById(any());
        verify(pessoaService).findById(any());

    }

    @Test
    void registrarCompraWithSuccess() throws Exception {

        CompraDTO compraDTO = CompraDTOFixture.build();
        Produto produto = ProdutoFixture.build();
        Pessoa pessoa = PessoaFixture.build();
        Compra compra = CompraFixture.build();
        CompraProduto compraProduto = CompraProdutoFixture.build();
        ResponseEntity excpected = ResponseEntity.status(HttpStatus.CREATED).body(criarObjetoResposta("Compra cadastrada com sucesso."));

        when(produtoService.findById(any())).thenReturn(produto);
        when(pessoaService.findById(any())).thenReturn(pessoa);
        when(compraRepository.save(any())).thenReturn(compra);
        when(compraProdutoService.save(any())).thenReturn(compraProduto);


        ResponseEntity<Object> actual = compraService.registrarCompra(compraDTO);

        assertEquals(excpected, actual);
        verify(produtoService).findById(any());
        verify(pessoaService).findById(any());
        verify(compraRepository).save(any());
        verify(compraProdutoService).save(any());

    }

    @Test
    void consultarComprasPorCpfENomeProdutoEDataInicialEDataFinalWithSuccess() throws Exception {

        CompraDTO compraDTO = CompraDTOFixture.build();
        Produto produto = ProdutoFixture.build();
        Pessoa pessoa = PessoaFixture.build();
        Compra compra = CompraFixture.build();
        CompraProduto compraProduto = CompraProdutoFixture.build();
        ConsultaCompra consultaCompra = ConsultaCompraFixture.build();
        PesquisarCompraDTO pesquisarCompraDTO = PesquisarCompraDTOFixture.build();
        ResponseEntity excpected = ResponseEntity.status(HttpStatus.OK).body(consultaCompra);


        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        List<Object[]> lista = new ArrayList<>();
        Object[] obj1 = {BigInteger.ONE, "037.000.300-91", "Joao", BigDecimal.ONE, formato.parse("2024-10-15 02:10:00.000")};
        Object[] obj2 = {BigInteger.TEN, "037.000.300-92", "Maria", BigDecimal.ONE, formato.parse("2024-10-15 02:10:00.000")};
        lista.add(obj1);
        lista.add(obj2);
        when(compraRepository.consultarComprasPorCpfEDataInicialEDataFinal(any(), any(), any())).thenReturn(lista);
        when(produtoService.findByCompraIdAndProdutoNome(any(), any())).thenReturn(Arrays.asList(produto));

        ResponseEntity<Object> actual = compraService.consultarComprasPorCpfENomeProdutoEDataInicialEDataFinal(pesquisarCompraDTO);

        assertEquals(excpected.getStatusCode(), actual.getStatusCode());
        verify(compraRepository).consultarComprasPorCpfEDataInicialEDataFinal(any(), any(), any());

    }


}