package com.SincronizacaoReceita.SincronizacaoReceita.service;

import com.SincronizacaoReceita.SincronizacaoReceita.dto.ContaDTO;
import com.SincronizacaoReceita.SincronizacaoReceita.dto.ContaMapper;
import com.SincronizacaoReceita.SincronizacaoReceita.exception.ReceitaSincronizacaoException;
import com.SincronizacaoReceita.SincronizacaoReceita.model.Conta;
import com.SincronizacaoReceita.SincronizacaoReceita.receitaMock.ReceitaService;
import com.SincronizacaoReceita.SincronizacaoReceita.util.CSVConversor;
import com.opencsv.exceptions.CsvException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContaService {

    private static final Logger LOG = LoggerFactory.getLogger(ContaService.class);

    ReceitaService receitaService = new ReceitaService();

    ContaMapper contaMapper;

    @Autowired
    public ContaService(ContaMapper contaMapper) {
        this.contaMapper = contaMapper;
    }

    public List<ContaDTO> sincronizaContaReceita(List<Conta> contas) {

        return contas.stream()
                .map(conta -> contaMapper.convertContaToContaDto(conta))
                .peek(contaDTO -> contaDTO.setStatusReceita(verificaStatusReceita(contaDTO)))
                .collect(Collectors.toList());
    }

    private boolean verificaStatusReceita(ContaDTO contaDTO)  {

        LOG.info("Enciando conta para verificação na Receita " + contaDTO);

        try{
            return receitaService.atualizarConta(contaDTO.getAgencia(), contaDTO.getConta().replaceAll("[^0-9]", ""),
                    contaDTO.getSaldo(), contaDTO.getStatus());
        } catch (RuntimeException e) {
            throw new ReceitaSincronizacaoException("Erro ao sincronizar com a Receita. Verifique o arquivo CSV e tente novamente.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ReceitaSincronizacaoException("Erro ao sincronizar com a Receita. Tente novamente.");
        }
    }
}
