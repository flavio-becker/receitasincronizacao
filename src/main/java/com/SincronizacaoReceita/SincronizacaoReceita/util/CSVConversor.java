package com.SincronizacaoReceita.SincronizacaoReceita.util;

import com.SincronizacaoReceita.SincronizacaoReceita.model.Conta;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Service
public class CSVConversor {

    public List<Conta> conversorCSVtoConta(String path) throws IOException {

        List<Conta> contas = new CsvToBeanBuilder(new FileReader(path))
                .withType(Conta.class)
                .withSeparator(';')
                .build()
                .parse();

        return contas;
    }
}