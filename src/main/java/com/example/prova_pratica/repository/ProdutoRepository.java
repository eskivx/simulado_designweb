package com.example.prova_pratica.repository;

import com.example.prova_pratica.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
