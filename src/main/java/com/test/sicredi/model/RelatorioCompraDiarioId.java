package com.test.sicredi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@Data
@Embeddable
@AllArgsConstructor
public class RelatorioCompraDiarioId implements Serializable {

    @Column(name = "data")
    private Date data;
    @Column(name = "produto_id")
    private Long id;

}
