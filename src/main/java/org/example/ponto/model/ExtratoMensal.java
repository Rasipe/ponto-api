package org.example.ponto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.Month;
import java.time.YearMonth;
import java.util.List;

@Entity
public class ExtratoMensal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long funcionarioId;

    private YearMonth mes;

    private long horasTrabalhadas;

    List<String> diasTrabalhados;

    double valorTotal;

    public ExtratoMensal() {
    }

    public ExtratoMensal(Long funcionarioId, YearMonth mes, List<String> diasTrabalhados, long horasTrabalhadas, double valorTotal) {
        this.funcionarioId = funcionarioId;
        this.mes = mes;
        this.diasTrabalhados = diasTrabalhados;
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorTotal = valorTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Long funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public YearMonth getMes() {
        return mes;
    }

    public void setMes(YearMonth mes) {
        this.mes = mes;
    }

    public long getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(long horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public List<String> getDiasTrabalhadas() {
        return diasTrabalhados;
    }

    public void setDiasTrabalhadas(List<String> diasTrabalhados) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }
}