package com.ex1biblioteca.demo;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * AcervoJDBC sla teste
 */
@Repository
public class AcervoJDBC implements IAcervo {

    private JdbcTemplate jdbcTemplate;

    public AcervoJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Livro> getAll() {
        List<Livro> livros = jdbcTemplate.query("select * from livros",
            (rs, rowNum) -> 
                new Livro(
                    rs.getInt("codigo"),
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getInt("ano"),
                    rs.getInt("cod_usuario")));    
        return livros;
    }

    @Override
    public List<String> getTitulos() {
        List<String> titulos = this.jdbcTemplate.query("SELECT titulo FROM livros", 
            (rs, rowNum) -> 
                rs.getString("titulo"));
        return titulos;
    }

    @Override
    public List<String> getAutores() {
        List<String> autores = this.jdbcTemplate.query("SELECT autor FROM livros", 
            (rs, rowNum) -> 
                rs.getString("autor"));
        return autores;   
    }

    @Override
    public List<Livro> getLivrosDoAutor(String autor) {
        List<Livro> livros = jdbcTemplate.query("select * from livros where autor = " + autor,
         (rs,rownum) ->
            new Livro(
                rs.getInt("codigo"), 
                rs.getString("titulo"), 
                rs.getString("autor"),
                rs.getInt("ano"), 
                rs.getInt("cod_usuario")));
        return livros;
        }

    @Override
    public Livro getLivroTitulo(String titulo) {
        return jdbcTemplate.queryForObject("select * from livros where titulo = " + titulo,
         (rs, rowNum) -> 
            new Livro(
            rs.getInt("codigo"),
            rs.getString("titulo"),
            rs.getString("autor"), 
            rs.getInt("ano"),
            rs.getInt("cod_usuario")));
    }

    @Override
    public boolean cadastraLivroNovo(Livro livro) {
        return jdbcTemplate.update("insert into livros (titulo, autor, ano) values (?, ?, ?)",
         livro.getTitulo(), livro.getAutor(), livro.getAno()) == 1;
    }

    @Override
    public boolean removeLivro(long codigo) {
        return jdbcTemplate.update("delete from livros where codigo = ?", codigo) == 1;
    }

    @Override
    public boolean retiraLivro(int codUsuario, int codLivro) {
        return jdbcTemplate.update("UPDATE livros SET cod_usuario = ? WHERE codigo = ?", codUsuario, codLivro) == 1;
    }
}