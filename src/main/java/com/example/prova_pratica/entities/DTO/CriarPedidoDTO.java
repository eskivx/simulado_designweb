package com.example.prova_pratica.entities.DTO;

import com.example.prova_pratica.entities.Pedido;
import com.example.prova_pratica.entities.Produto;

import java.util.List;

public class CriarPedidoDTO {
    private List<Produto> produtos;

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
