package com.example.prova_pratica.entities.DTO;

public class CriarProdutoDTO {

    private String nome;
    private Long preco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getPreco() {
        return preco;
    }

    public void setPreco(Long preco) {
        this.preco = preco;
    }
}