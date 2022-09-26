package com.SincronizacaoReceita.SincronizacaoReceita.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvNumber;

public class Conta {

    @CsvBindByPosition(position = 0)
    private String agencia;

    @CsvBindByPosition(position = 1)
    private String conta;

    @CsvBindByPosition(position = 2, locale = "pt-BR")
    @CsvNumber("#0,0#")
    private double saldo;

    @CsvBindByPosition(position = 3)
    private String status;

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
