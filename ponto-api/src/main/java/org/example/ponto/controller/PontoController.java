package org.example.ponto.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import org.example.ponto.model.Ponto;
import org.example.ponto.model.PontoDTO;
import org.example.ponto.service.PontoService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)
@RestController
@RequestMapping("/ponto")
public class PontoController {

    private final PontoService pontoService;

    public PontoController(PontoService pontoService) {
        this.pontoService = pontoService;
    }

    @PostMapping
    public ResponseEntity<Ponto> registrarPonto(@RequestBody PontoDTO pontoDTO) {
        Ponto ponto = pontoService.registrarPonto(pontoDTO);
        return ResponseEntity.ok(ponto);
    }

    @PostMapping("/varios")
    public ResponseEntity<List<Ponto>> adicionarPontos(@RequestBody List<Ponto> pontos) {
        List<Ponto> pontosAdicionados = pontoService.adicionarPontos(pontos);
        return ResponseEntity.ok(pontosAdicionados);
    }

    @GetMapping("/funcionario/{funcionarioId}")
    public List<Ponto> buscarPontosDoFuncionario(@PathVariable Long funcionarioId) {
        return pontoService.buscarPontosDoFuncionario(funcionarioId);
    }

    @GetMapping("/funcionario/{funcionarioId}/ultimos")
    public ResponseEntity<List<Ponto>> buscarUltimosPontos(@PathVariable Long funcionarioId, @RequestParam String quantidade) {
        List<Ponto> ultimosPontos = pontoService.buscarUltimosPontos(funcionarioId, Integer.parseInt(quantidade));
        return ResponseEntity.ok(ultimosPontos);
    }
}