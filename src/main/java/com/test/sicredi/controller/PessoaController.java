package com.test.sicredi.controller;


import com.test.sicredi.dto.PessoaDTO;
import com.test.sicredi.entities.Pessoa;
import com.test.sicredi.entities.Produto;
import com.test.sicredi.service.PessoaService;
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
@RequestMapping("/pessoa")
@Tag(name = "PESSOA", description = "Operações de pessoa.")
public class PessoaController {


    @Autowired
    private PessoaService pessoaService;

    @Operation(summary = "API para consultar todos os registros da tabela pessoa.", description = "")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Lista de registros da tabela pessoa.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pessoa.class))
            )
    })
    @RequestMapping(value = "/list/all",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<List<Pessoa>> findAll() {

        List<Pessoa> list = pessoaService.findAll();
        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @Operation(summary = "API para consultar uma pessoa pelo cpf.", description = "")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Registro da tabela pessoa.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pessoa.class))
            )
    })
    @RequestMapping(value = "/{cpf}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<Pessoa> findById(@PathVariable("cpf") String cpf) {
        Pessoa pessoa = pessoaService.findById(cpf);
        if (pessoa == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(pessoa);
    }

    @Operation(summary = "API para criar um registro de pessoa.", description = "")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Registro da tabela pessoa.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pessoa.class))
            )
    })
    @RequestMapping(value = "",
            produces = {"application/json"},
            method = RequestMethod.POST)
    public ResponseEntity<Pessoa> save(@Valid @RequestBody PessoaDTO pessoaDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.save(pessoaDTO.getPessoa()));
    }
}
