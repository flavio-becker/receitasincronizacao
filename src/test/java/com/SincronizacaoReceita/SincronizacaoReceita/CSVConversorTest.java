package com.SincronizacaoReceita.SincronizacaoReceita;

import com.SincronizacaoReceita.SincronizacaoReceita.util.CSVConversor;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class CSVConversorTest {

    @InjectMocks
    CSVConversor csvLeitor;

    /*@Test
    public void converterCSVtoObject() throws CsvException {

        String path = "C:/Users/flavi/OneDrive/Área de Trabalho/testetesteCSV.csv";
       //String path = "C:/Users/flavi/OneDrive/Área de Trabalho/testetesteCSV2.csv";

        List<Conta> contaDTOS = csvLeitor.conversorCSVtoConta(path);

        Assertions.assertTrue(true);
    }*/
}
