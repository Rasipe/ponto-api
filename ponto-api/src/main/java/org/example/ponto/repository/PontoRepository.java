package org.example.ponto.repository;

import org.example.ponto.model.Ponto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface PontoRepository extends JpaRepository<Ponto, Long> {

    Ponto save(Ponto ponto);

    List<Ponto> findByFuncionarioId(Long funcionarioId);
    @Query("SELECT p FROM Ponto p WHERE p.funcionarioId = :funcionarioId ORDER BY p.dataHora DESC")
    List<Ponto> buscarUltimosPontos(@Param("funcionarioId") Long funcionarioId, Pageable pageable);
    @Query("SELECT p FROM Ponto p WHERE p.funcionarioId = :funcionarioId AND YEAR(p.dataHora) = :year AND MONTH(p.dataHora) = :month")
    List<Ponto> buscarPontosDoMes(@Param("funcionarioId") Long funcionarioId, @Param("year") int year, @Param("month") int month);

}
