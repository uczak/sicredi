package com.test.sicredi.fixture;


import com.test.sicredi.model.RelatorioCompraDiario;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RelatorioCompraDiarioFixture {

    private static RelatorioCompraDiario buildRandom() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        RelatorioCompraDiario relatorioCompraDiario = new RelatorioCompraDiario(
                RelatorioCompraDiarioIdFixture.build(),
                "nome",
                BigDecimal.ONE,
                1
        );
        return relatorioCompraDiario;

    }

    public static RelatorioCompraDiario build() throws ParseException {
        return buildRandom();
    }

}
