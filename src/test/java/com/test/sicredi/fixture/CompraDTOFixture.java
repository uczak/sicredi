package com.test.sicredi.fixture;


import com.test.sicredi.dto.CompraDTO;

import java.math.BigDecimal;
import java.util.Arrays;

public class CompraDTOFixture {

    private static CompraDTO buildRandom() {
        CompraDTO compraDTO = new CompraDTO(Arrays.asList(ItemDTOFixture.build()),"037.000.300-91", BigDecimal.ONE);
        return compraDTO;

    }

    public static CompraDTO build() {
        return buildRandom();
    }

}
