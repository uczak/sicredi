package com.test.sicredi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.test.sicredi.entities.Compra;
import com.test.sicredi.entities.Pessoa;
import com.test.sicredi.entities.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RelatorioCompraDiario {

    @EmbeddedId
    private RelatorioCompraDiarioId id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "valor")
    private BigDecimal valor;
    @Column(name = "quantidade")
    private Integer quantidade;

}
