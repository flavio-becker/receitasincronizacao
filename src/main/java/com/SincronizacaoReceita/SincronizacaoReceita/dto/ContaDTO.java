package com.SincronizacaoReceita.SincronizacaoReceita.dto;

public class ContaDTO {

    private String agencia;
    private String conta;
    private double saldo;
    private String status;
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
