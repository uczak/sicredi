package com.test.sicredi.service;

import com.test.sicredi.entities.CompraProduto;
import com.test.sicredi.entities.Pessoa;
import com.test.sicredi.fixture.CompraProdutoFixture;
import com.test.sicredi.fixture.PessoaFixture;
import com.test.sicredi.repository.CompraProdutoRepository;
import com.test.sicredi.repository.PessoaRepository;
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
class PessoaServiceTest {

    @InjectMocks
    private PessoaService pessoaService;
    @Mock
    private PessoaRepository pessoaRepository;


    @Test
    void findByIdWithSuccess() {

        Pessoa pessoa = PessoaFixture.build();
        Pessoa excpected = pessoa;

        when(pessoaRepository.findById(pessoa.getCpf())).thenReturn(Optional.of(pessoa));

        Pessoa actual = pessoaService.findById(pessoa.getCpf());

        assertEquals(excpected, actual);
        verify(pessoaRepository).findById(pessoa.getCpf());

    }

    @Test
    void saveWithSuccess() {

        Pessoa pessoa = PessoaFixture.build();
        Pessoa excpected = pessoa;

        when(pessoaRepository.save(pessoa)).thenReturn(pessoa);

        Pessoa actual = pessoaService.save(pessoa);

        assertEquals(excpected, actual);
        verify(pessoaRepository).save(pessoa);

    }

    @Test
    void findAllWithSuccess() {


        Pessoa pessoa = PessoaFixture.build();
        List<Pessoa> excpected = Arrays.asList(pessoa);

        when(pessoaRepository.findAll()).thenReturn(Arrays.asList(pessoa));

        List<Pessoa> actual = pessoaService.findAll();

        assertEquals(excpected, actual);
        verify(pessoaRepository).findAll();

    }
}