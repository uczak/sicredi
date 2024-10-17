package com.test.sicredi.controller;

import com.test.sicredi.entities.Pessoa;
import com.test.sicredi.fixture.PessoaFixture;
import com.test.sicredi.service.ProdutoService;
import com.test.sicredi.service.RelatorioCompraService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RelatorioCompraControllerTest {

    @InjectMocks
    private RelatorioCompraController relatorioCompraController;
    @Mock
    private RelatorioCompraService relatorioCompraService;


    @Test
    public void relatorioComprasWithSuccess() {
        ResponseEntity excpected = ResponseEntity.status(HttpStatus.OK).body("test".getBytes());

        when(relatorioCompraService.relatorioCompras()).thenReturn(excpected);

        ResponseEntity actual = relatorioCompraController.relatorioCompras();

        assertEquals(excpected, actual);
        verify(relatorioCompraService).relatorioCompras();
    }
}