package com.test.sicredi.controller;

import com.test.sicredi.dto.ProdutoDTO;
import com.test.sicredi.entities.Produto;
import com.test.sicredi.fixture.ProdutoDTOFixture;
import com.test.sicredi.fixture.ProdutoFixture;
import com.test.sicredi.service.ProdutoService;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProdutoControllerTest {

    @InjectMocks
    private ProdutoController produtoController;
    @Mock
    private ProdutoService produtoService;

    private Map<String, String> criarObjetoResposta(String mensagem) {
        Map<String, String> resposta = new HashMap<>();
        resposta.put("mensagem", mensagem);
        return resposta;
    }

    @Test
    public void findAllWithSuccess() {
        Produto produto = ProdutoFixture.build();
        ResponseEntity excpected = ResponseEntity.status(HttpStatus.OK).body(Arrays.asList(produto));

        when(produtoService.findAll()).thenReturn(Arrays.asList(produto));

        ResponseEntity actual = produtoController.findAll();

        assertEquals(excpected, actual);
        verify(produtoService).findAll();
    }

    @Test
    public void findByIdWithSuccess() {
        Produto produto = ProdutoFixture.build();
        ResponseEntity excpected = ResponseEntity.status(HttpStatus.OK).body(produto);

        when(produtoService.findById(produto.getId())).thenReturn(produto);

        ResponseEntity actual = produtoController.findById(produto.getId());

        assertEquals(excpected, actual);
        verify(produtoService).findById(produto.getId());
    }

    @Test
    public void saveWithSuccess() {
        Produto produto = ProdutoFixture.build();
        ProdutoDTO produtoDTO = ProdutoDTOFixture.build();
        ResponseEntity excpected = ResponseEntity.status(HttpStatus.OK).body(produto);

        when(produtoService.save(any())).thenReturn(produto);

        ResponseEntity actual = produtoController.save(produtoDTO);

        assertEquals(excpected, actual);
        verify(produtoService).save(any());
    }
}