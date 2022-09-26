package com.SincronizacaoReceita.SincronizacaoReceita.dto;

import com.opencsv.bean.CsvBindByPosition;

public class ContaDTO {

    @CsvBindByPosition(position = 0)
    private String agencia;

    @CsvBindByPosition(position = 1)
    private String conta;

    @CsvBindByPosition(position = 2)
    private double saldo;

    @CsvBindByPosition(position = 3)
    private String status;

    @CsvBindByPosition(position = 4)
    private boolean statusReceita;

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

    public boolean isStatusReceita() {
        return statusReceita;
    }

    public void setStatusReceita(boolean statusReceita) {
        this.statusReceita = statusReceita;
    }
}
