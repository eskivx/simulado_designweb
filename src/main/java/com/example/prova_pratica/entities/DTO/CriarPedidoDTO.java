package com.example.prova_pratica.entities.DTO;

import com.example.prova_pratica.entities.Pedido;
import com.example.prova_pratica.entities.Produto;

import java.util.List;

public class CriarPedidoDTO {
    private List<CriarProdutoDTO> produtos;
    private Long valorTotal;

    public List<CriarProdutoDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<CriarProdutoDTO> produtos) {
        this.produtos = produtos;
    }

    public Long getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Long valorTotal) {
        this.valorTotal = valorTotal;
    }
}
