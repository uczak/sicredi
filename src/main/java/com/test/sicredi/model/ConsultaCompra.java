package com.test.sicredi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.test.sicredi.entities.Compra;
import com.test.sicredi.entities.Pessoa;
import com.test.sicredi.entities.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConsultaCompra {

    private List<Produto> produto;
    private Compra compra;
    private Pessoa pessoa;

    public ConsultaCompra(Compra compra, Pessoa pessoa) {
        this.compra = compra;
        this.pessoa = pessoa;
    }
}
