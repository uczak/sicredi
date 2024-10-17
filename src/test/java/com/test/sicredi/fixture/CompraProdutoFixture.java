package com.test.sicredi.fixture;


import com.test.sicredi.entities.CompraProduto;

public class CompraProdutoFixture {

    private static CompraProduto buildRandom() {
        CompraProduto compraProduto = new CompraProduto(
                1l,
                1L,
                1L
        );
        return compraProduto;

    }

    public static CompraProduto build() {
        return buildRandom();
    }

}
