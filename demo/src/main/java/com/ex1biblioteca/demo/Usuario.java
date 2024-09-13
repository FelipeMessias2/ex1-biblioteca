package com.ex1biblioteca.demo;

public class Usuario {
    
    private int Codigo;
    private String Nome;
    private int anodenascimento;

    public Usuario(int Codigo, String Nome, int anodenascimento) {
        this.Codigo = Codigo;
        this.Nome = Nome;
        this.anodenascimento = anodenascimento;
    }

    public int getCodigo() {
        return Codigo;
    }

    public String getNome() {
        return Nome;
    }

    public int getAnoDeNascimento() {
        return anodenascimento;
    }

    @Override
    public String toString() {
        return "Usuario [Codigo=" + Codigo + ", Nome=" + Nome + ", anodenascimento=" + anodenascimento + "]";
    }

}
