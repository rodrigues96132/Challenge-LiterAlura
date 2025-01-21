package com.literalura.catalogo.repository;

import com.literalura.catalogo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findByNascimentoBeforeAndFalecimentoAfter(String nascimento, String falecimento);
    Autor findByNome(String nome);

}
