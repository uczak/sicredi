package com.test.sicredi.service;

import com.test.sicredi.entities.CompraProduto;
import com.test.sicredi.fixture.CompraProdutoFixture;
import com.test.sicredi.repository.CompraProdutoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CompraProdutoServiceTest {


    @InjectMocks
    private CompraProdutoService compraProdutoService;
    @Mock
    private CompraProdutoRepository compraProdutoRepository;


    @Test
    void createQrCodeWithSuccess() throws Exception {


        CompraProduto compraProduto = CompraProdutoFixture.build();
        CompraProduto excpected = compraProduto;

        when(compraProdutoRepository.save(compraProduto)).thenReturn(compraProduto);
        CompraProduto actual = compraProdutoService.save(compraProduto);

        assertEquals(excpected, actual);
        verify(compraProdutoRepository).save(compraProduto);

    }

}