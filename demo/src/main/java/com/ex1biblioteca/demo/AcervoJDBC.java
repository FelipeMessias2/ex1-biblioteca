package com.ex1biblioteca.demo;

import java.util.List;

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
        return jdbcTemplate.query("select * from livros",
         new LivroRowMapper());
    }

    @Override
    public List<String> getTitulos() {
        return jdbcTemplate.query("select titulo from livros",
         new TituloRowMapper());
    }

    @Override
    public List<String> getAutores() {
        return jdbcTemplate.query("select autor from livros",
         new AutorRowMapper());
    }

    @Override
    public List<Livro> getLivrosDoAutor(String autor) {
        return jdbcTemplate.query("select * from livros where autor = ?",
         new LivroRowMapper(), autor);
    }

    @Override
    public Livro getLivroTitulo(String titulo) {
        return jdbcTemplate.queryForObject("select * from livros where titulo = ?",
         new LivroRowMapper(), titulo);
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

    
}