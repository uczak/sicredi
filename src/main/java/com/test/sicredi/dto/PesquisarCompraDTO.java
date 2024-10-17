package com.test.sicredi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PesquisarCompraDTO {

    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    @NotBlank(message = "O nome é obrigatório.")
    private String nome;

    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF deve estar no formato 000.000.000-00")
    @Schema(description = "CPF no formato 000.000.000-00", example = "037.000.300-91")
    @NotBlank(message = "O cpf é obrigatório.")
    private String cpf;

    @NotNull(message = "A data de inicio não pode ser nula.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @Schema(description = "Data no formato yyyy-MM-dd HH:mm:ss.SSS", example = "2024-10-15 02:10:00.000")
    private Date dataInicial;

    @NotNull(message = "A data final não pode ser nula")
    @Schema(description = "Data no formato yyyy-MM-dd HH:mm:ss.SSS", example = "2024-10-20 02:00:00.000")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date dataFinal;

    @JsonIgnore
    @AssertTrue(message = "A data inicial não pode ser maior que a data final")
    public boolean isDataInicialMenorOuIgualDataFinal() {
        if (dataInicial == null || dataFinal == null) {
            return true;
        }
        return !dataInicial.after(dataFinal);
    }
}