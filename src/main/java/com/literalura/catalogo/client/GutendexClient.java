package com.literalura.catalogo.client;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GutendexClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public JsonNode buscarLivroPorTitulo(String titulo) {
        String url = "https://gutendex.com/books?search=" + titulo;
        return restTemplate.getForObject(url, JsonNode.class);
    }
}
