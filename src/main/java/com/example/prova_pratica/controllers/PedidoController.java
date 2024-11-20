package com.example.prova_pratica.controllers;

import com.example.prova_pratica.entities.DTO.CriarPedidoDTO;
import com.example.prova_pratica.entities.Pedido;
import com.example.prova_pratica.services.PedidoService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService){
        this.pedidoService = pedidoService;
    }
    @PostMapping("/add")
    public ResponseEntity<?> criarPedido(@RequestBody CriarPedidoDTO pedido){
        try{
            Pedido pedidocriado = PedidoService.criarPedido(pedido);
            return ResponseEntity.ok(pedido);
        }catch (Exception ex){
            return new ResponseEntity<>("Erro ao criar pedido: ", HttpStatusCode.valueOf(504));
        }
    }
}
