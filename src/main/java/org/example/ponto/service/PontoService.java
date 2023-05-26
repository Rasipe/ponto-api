package org.example.ponto.service;

import org.example.ponto.model.Ponto;
import org.example.ponto.model.PontoDTO;
import org.example.ponto.repository.PontoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PontoService {

    private final PontoRepository pontoRepository;

    @Autowired
    public PontoService(PontoRepository pontoRepository) {
        this.pontoRepository = pontoRepository;
    }

    public Ponto registrarPonto(PontoDTO pontoDTO) {
        Ponto ponto = new Ponto();
        BeanUtils.copyProperties(pontoDTO, ponto);
        return pontoRepository.save(ponto);
    }

    public List<Ponto> buscarPontosDoFuncionario(Long funcionarioId) {
        return pontoRepository.findByFuncionarioId(funcionarioId);
    }

    public List<Ponto> adicionarPontos(List<Ponto> pontos) {
        List<Ponto> pontosAdicionados = new ArrayList<>();
        for (Ponto ponto : pontos) {
            pontosAdicionados.add(pontoRepository.save(ponto));
        }
        return pontosAdicionados;
    }

    public List<Ponto> buscarUltimosPontos(Long funcionarioId, int quantidade) {
        Pageable pageable = PageRequest.of(0, quantidade, Sort.Direction.DESC, "dataHora");
        return pontoRepository.buscarUltimosPontos(funcionarioId, pageable);
    }
}
