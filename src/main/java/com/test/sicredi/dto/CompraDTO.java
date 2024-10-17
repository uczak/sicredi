package com.test.sicredi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompraDTO {

    @NotNull(message = "É obrigatório conter produtos em uma compra.")
    @Valid
    @JsonProperty("produtos")
    private List<ItemDTO> items;

    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF deve estar no formato 000.000.000-00")
    @Schema(description = "CPF no formato 000.000.000-00", example = "037.000.300-91")
    @NotBlank(message = "O cpf é obrigatório.")
    private String cpf;

    @JsonIgnore
    private BigDecimal valorTotal = BigDecimal.ZERO;


}