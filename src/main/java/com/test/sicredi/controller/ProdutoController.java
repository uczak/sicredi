package com.test.sicredi.controller;


import com.test.sicredi.dto.ProdutoDTO;
import com.test.sicredi.entities.Produto;
import com.test.sicredi.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/produto")
@Tag(name = "PRODUTO", description = "Operações de produto.")
public class ProdutoController {


    @Autowired
    private ProdutoService produtoService;

    @Operation(summary = "API para consultar todos os registros da tabela produto.", description = "")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Lista de registros da tabela produto.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Produto.class))
            )
    })
    @RequestMapping(value = "/list/all",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<List<Produto>> findAll() {

        List<Produto> list = produtoService.findAll();
        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @Operation(summary = "API para consultar um produto pelo id.", description = "")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Registro da tabela produto.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Produto.class))
            )
    })
    @RequestMapping(value = "/{id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<Produto> findById(@PathVariable("id") Long produtoId) {
        Produto produto = produtoService.findById(produtoId);
        if (produto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(produto);
    }

    @Operation(summary = "API para criar um registro de produto.", description = "")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Registro da tabela produto.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Produto.class))
            )
    })
    @RequestMapping(value = "",
            produces = {"application/json"},
            method = RequestMethod.POST)
    public ResponseEntity<Produto> save(@Valid @RequestBody ProdutoDTO produtoDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.save(produtoDTO.getProduto()));
    }
}
