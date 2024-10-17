package com.test.sicredi.controller;

import com.test.sicredi.dto.CompraDTO;
import com.test.sicredi.dto.PesquisarCompraDTO;
import com.test.sicredi.fixture.CompraDTOFixture;
import com.test.sicredi.fixture.PesquisarCompraDTOFixture;
import com.test.sicredi.service.CompraService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CompraControllerTest {

    @InjectMocks
    private CompraController compraController;
    @Mock
    private CompraService compraService;

    private Map<String, String> criarObjetoResposta(String mensagem) {
        Map<String, String> resposta = new HashMap<>();
        resposta.put("mensagem", mensagem);
        return resposta;
    }

    @Test
    public void registrarCompraWithSuccess() {
        CompraDTO compraDTO = CompraDTOFixture.build();
        ResponseEntity excpected = ResponseEntity.status(HttpStatus.OK).body(criarObjetoResposta("Compra cadastrada com sucesso."));

        when(compraService.registrarCompra(compraDTO)).thenReturn(excpected);

        ResponseEntity actual = compraController.registrarCompra(compraDTO);

        assertEquals(excpected, actual);
        verify(compraService).registrarCompra(compraDTO);
    }

    @Test
    public void consultarComprasPorCpfENomeProdutoEDataInicialEDataFinalWithSuccess() throws ParseException {
        PesquisarCompraDTO pesquisarCompraDTO = PesquisarCompraDTOFixture.build();
        ResponseEntity excpected = ResponseEntity.status(HttpStatus.OK).body(criarObjetoResposta("Compra cadastrada com sucesso."));

        when(compraService.consultarComprasPorCpfENomeProdutoEDataInicialEDataFinal(pesquisarCompraDTO)).thenReturn(excpected);

        ResponseEntity actual = compraController.consultarComprasPorCpfENomeProdutoEDataInicialEDataFinal(pesquisarCompraDTO);

        assertEquals(excpected, actual);
        verify(compraService).consultarComprasPorCpfENomeProdutoEDataInicialEDataFinal(pesquisarCompraDTO);
    }
}