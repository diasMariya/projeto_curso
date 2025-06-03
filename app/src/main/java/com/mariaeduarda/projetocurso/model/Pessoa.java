package com.mariaeduarda.projetocurso.model;

public class Pessoa {

    private String primeiroNome;
    private String sobrenome;
    private String telefone;
    private String cursoDesejado;

    public Pessoa(){}
    public Pessoa(String primeiroNome, String sobrenome, String telefone, String cursoDesejado) {
        this.primeiroNome = primeiroNome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.cursoDesejado = cursoDesejado;
    }
    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getCursoDesejado() {
        return cursoDesejado;
    }
    public void setCursoDesejado(String cursoDesejado) {
        this.cursoDesejado = cursoDesejado;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "primeiroNome='" + primeiroNome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cursoDesejado='" + cursoDesejado + '\'' +
                '}';
    }
}
