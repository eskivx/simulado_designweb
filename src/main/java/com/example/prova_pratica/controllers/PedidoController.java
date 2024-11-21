package com.example.prova_pratica.controllers;

import com.example.prova_pratica.entities.DTO.AlterarPedidoDTO;
import com.example.prova_pratica.entities.DTO.AlterarProdutosdePedidoDTO;
import com.example.prova_pratica.entities.DTO.CriarPedidoDTO;
import com.example.prova_pratica.entities.Pedido;
import com.example.prova_pratica.services.PedidoService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            Pedido pedidocriado = pedidoService.criarPedido(pedido);
            return ResponseEntity.ok(pedido);
        }catch (Exception ex){
            return new ResponseEntity<>("Erro ao criar pedido: ", HttpStatusCode.valueOf(504));
        }
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterarPedido(@RequestBody AlterarPedidoDTO pedido){
        try{
            pedido = pedidoService.alterarPedido(pedido);
            return ResponseEntity.ok(pedido);
        } catch (Exception ex){
            return new ResponseEntity("Erro ao alterar pedido: ", HttpStatusCode.valueOf(504));
        }
    }

    @PatchMapping("/alterar/produtos")
    public ResponseEntity<?> alterarProdutoDePedido(@RequestBody AlterarProdutosdePedidoDTO pedido){
        try{
            pedido = pedidoService.alterarProdutosdePedido(pedido);
            return ResponseEntity.ok(pedido);
        } catch (Exception ex){
            return new ResponseEntity("Erro ao alterar pedido: ", HttpStatusCode.valueOf(504));
        }
    }
}
