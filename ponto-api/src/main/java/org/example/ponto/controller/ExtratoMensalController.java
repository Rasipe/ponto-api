package org.example.ponto.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import org.example.ponto.model.ExtratoMensal;
import org.example.ponto.service.ExtratoMensalService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/extrato-mensal")
public class ExtratoMensalController {

    private final ExtratoMensalService extratoMensalService;

    public ExtratoMensalController(ExtratoMensalService extratoMensalService) {
        this.extratoMensalService = extratoMensalService;
    }

    @GetMapping("/{funcionarioId}")
    public ResponseEntity<ExtratoMensal> obterExtratoMensal(@PathVariable Long funcionarioId, @RequestParam int mes, @RequestParam int ano) {
        ExtratoMensal extratoMensal = extratoMensalService.obterExtratoMensal(funcionarioId, mes, ano);
        return ResponseEntity.ok(extratoMensal);
    }
}
