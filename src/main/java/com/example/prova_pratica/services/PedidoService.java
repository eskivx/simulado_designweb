package com.example.prova_pratica.services;

import com.example.prova_pratica.entities.DTO.AlterarPedidoDTO;
import com.example.prova_pratica.entities.DTO.AlterarProdutosdePedidoDTO;
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

    public AlterarPedidoDTO alterarPedido(AlterarPedidoDTO alterarPedidoDTO) throws Exception {
        Optional<Pedido> pedido = pedidoRepository.findById(alterarPedidoDTO.getId());
        if (Optional.ofNullable(pedido).isPresent()) {
            pedido.get().setValorTotal(alterarPedidoDTO.getValorTotal());
            pedido.get().setProdutos(alterarPedidoDTO.getProdutos());
            pedidoRepository.save(pedido.get());
            return alterarPedidoDTO;


        }
        throw new Exception("pedido não encontrado");
    }

    public AlterarProdutosdePedidoDTO alterarProdutosdePedido(AlterarProdutosdePedidoDTO alterarProdutosdePedidoDTO) throws Exception {
        Optional<Pedido> pedido = pedidoRepository.findById(alterarProdutosdePedidoDTO.getId());
        if (Optional.ofNullable(pedido).isPresent()) {
            pedido.get().setProdutos(alterarProdutosdePedidoDTO.getProdutos());
            pedidoRepository.save(pedido.get());
            return alterarProdutosdePedidoDTO;
        }
        throw new Exception("pedido não encontrado");
    }

    public void excluirPedido(Long id) throws Exception {
        pedidoRepository.deleteById(id);
    }

}
