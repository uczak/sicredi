package com.test.sicredi.service;

import com.test.sicredi.entities.Pessoa;
import com.test.sicredi.entities.Produto;
import com.test.sicredi.fixture.PessoaFixture;
import com.test.sicredi.fixture.ProdutoFixture;
import com.test.sicredi.repository.PessoaRepository;
import com.test.sicredi.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProdutoServiceTest {


    @InjectMocks
    private ProdutoService produtoService;
    @Mock
    private ProdutoRepository produtoRepository;


    @Test
    void findByIdWithSuccess() {

        Produto produto = ProdutoFixture.build();
        Produto excpected = produto;

        when(produtoRepository.findById(produto.getId())).thenReturn(Optional.of(produto));

        Produto actual = produtoService.findById(produto.getId());

        assertEquals(excpected, actual);
        verify(produtoRepository).findById(produto.getId());

    }

    @Test
    void saveWithSuccess() {

        Produto produto = ProdutoFixture.build();
        Produto excpected = produto;

        when(produtoRepository.save(produto)).thenReturn(produto);

        Produto actual = produtoService.save(produto);

        assertEquals(excpected, actual);
        verify(produtoRepository).save(produto);

    }

    @Test
    void findAllWithSuccess() {


        Produto produto = ProdutoFixture.build();
        List<Produto> excpected = Arrays.asList(produto);

        when(produtoRepository.findAll()).thenReturn(Arrays.asList(produto));

        List<Produto> actual = produtoService.findAll();

        assertEquals(excpected, actual);
        verify(produtoRepository).findAll();

    }
}