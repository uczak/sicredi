package com.test.sicredi.fixture;


import com.test.sicredi.dto.PesquisarCompraDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PesquisarCompraDTOFixture {

    private static PesquisarCompraDTO buildRandom() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        PesquisarCompraDTO pesquisarCompraDTO = new PesquisarCompraDTO(
                "nome",
                "cpf",
                formato.parse("2024-10-15 02:10:00.000"),
                formato.parse("2024-10-20 02:10:00.000")
        );
        return pesquisarCompraDTO;

    }

    public static PesquisarCompraDTO build() throws ParseException {
        return buildRandom();
    }

}
