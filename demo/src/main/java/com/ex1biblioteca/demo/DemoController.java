package com.ex1biblioteca.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private IAcervo livros;

    @Autowired
    public DemoController(IAcervo livros) {
        this.livros = livros; 
    }

    @GetMapping("")
    @CrossOrigin(origins = "*")
    public String mensagemDeBemVindo() {
        return "Bem vindo a biblioteca central!";
    }

    @GetMapping("/livros")
    @CrossOrigin(origins = "*")
    public List<Livro> getListaLivros() {
        return livros.getAll();
    }

    @GetMapping("/autores")
    @CrossOrigin(origins = "*")
    public List<String> getListaAutores() {
        return livros.getAutores();
    }

    @GetMapping("/livrosAutor")
    @CrossOrigin(origins = "*")
    public List<Livro> getLivrosDoAutor(@RequestParam(value = "autor") String autor) {
        return livros.getLivrosDoAutor(autor);
    }

    @GetMapping("/livrosautor/{autor}/ano/{ano}")
    @CrossOrigin(origins = "*")
    public List<Livro> getLivrosDoAutor(@PathVariable(value="autor") String autor, @PathVariable(value="ano")int ano) {
        return livros.getLivrosDoAutor(autor)
                .stream()
                .filter(l->l.getAno() == ano)
                .toList();
    }

    @PostMapping("/novolivro")
    @CrossOrigin(origins = "*")
    public boolean cadastraLivroNovo(@RequestBody final Livro livro) {
        return livros.cadastraLivroNovo(livro);
    }

    @GetMapping("/retira_livro/{cod_usuario}/{cod_livro}")
    @CrossOrigin(origins = "*")
    public boolean retiraLivro(@PathVariable(value="cod_usuario") int codUsuario, @PathVariable(value="cod_livro")int codLivro) {
        return livros.retiraLivro(codUsuario, codLivro);
    }

    @PostMapping("/retiralivro")
    @CrossOrigin(origins = "*")
    public boolean retiraLivro(@RequestParam(value = "codigo") int codlivro, @RequestParam(value = "coduser") int coduser) {
        return livros.retiraLivro(codlivro, coduser);
    }

    @PostMapping("/devolvelivro")
    @CrossOrigin(origins = "*")
    public boolean devolveLivro(@RequestParam(value = "codigo") int codlivro) {
        return livros.devolveLivro(codlivro);
    }

    @PostMapping("/removelivro")
    @CrossOrigin(origins = "*")
    public boolean removeLivro(@RequestParam(value = "codigo") int codlivro) {
        return livros.removeLivro(codlivro);
    }

}