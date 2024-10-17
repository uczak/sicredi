package com.test.sicredi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {


    @NotNull(message = "O Id do produto é obrigatório.")
    private Long produtoId;

    @NotNull(message = "A quantidade de itens é obrigatório.")
    @Min(message = "Não é permitido comprar menos de 1 produtos.", value = 1)
    @Max(message = "Só é permitido 3 produtos iguais por CPF na mesma compra.", value = 3)
    private Integer quantidade;

  /*  @NotNull(message = "O valor é obrigatório.")
    @DecimalMin(value = "0.0", inclusive = false, message = "O valor deve ser maior que zero.")
    private BigDecimal valor;*/

    @JsonIgnore
    private String nome;

}