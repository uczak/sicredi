package com.test.sicredi.fixture;


import com.test.sicredi.model.ConsultaCompra;

import java.text.ParseException;
import java.util.Arrays;

public class ConsultaCompraFixture {

    private static ConsultaCompra buildRandom() throws ParseException {
        ConsultaCompra consultaCompra = new ConsultaCompra(
                Arrays.asList(ProdutoFixture.build()),
                CompraFixture.build(),
                PessoaFixture.build()
        );
        return consultaCompra;

    }

    public static ConsultaCompra build() throws ParseException {
        return buildRandom();
    }

}
