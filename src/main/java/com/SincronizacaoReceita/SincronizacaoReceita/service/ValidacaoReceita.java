package com.SincronizacaoReceita.SincronizacaoReceita.service;

import com.SincronizacaoReceita.SincronizacaoReceita.dto.ContaDTO;
import com.SincronizacaoReceita.SincronizacaoReceita.model.Conta;
import com.SincronizacaoReceita.SincronizacaoReceita.util.CSVConversor;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidacaoReceita {

    String ARQUIVO = "/Contas.csv";

    ContaService contaService;

    CSVConversor csvConversor;

    @Autowired
    public ValidacaoReceita(ContaService contaService, CSVConversor csvConversor) {
        this.contaService = contaService;
        this.csvConversor = csvConversor;
    }

    public List<ContaDTO> verificacaoReceita(String subPath) throws CsvException {

        String path = new StringBuffer()
                .append(subPath)
                .append(ARQUIVO)
                .toString();

        List<Conta> contas = csvConversor.conversorCSVtoConta(path);
        List<ContaDTO> contasDTO = contaService.sincronizaContaReceita(contas);

        csvConversor.gerarArquivoCSVVerificado(contasDTO, subPath);

        return contasDTO;
    }
}
