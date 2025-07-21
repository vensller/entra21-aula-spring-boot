package com.senac.produtos.controllers;

import com.senac.produtos.entities.Produto;
import com.senac.produtos.repositories.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    private final ProdutoRepository produtoRepository;

    public ProdutosController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping
    public List<Produto> listar() {
        return this.produtoRepository.findAll();
    }

    @GetMapping("/{idProduto}")
    public Produto buscarProduto(@PathVariable Integer idProduto) {
        return this.produtoRepository.findById(idProduto).get();
    }

    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto) {
        this.produtoRepository.save(produto);
        return produto;
    }

    @PutMapping("/{idProduto}")
    public Produto alterarProduto(
            @PathVariable Integer idProduto,
            @RequestBody Produto produto
    ) {
        Produto alterar = this.produtoRepository.findById(idProduto).get();

        alterar.setNome(produto.getNome());
        alterar.setPreco(produto.getPreco());

        this.produtoRepository.save(alterar);

        return alterar;
    }

    @DeleteMapping("/{idProduto}")
    public Produto removerProduto(@PathVariable Integer idProduto) {
        Produto produto = this.produtoRepository.findById(idProduto).get();

        this.produtoRepository.deleteById(idProduto);

        return produto;
    }
}
