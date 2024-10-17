package com.test.sicredi.controller;

import com.test.sicredi.dto.PessoaDTO;
import com.test.sicredi.entities.Pessoa;
import com.test.sicredi.fixture.PessoaDTOFixture;
import com.test.sicredi.fixture.PessoaFixture;
import com.test.sicredi.service.PessoaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PessoaControllerTest {

    @InjectMocks
    private PessoaController pessoaController;
    @Mock
    private PessoaService pessoaService;

    private Map<String, String> criarObjetoResposta(String mensagem) {
        Map<String, String> resposta = new HashMap<>();
        resposta.put("mensagem", mensagem);
        return resposta;
    }

    @Test
    public void findAllWithSuccess() {
        Pessoa pessoa = PessoaFixture.build();
        ResponseEntity excpected = ResponseEntity.status(HttpStatus.OK).body(Arrays.asList(pessoa));

        when(pessoaService.findAll()).thenReturn(Arrays.asList(pessoa));

        ResponseEntity actual = pessoaController.findAll();

        assertEquals(excpected, actual);
        verify(pessoaService).findAll();
    }

    @Test
    public void findByIdWithSuccess() {
        Pessoa pessoa = PessoaFixture.build();
        ResponseEntity excpected = ResponseEntity.status(HttpStatus.OK).body(pessoa);

        when(pessoaService.findById(pessoa.getCpf())).thenReturn(pessoa);

        ResponseEntity actual = pessoaController.findById(pessoa.getCpf());

        assertEquals(excpected, actual);
        verify(pessoaService).findById(pessoa.getCpf());
    }

    @Test
    public void saveWithSuccess() {
        Pessoa pessoa = PessoaFixture.build();
        PessoaDTO pessoaDTO = PessoaDTOFixture.build();
        ResponseEntity excpected = ResponseEntity.status(HttpStatus.OK).body(pessoa);

        when(pessoaService.save(pessoa)).thenReturn(pessoa);

        ResponseEntity actual = pessoaController.save(pessoaDTO);

        assertEquals(excpected, actual);
        verify(pessoaService).save(pessoa);
    }
}