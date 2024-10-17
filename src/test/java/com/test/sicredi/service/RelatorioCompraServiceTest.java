package com.test.sicredi.service;

import com.test.sicredi.entities.Produto;
import com.test.sicredi.fixture.ProdutoFixture;
import com.test.sicredi.fixture.RelatorioCompraDiarioFixture;
import com.test.sicredi.model.RelatorioCompraDiario;
import com.test.sicredi.repository.ProdutoRepository;
import com.test.sicredi.repository.RelatorioCompraRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RelatorioCompraServiceTest {

    @InjectMocks
    private RelatorioCompraService relatorioCompraService;
    @Mock
    private RelatorioCompraRepository relatorioCompraRepository;


    @Test
    void findByIdWithSuccess() throws ParseException {

        ResponseEntity<byte[]> excpected = ResponseEntity.status(HttpStatus.OK).body("test".getBytes());
        RelatorioCompraDiario relatorioCompraDiario = RelatorioCompraDiarioFixture.build();
        when(relatorioCompraRepository.relatorioCompra()).thenReturn(Arrays.asList(relatorioCompraDiario));

        ResponseEntity<byte[]> actual = relatorioCompraService.relatorioCompras();

        assertEquals(excpected.getStatusCode(), actual.getStatusCode());
        verify(relatorioCompraRepository).relatorioCompra();

    }
}