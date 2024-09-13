package com.ex1biblioteca.demo;

public class Livro {
    private long id;
    private String titulo;
    private String autor;
    private int ano;
    private int cod_usuario;

    public Livro(long id, String titulo, String autor, int ano, int cod_usuario) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.cod_usuario = cod_usuario;
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

    public int getCod_usuario() {
        return cod_usuario;
    }

    @Override
    public String toString() {
        return "Livro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", ano=" + ano + ", cod_usuario=" + cod_usuario + "]";
    }
    
}