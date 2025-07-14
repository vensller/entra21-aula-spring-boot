package com.senac.produtos.controllers;

import com.senac.produtos.entities.Produto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
}
