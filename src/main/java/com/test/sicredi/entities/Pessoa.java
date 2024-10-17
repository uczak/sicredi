package com.test.sicredi.entities;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @Column(name = "cpf")
    @Schema(description = "CPF no formato 000.000.000-00", example = "123.456.789-09")
    private String cpf;
    @Column(name = "nome")
    private String nome;


}