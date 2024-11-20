package com.example.prova_pratica.services;

import com.example.prova_pratica.entities.DTO.CriarPedidoDTO;
import com.example.prova_pratica.entities.Pedido;
import com.example.prova_pratica.repository.PedidoRepository;

import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private PedidoRepository pedidoRepository;
    public PedidoService(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido criarPedido(CriarPedidoDTO criarPedidoDTO) throws Exception{
        Pedido pedido = new Pedido();
        pedido.setProdutos(criarPedidoDTO.getProdutos());

        return pedidoRepository.save(pedido);
    }
}
