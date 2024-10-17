package com.test.sicredi.entities;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "compra")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "pessoa_cpf")
    private String pessoaCpf;
    @Column(name = "valor_total")
    private BigDecimal valorTotal;
    @Column(name = "data")
    private Date data;

    public Compra(String pessoaCpf, BigDecimal valorTotal) {
        this.pessoaCpf = pessoaCpf;
        this.valorTotal = valorTotal;
    }

    public Compra(String pessoaCpf, BigDecimal valorTotal, Date data) {
        this.pessoaCpf = pessoaCpf;
        this.valorTotal = valorTotal;
        this.data = data;
    }

    public Compra(Long id, BigDecimal valorTotal, Date data) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.data = data;
    }
}