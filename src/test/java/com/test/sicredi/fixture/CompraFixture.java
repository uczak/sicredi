package com.test.sicredi.fixture;


import com.test.sicredi.entities.Compra;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CompraFixture {

    private static Compra buildRandom() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Compra compra = new Compra(
                1l,
                "037.000.300-91",
                BigDecimal.ONE,
                formato.parse("2024-10-15 02:10:00.000")
        );
        return compra;

    }

    public static Compra build() throws ParseException {
        return buildRandom();
    }

}
