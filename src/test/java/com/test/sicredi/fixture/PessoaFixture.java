package com.test.sicredi.fixture;


import com.test.sicredi.entities.Pessoa;

public class PessoaFixture {

    private static Pessoa buildRandom() {
        Pessoa pessoa = new Pessoa(
                "037.000.300-91",
                "Joao");
        return pessoa;

    }

    public static Pessoa build() {
        return buildRandom();
    }

}
