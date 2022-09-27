package com.SincronizacaoReceita.SincronizacaoReceita.builder;

import com.SincronizacaoReceita.SincronizacaoReceita.model.Conta;

public class ContaBuilder {

    private Conta conta;

    private ContaBuilder() {}

    public static ContaBuilder umaConta() {
        ContaBuilder builder = new ContaBuilder();
        builder.conta = new Conta();

        return builder;
    }

    public ContaBuilder comAgencia(String agencia) {
        conta.setAgencia(agencia);
        return this;
    }

    public ContaBuilder comConta(String cta) {
        conta.setConta(cta);
        return this;
    }

    public ContaBuilder comSaldo(double saldo) {
        conta.setSaldo(saldo);
        return this;
    }

    public ContaBuilder comStatus(String status) {
        conta.setStatus(status);
        return this;
    }

    public Conta build() {
        return this.conta;
    }

}
