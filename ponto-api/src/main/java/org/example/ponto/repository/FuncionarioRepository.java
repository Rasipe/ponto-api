package org.example.ponto.repository;

import org.example.ponto.model.Funcionario;
import org.example.ponto.model.FuncionarioDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Funcionario save(Funcionario funcionario);

    List<Funcionario> findAll();
}
