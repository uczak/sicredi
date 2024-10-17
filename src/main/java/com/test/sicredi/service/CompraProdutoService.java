package com.test.sicredi.service;

import com.test.sicredi.entities.CompraProduto;
import com.test.sicredi.entities.Pessoa;
import com.test.sicredi.repository.CompraProdutoRepository;
import com.test.sicredi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompraProdutoService {

    @Autowired
    CompraProdutoRepository produtoRepository;

    @Transactional(readOnly = false)
    public CompraProduto save(CompraProduto compraProduto) {
        return produtoRepository.save(compraProduto);
    }
}
