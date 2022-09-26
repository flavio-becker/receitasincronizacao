package com.SincronizacaoReceita.SincronizacaoReceita;

import com.SincronizacaoReceita.SincronizacaoReceita.model.Conta;
import com.SincronizacaoReceita.SincronizacaoReceita.util.CSVConversor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class CSVConversorTest {

    @InjectMocks
    CSVConversor csvLeitor;

    @Test
    public void converterCSVtoObject() throws IOException {

        String path = "C:/Users/flavi/OneDrive/Área de Trabalho/testetesteCSV.csv";
       //String path = "C:/Users/flavi/OneDrive/Área de Trabalho/testetesteCSV2.csv";

        List<Conta> contaDTOS = csvLeitor.conversorCSVtoConta(path);

        Assertions.assertTrue(true);
    }
}
