package org.example.ponto.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import org.example.ponto.model.Funcionario;
import org.example.ponto.model.FuncionarioDTO;
import org.example.ponto.service.FuncionarioService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public ResponseEntity<Funcionario> registrarOuEditarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = funcionarioService.registrarOuEditarFuncionario(funcionarioDTO);
        return ResponseEntity.ok(funcionario);
    }

    @GetMapping
    public List<Funcionario> buscarTodosFuncionarios() {
        return funcionarioService.buscarTodosFuncionarios();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirFuncionario(@PathVariable Long id) {
        funcionarioService.excluirFuncionario(id);
        return ResponseEntity.noContent().build();
    }
}
