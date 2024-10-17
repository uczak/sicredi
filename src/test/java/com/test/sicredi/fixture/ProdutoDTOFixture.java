package com.test.sicredi.fixture;


import com.test.sicredi.dto.ProdutoDTO;

import java.math.BigDecimal;

public class ProdutoDTOFixture {

    private static ProdutoDTO buildRandom() {
        ProdutoDTO itemDTO = new ProdutoDTO(
                "nome",
                BigDecimal.ONE
        );
        return itemDTO;

    }

    public static ProdutoDTO build() {
        return buildRandom();
    }

}
