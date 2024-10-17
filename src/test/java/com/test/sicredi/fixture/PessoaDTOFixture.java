package com.test.sicredi.fixture;


import com.test.sicredi.dto.PessoaDTO;

public class PessoaDTOFixture {

    private static PessoaDTO buildRandom() {
        PessoaDTO pessoaDTO = new PessoaDTO(
                "037.000.300-91",
                "Joao");
        return pessoaDTO;

    }

    public static PessoaDTO build() {
        return buildRandom();
    }

}
