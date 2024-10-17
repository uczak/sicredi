package com.test.sicredi.fixture;


import com.test.sicredi.entities.Produto;

import java.math.BigDecimal;

public class ProdutoFixture {

    private static Produto buildRandom() {
        Produto produto = new Produto(
                1l,
                "nome",
                BigDecimal.ONE
        );
        return produto;

    }

    public static Produto build() {
        return buildRandom();
    }

}
