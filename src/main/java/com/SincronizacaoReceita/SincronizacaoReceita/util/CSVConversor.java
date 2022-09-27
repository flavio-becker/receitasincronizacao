package com.SincronizacaoReceita.SincronizacaoReceita.util;

import com.SincronizacaoReceita.SincronizacaoReceita.dto.ContaDTO;
import com.SincronizacaoReceita.SincronizacaoReceita.model.Conta;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;

@Service
public class CSVConversor {

    public List<Conta> conversorCSVtoConta(String path) throws CsvException {

        ColumnPositionMappingStrategy mappingStrategy =
                new ColumnPositionMappingStrategy();
        mappingStrategy.setType(Conta.class);

        try {
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
        } catch (Exception ex) {
            throw new CsvException("Não foi possivel ler o arquivo CSV. Verifique os dados de origem.");
        }
    }

    public void gerarArquivoCSVVerificado(List<ContaDTO> contas) throws CsvException {
        final String path = "C:/VerificacaoReceita/ContasVerificadas.csv";

        ColumnPositionMappingStrategy mappingStrategy =
                new ColumnPositionMappingStrategy();
        mappingStrategy.setType(ContaDTO.class);

        try {
            Writer writer = new FileWriter(path);
            StatefulBeanToCsv<ContaDTO> csvWriter = new StatefulBeanToCsvBuilder<ContaDTO>(writer)
                    .withSeparator(';')
                    .withMappingStrategy(mappingStrategy)
                    .withApplyQuotesToAll(false)
                    .build();

            csvWriter.write(contas);
            writer.close();
        } catch (Exception ex) {
            throw new CsvException("Não foi possivel gerar o arquivo CSV. Verifique os dados de origem.");
        }
    }
}