package com.ex1biblioteca.demo;

public class Livro {
    private long id;
    private String titulo;
    private String autor;
    private int ano;
    private int codUsuario;

    public Livro(long id, String titulo, String autor, int ano, int codUsuario) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.codUsuario = codUsuario;
    }

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }
    
    public int getCodUsuario() {
        return codUsuario;
    }

    @Override
    public String toString() {
        return "Livro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", ano=" + ano + ", codUsuario=" + codUsuario + "]";
    }
    
}