package com.senac.produtos.controllers;

import com.senac.produtos.entities.Produto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    private List<Produto> lista;

    public ProdutosController() {
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
        return lista;
    }

    @GetMapping("/{idProduto}")
    public Produto buscarProduto(@PathVariable Integer idProduto) {
        for (Produto produto: lista) {
            if (Objects.equals(produto.getId(), idProduto)) {
                return produto;
            }
        }

        return null;
    }

    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto) {
        produto.setId(new Random().nextInt());
        lista.add(produto);
        return produto;
    }

    @PutMapping("/{idProduto}")
    public Produto alterarProduto(
            @PathVariable Integer idProduto,
            @RequestBody Produto produto
    ) {
        for (Produto alterar: lista) {
            if (alterar.getId().equals(idProduto)) {
                alterar.setNome(produto.getNome());
                alterar.setPreco(produto.getPreco());
                return alterar;
            }
        }
        return null;
    }

    @DeleteMapping("/{idProduto}")
    public Produto removerProduto(@PathVariable Integer idProduto) {
        for (Produto remover: lista) {
            if (remover.getId().equals(idProduto)) {
                lista.remove(remover);
                return remover;
            }
        }
        return null;
    }
}
