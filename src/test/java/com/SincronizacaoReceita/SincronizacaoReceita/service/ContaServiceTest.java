package com.SincronizacaoReceita.SincronizacaoReceita.service;

import com.SincronizacaoReceita.SincronizacaoReceita.builder.ContaBuilder;
import com.SincronizacaoReceita.SincronizacaoReceita.dto.ContaDTO;
import com.SincronizacaoReceita.SincronizacaoReceita.dto.ContaMapperImpl;
import com.SincronizacaoReceita.SincronizacaoReceita.model.Conta;
import com.SincronizacaoReceita.SincronizacaoReceita.receitaMock.ReceitaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class ContaServiceTest {


    @InjectMocks @Spy
    ContaService contaService = new ContaService(new ContaMapperImpl());

    @Test
    public void sincronizaContaReceita_Sucesso() {

        Conta conta1 = ContaBuilder.umaConta()
                .comAgencia("0101").comConta("12225-6").comSaldo(100.00).comStatus("A").build();
        Conta conta2 = ContaBuilder.umaConta()
                .comAgencia("0101").comConta("12226-8").comSaldo(3200.50).comStatus("A").build();
        Conta conta3 = ContaBuilder.umaConta()
                .comAgencia("3202").comConta("40011-1").comSaldo(-35.12).comStatus("I").build();

        List<Conta> contas = Arrays.asList(conta1, conta2, conta3);

        List<ContaDTO> contasVerificadas = contaService.sincronizaContaReceita(contas);

        Assertions.assertTrue(contasVerificadas.stream().allMatch(ContaDTO::isStatusReceita));
    }

    @Test
    public void sincronizaContaReceita_StatusReceitaFalse() {

        Conta conta1 = ContaBuilder.umaConta()
                .comAgencia("0101").comConta("999999999").comSaldo(100.00).comStatus("A").build();
        Conta conta2 = ContaBuilder.umaConta()
                .comAgencia("0101").comConta("12226-8").comSaldo(3200.50).comStatus("A").build();
        Conta conta3 = ContaBuilder.umaConta()
                .comAgencia("3202").comConta("40011-1").comSaldo(-35.12).comStatus("I").build();

        List<Conta> contas = Arrays.asList(conta1, conta2, conta3);

        List<ContaDTO> contasVerificadas = contaService.sincronizaContaReceita(contas);

        Assertions.assertFalse(contasVerificadas.stream().allMatch(ContaDTO::isStatusReceita));
    }
}
