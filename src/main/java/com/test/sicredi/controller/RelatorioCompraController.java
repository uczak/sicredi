package com.test.sicredi.controller;


import com.test.sicredi.service.RelatorioCompraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/relatorio")
@Tag(name = "RELATÓRIO", description = "Relatório de compras.")
public class RelatorioCompraController {

    @Autowired
    private RelatorioCompraService relatorioCompraService;


    @Operation(summary = "API para gerar um relatório de compras diário, agrupador por produto.", description = "")
    @RequestMapping(value = "",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<byte[]> relatorioCompras() {
        return relatorioCompraService.relatorioCompras();
    }


}
