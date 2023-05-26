package org.example.ponto.model;

import java.time.Month;

public class ExtratoMensalDTO {

    private Long funcionarioId;

    private Month mes;

    public Long getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Long funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public Month getMes() {
        return mes;
    }

    public void setMes(Month mes) {
        this.mes = mes;
    }
}
