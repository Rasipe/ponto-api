package org.example.ponto.service;

import org.example.ponto.model.ExtratoMensal;
import org.example.ponto.model.ExtratoMensalDTO;
import org.example.ponto.model.Funcionario;
import org.example.ponto.model.Ponto;
import org.example.ponto.repository.ExtratoMensalRepository;
import org.example.ponto.repository.PontoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExtratoMensalService {

    private final ExtratoMensalRepository extratoMensalRepository;
    private final PontoRepository pontoRepository;
    private final FuncionarioService funcionarioService;

    @Autowired
    public ExtratoMensalService(ExtratoMensalRepository extratoMensalRepository, PontoRepository pontoRepository, FuncionarioService funcionarioService) {
        this.extratoMensalRepository = extratoMensalRepository;
        this.pontoRepository = pontoRepository;
        this.funcionarioService = funcionarioService;
    }

    public ExtratoMensal obterExtratoMensal(Long funcionarioId, int mes, int ano) {
        YearMonth mesAtual = YearMonth.of(ano, mes);

        List<Ponto> pontosMesAtual = pontoRepository.buscarPontosDoMes(funcionarioId, ano, mes);
        List<String> diasTrabalhados = pontosMesAtual.stream()
                .map(ponto -> ponto.getDataHora().toString())
                .collect(Collectors.toList());

        Funcionario funcionario = funcionarioService.obterFuncionario(funcionarioId);
        double valorHora = funcionario.getValorHora();

        long horasTotais = 0;

        for (Ponto ponto : pontosMesAtual) {
            LocalTime horaEntrada = ponto.getEntrada();
            LocalTime horaSaida = ponto.getSaida();
            long horasTrabalhadas = Duration.between(horaEntrada, horaSaida).toHours();
            if (ponto.getPausaAlmoco() > 0) {
                horasTrabalhadas -= ponto.getPausaAlmoco();
            }
            horasTotais += horasTrabalhadas;
        }

        double valorTotal = horasTotais * valorHora;

        return new ExtratoMensal(funcionarioId, mesAtual, diasTrabalhados, horasTotais, valorTotal);
    }


}
