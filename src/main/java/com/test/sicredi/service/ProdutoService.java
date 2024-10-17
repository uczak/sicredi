package com.test.sicredi.service;

import com.test.sicredi.entities.Produto;
import com.test.sicredi.repository.PessoaRepository;
import com.test.sicredi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Transactional(readOnly = true)
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Produto findById(Long produtoId) {
        return produtoRepository.findById(produtoId).orElse(null);
    }

    @Transactional(readOnly = false)
    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Transactional(readOnly = true)
    public List<Produto> findByCompraIdAndProdutoNome(String produtoNome, Long compraId) {
        return produtoRepository.findByCompraIdAndProdutoNome(produtoNome, compraId);
    }


}
