package com.example.prova_pratica.services;

import com.example.prova_pratica.entities.DTO.CriarProdutoDTO;
import com.example.prova_pratica.entities.Produto;
import com.example.prova_pratica.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;
    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public Produto criarProduto(CriarProdutoDTO criarProdutoDTO) throws Exception{
        Produto produto = new Produto();
        produto.setNome(criarProdutoDTO.getNome());
        produto.setPreco(criarProdutoDTO.getPreco());

        return produtoRepository.save(produto);
    }

    public Optional<Produto> buscarProdutoPorId(Long id){
        return produtoRepository.findById(id);
    }

    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }
}
