package com.SincronizacaoReceita.SincronizacaoReceita.util;

import com.SincronizacaoReceita.SincronizacaoReceita.dto.ContaDTO;
import com.SincronizacaoReceita.SincronizacaoReceita.model.Conta;
import com.opencsv.CSVWriter;
import com.opencsv.CSVWriterBuilder;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Service
public class CSVConversor {

    public List<Conta> conversorCSVtoConta(String path) throws IOException {

        ColumnPositionMappingStrategy mappingStrategy =
                new ColumnPositionMappingStrategy();
        mappingStrategy.setType(Conta.class);

        List<Conta> contas = new CsvToBeanBuilder(new FileReader(path))
                .withType(Conta.class)
                .withMappingStrategy(mappingStrategy)
                .withSeparator(';')
                .withIgnoreLeadingWhiteSpace(true)
                .withIgnoreEmptyLine(true)
                .withSkipLines(1)
                .build()
                .parse();

        return contas;
    }

    public void gerarArquivoCSVVerificado(List<ContaDTO> contas) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        final String path = "C:/VerificacaoReceita/ContasVerificadas.csv";

        ColumnPositionMappingStrategy mappingStrategy =
                new ColumnPositionMappingStrategy();
        mappingStrategy.setType(ContaDTO.class);

        Writer writer = new FileWriter(path);
        StatefulBeanToCsv<ContaDTO> csvWriter = new StatefulBeanToCsvBuilder<ContaDTO>(writer)
                .withSeparator(';')
                .withMappingStrategy(mappingStrategy)
                .withApplyQuotesToAll(false)
                .build();

        csvWriter.write(contas);
        writer.close();
    }
}