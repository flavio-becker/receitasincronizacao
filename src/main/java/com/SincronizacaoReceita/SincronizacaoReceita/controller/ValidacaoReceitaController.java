package com.SincronizacaoReceita.SincronizacaoReceita.controller;

import com.SincronizacaoReceita.SincronizacaoReceita.dto.ContaDTO;
import com.SincronizacaoReceita.SincronizacaoReceita.model.Conta;
import com.SincronizacaoReceita.SincronizacaoReceita.util.CSVConversor;
import com.SincronizacaoReceita.SincronizacaoReceita.service.ContaService;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/verificacontas")
public class ValidacaoReceitaController {

    ContaService contaService;

    CSVConversor csvConversor;

    @Autowired
    public ValidacaoReceitaController(ContaService contaService, CSVConversor csvConversor) {
        this.contaService = contaService;
        this.csvConversor = csvConversor;
    }

    @PostMapping
    public ResponseEntity<List<ContaDTO>> verificacaoReceita(@RequestHeader(value = "path") String path) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {

        List<Conta> contas = csvConversor.conversorCSVtoConta(path);
        List<ContaDTO> contasDTO = contaService.sincronizaContaReceita(contas);

        csvConversor.gerarArquivoCSVVerificado(contasDTO);

        return ResponseEntity.ok().body(contasDTO);
    }

}
