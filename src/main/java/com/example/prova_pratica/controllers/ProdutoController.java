package com.example.prova_pratica.controllers;

import com.example.prova_pratica.entities.DTO.CriarProdutoDTO;
import com.example.prova_pratica.entities.Produto;
import com.example.prova_pratica.services.ProdutoService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> criarProduto(@RequestBody CriarProdutoDTO produto){
        try{
            Produto produtoCriado = produtoService.criarProduto(produto);
            return ResponseEntity.ok(produto);
        }catch (Exception ex){
            return new ResponseEntity("Erro ao criar produto: ", HttpStatusCode.valueOf(504));
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarProdutos(){
        try{
            List<Produto> produtos = produtoService.listarProdutos();
            return ResponseEntity.ok(produtos);
        } catch (Exception ex) {
            return new ResponseEntity("Erro ao listar produtos: ", HttpStatusCode.valueOf(503));
        }
    }

}
