package com.test.sicredi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.test.sicredi.entities.Pessoa;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {


    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF deve estar no formato 000.000.000-00")
    @Schema(description = "CPF no formato 000.000.000-00", example = "123.456.789-09")
    @NotBlank(message = "O cpf é obrigatório.")
    private String cpf;
    @NotBlank(message = "O nome é obrigatório.")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    @Schema(description = "Nome completo da pessoa", example = "João Silva")
    private String nome;


    @JsonIgnore
    public Pessoa getPessoa() {
        return new Pessoa(this.cpf, this.nome);
    }
}