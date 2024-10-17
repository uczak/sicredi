package com.test.sicredi.fixture;


import com.test.sicredi.model.RelatorioCompraDiarioId;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RelatorioCompraDiarioIdFixture {

    private static RelatorioCompraDiarioId buildRandom() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        RelatorioCompraDiarioId relatorioCompraDiarioId = new RelatorioCompraDiarioId(
                formato.parse("2024-10-15 02:10:00.000"),
                1L
        );
        return relatorioCompraDiarioId;

    }

    public static RelatorioCompraDiarioId build() throws ParseException {
        return buildRandom();
    }

}
