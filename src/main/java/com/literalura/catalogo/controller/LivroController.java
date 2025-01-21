package com.literalura.catalogo.controller;

import com.literalura.catalogo.model.Autor;
import com.literalura.catalogo.model.Livro;
import com.literalura.catalogo.service.LivroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping("/buscar")
    public Livro buscarLivro(@RequestParam String titulo) {
        return livroService.buscarLivroPorTitulo(titulo);
    }

    @GetMapping("/todos")
    public List<Livro> listarTodos() {
        return livroService.listarTodos();
    }

    @GetMapping("/idioma")
    public List<Livro> listarPorIdioma(@RequestParam String idioma) {
        return livroService.listarPorIdioma(idioma);
    }

    @GetMapping("/autores/{ano}")
    public List<Autor> listarAutoresPorAno(@PathVariable String ano) {
        return livroService.listarAutoresPorAno(ano);
    }

    @GetMapping("/buscarAutores")
    public List<Autor> listarAutoreso() {
        return livroService.listarAutores();
    }
}
