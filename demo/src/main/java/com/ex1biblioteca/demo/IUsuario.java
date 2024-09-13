package com.ex1biblioteca.demo;

import java.util.List;

/**
 * IUsuario
 */
public interface IUsuario {

    List<Usuario> getAll();
    Usuario getUsuario(int codigo);
    boolean cadastraUsuario(Usuario usuario);
    boolean removeUsuario(int codigo);
    boolean atualizaUsuario(int codigo, String nome, int anodenascimento);
    
}