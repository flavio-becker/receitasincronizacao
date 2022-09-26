package com.SincronizacaoReceita.SincronizacaoReceita.service;

import com.SincronizacaoReceita.SincronizacaoReceita.dto.ContaDTO;
import com.SincronizacaoReceita.SincronizacaoReceita.dto.ContaMapper;
import com.SincronizacaoReceita.SincronizacaoReceita.model.Conta;
import com.SincronizacaoReceita.SincronizacaoReceita.receitaMock.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContaService {

    ReceitaService receitaService = new ReceitaService();

    ContaMapper contaMapper;

    @Autowired
    public ContaService(ContaMapper contaMapper) {
        this.contaMapper = contaMapper;
    }

    public List<ContaDTO> sincronizaContaReceita(List<Conta> contas) {

        contas.forEach(conta -> conta.setConta(removerCaracteresDaConta(conta)));
        List<ContaDTO> contasDTO = contas.stream()
                .map(conta -> contaMapper.convertContaToContaDto(conta))
                .collect(Collectors.toList());

        contasDTO.stream()
                .forEach(contaDTO -> {
                    try {
                        contaDTO.setStatusReceita(verificaStatusReceita(contaDTO));
                    } catch (InterruptedException e) {
                        throw new RuntimeException();
                    }
                });

        return contasDTO;
    }

     private String removerCaracteresDaConta(Conta conta) {

        String contaFormatada = conta.getConta().replaceAll("[^0-9]", "");

        return contaFormatada;
    }

    private boolean verificaStatusReceita(ContaDTO contaDTO) throws InterruptedException {

        return receitaService.atualizarConta(contaDTO.getAgencia(), contaDTO.getConta(),
                contaDTO.getSaldo(), contaDTO.getStatus());
    }
}
