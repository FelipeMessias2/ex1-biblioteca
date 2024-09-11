package com.ex1biblioteca.demo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * UsuarioJDBC
 */
@Repository
public class UsuarioJDBC implements IUsuario {

    // private int Codigo;
    // private String Nome;
    // private int anodenascimento;

    private JdbcTemplate jdbcTemplate;

    public UsuarioJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
}