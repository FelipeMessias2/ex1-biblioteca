package com.ex1biblioteca.demo;

import java.util.List;

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

    @Override
    public List<Usuario> getAll() {
        List<Usuario> usuarios = jdbcTemplate.query("select * from usuarios",
            (rs, rowNum) -> 
                new Usuario(rs.getInt("codigo") ,rs.getString("nome"), rs.getInt("ano_nasc")));    
        return usuarios;
    }
    
    @Override
    public Usuario getUsuario(int codigo) {
        return jdbcTemplate.queryForObject("select * from usuarios where codigo = " + codigo,
            (rs, rowNum) -> 
                new Usuario(rs.getInt("codigo") ,rs.getString("nome"), rs.getInt("ano_nasc")));
    }

    @Override
    public boolean cadastraUsuario(Usuario usuario) {
        return jdbcTemplate.update("insert into usuarios (codigo, nome, ano_nasc) values (?, ?, ?)",
         usuario.getCodigo(), usuario.getNome(), usuario.getAnoDeNascimento()) == 1;
    }

    @Override
    public boolean removeUsuario(int codigo) {
        return jdbcTemplate.update("delete from usuarios where codigo = ?", codigo) == 1;
    }

    @Override
    public boolean atualizaUsuario(int codigo, String nome, int anodenascimento) {
        return jdbcTemplate.update("update usuarios set nome = ?, ano_nasc = ? where codigo = ?", nome, anodenascimento, codigo) == 1;
    }

}