package com.test.sicredi.entities;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "produto")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "valor")
    private BigDecimal valor;

    public Produto(String nome, BigDecimal valor) {
        this.nome = nome;
        this.valor = valor;
    }
}