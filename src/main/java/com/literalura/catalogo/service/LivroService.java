package com.literalura.catalogo.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.literalura.catalogo.client.GutendexClient;
import com.literalura.catalogo.model.Autor;
import com.literalura.catalogo.model.Livro;
import com.literalura.catalogo.repository.AutorRepository;
import com.literalura.catalogo.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivroService {

    private final LivroRepository livroRepository;
    private final GutendexClient gutendexClient;
    private final AutorRepository autorRepository;

    public LivroService(LivroRepository livroRepository, GutendexClient gutendexClient, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.gutendexClient = gutendexClient;
        this.autorRepository = autorRepository;
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        JsonNode resposta = gutendexClient.buscarLivroPorTitulo(titulo);
        System.out.println(resposta.toPrettyString());

        if (resposta != null && resposta.has("results") && resposta.get("results").size() > 0) {
            JsonNode livroJson = resposta.get("results").get(0);

            Livro livro = new Livro();
            livro.setTitulo(livroJson.get("title").asText());
            livro.setIdioma(livroJson.get("languages").get(0).asText());

            for (JsonNode autorJson : livroJson.get("authors")) {
                String autorNome = autorJson.get("name").asText();
                System.out.println("Nome do Autor: " + autorNome);

                Integer nascimento = autorJson.get("birth_year").asInt();
                System.out.println("Nascimento: " + nascimento);

                Integer falecimento =  autorJson.get("death_year").asInt();
                System.out.println("Falecimento: " + falecimento);

                Autor autor = autorRepository.findByNome(autorNome);
                if (autor == null) {
                    autor = new Autor();
                    autor.setNome(autorNome);
                    autor.setNascimento(String.valueOf(nascimento));
                    autor.setFalecimento(String.valueOf(falecimento));

                    autorRepository.save(autor);
                }

                livro.setAutor(autor);
            }

            return livroRepository.save(livro);
        }

        throw new RuntimeException("Livro não encontrado.");
    }

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    public List<Livro> listarPorIdioma(String idioma) {
        return livroRepository.findByIdioma(idioma);
    }

    public List<Autor> listarAutores() {
        List<Autor> autores = autorRepository.findAll();

        return autores;
    }

    public List<Autor> listarAutoresPorAno(String ano) {
        String dataInicio = ano + "-01-01";
        String dataFim = ano + "-12-31";

        return autorRepository.findByNascimentoBeforeAndFalecimentoAfter(dataInicio, dataFim);
    }
}
