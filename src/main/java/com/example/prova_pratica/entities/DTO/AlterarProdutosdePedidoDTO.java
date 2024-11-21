package com.example.prova_pratica.entities.DTO;

import com.example.prova_pratica.entities.Produto;

import java.util.List;

public class AlterarProdutosdePedidoDTO {
    private Long id;
    private List<Produto> produtos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
