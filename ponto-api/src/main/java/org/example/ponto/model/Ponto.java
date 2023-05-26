package org.example.ponto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.Temporal;

@Entity
public class Ponto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long funcionarioId;
    private LocalDateTime dataHora;
    private LocalTime entrada;
    private LocalTime saida;
    private int pausaAlmoco;

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

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public LocalTime getEntrada() { return this.entrada; }

    public void setEntrada(LocalTime entrada) { this.entrada = entrada; }

    public LocalTime getSaida() { return this.saida; }

    public void setSaida(LocalTime saida) { this.saida = saida; }

    public int getPausaAlmoco() {
        return pausaAlmoco;
    }

    public void setPausaAlmoco(int pausaAlmoco) {
        this.pausaAlmoco = pausaAlmoco;
    }
}
