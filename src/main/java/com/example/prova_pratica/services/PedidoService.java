package com.example.prova_pratica.services;

import com.example.prova_pratica.entities.DTO.CriarPedidoDTO;
import com.example.prova_pratica.entities.DTO.CriarProdutoDTO;
import com.example.prova_pratica.entities.Pedido;
import com.example.prova_pratica.entities.Produto;
import com.example.prova_pratica.repository.PedidoRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final ProdutoService produtoService;
    private PedidoRepository pedidoRepository;
    public PedidoService(PedidoRepository pedidoRepository, ProdutoService produtoService){
        this.pedidoRepository = pedidoRepository;
        this.produtoService = produtoService;
    }



    public Pedido criarPedido(CriarPedidoDTO criarPedidoDTO) throws Exception {
        Pedido pedido = new Pedido();
        pedido.setValorTotal(criarPedidoDTO.getValorTotal());


        List<Produto> produtos = new ArrayList<>();


        for (CriarProdutoDTO produtoDTO : criarPedidoDTO.getProdutos()) {
            Optional<Produto> produto = produtoService.buscarProdutoPorId(produtoDTO.getId());

            if (produto.isPresent()) {
                produtos.add(produto.get());
            } else {
                throw new Exception("produto não encontrado: " + produtoDTO.getId());
            }
        }


        pedido.setProdutos(produtos);


        return pedidoRepository.save(pedido);
    }

}
