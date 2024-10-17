package com.test.sicredi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.test.sicredi.entities.Pessoa;
import com.test.sicredi.entities.Produto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {


    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    @NotBlank(message = "O nome é obrigatório.")
    private String nome;
    @NotNull(message = "O valor é obrigatório.")
    @DecimalMin(value = "0.0", inclusive = false, message = "O valor deve ser maior que zero.")
    private BigDecimal valor;


    @JsonIgnore
    public Produto getProduto() {
        return new Produto(this.nome, this.valor);
    }
}