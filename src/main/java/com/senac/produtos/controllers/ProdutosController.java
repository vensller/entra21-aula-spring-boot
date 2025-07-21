package com.senac.produtos.controllers;

import com.senac.produtos.entities.Produto;
import com.senac.produtos.repositories.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    private List<Produto> lista;
    private final ProdutoRepository produtoRepository;

    public ProdutosController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
        Produto computador = new Produto(1, "Dell", 3000.0);
        Produto monitor = new Produto(2, "Monitor Acer", 700.0);
        Produto mouse = new Produto(3, "Mouse Logitech", 50.0);
        ArrayList<Produto> lista = new ArrayList<>();
        lista.add(computador);
        lista.add(monitor);
        lista.add(mouse);
        this.lista = lista;
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
