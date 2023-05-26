package org.example.ponto.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import org.example.ponto.model.Funcionario;
import org.example.ponto.model.FuncionarioDTO;
import org.example.ponto.service.FuncionarioService;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public ResponseEntity<Funcionario> registrarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = funcionarioService.registrarFuncionario(funcionarioDTO);
        return ResponseEntity.ok(funcionario);
    }

    @GetMapping
    public List<Funcionario> buscarTodosFuncionarios() {
        return funcionarioService.buscarTodosFuncionarios();
    }
}
