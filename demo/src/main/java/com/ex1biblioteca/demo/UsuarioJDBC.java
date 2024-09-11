package com.ex1biblioteca.demo;

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