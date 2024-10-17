package com.test.sicredi.controller;


import com.test.sicredi.dto.CompraDTO;
import com.test.sicredi.dto.PesquisarCompraDTO;
import com.test.sicredi.service.CompraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/compra")
@Tag(name = "COMPRA", description = "Operações de compra.")
public class CompraController {

    @Autowired
    private CompraService compraService;


    @Operation(summary = "API para registrar uma compra.", description = "")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Registro de compra.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
            )
    })
    @RequestMapping(value = "",
            produces = {"application/json"},
            method = RequestMethod.POST)
    public ResponseEntity<Object> registrarCompra(@Valid @RequestBody CompraDTO compraDTO) {
        return compraService.registrarCompra(compraDTO);
    }

    @Operation(summary = "API para pesquisar compras por CPF do comprado, Nome do produto e período de compra.", description = "")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Registro de compra.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
            )
    })
    @RequestMapping(value = "/consulta",
            produces = {"application/json"},
            method = RequestMethod.POST)
    public ResponseEntity<Object> consultarComprasPorCpfENomeProdutoEDataInicialEDataFinal(@Valid @RequestBody PesquisarCompraDTO pesquisarCompraDTO) {
        return compraService.consultarComprasPorCpfENomeProdutoEDataInicialEDataFinal(pesquisarCompraDTO);
    }

}
