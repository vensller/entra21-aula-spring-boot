package com.senac.produtos.dtos.ItemPedido;

import com.senac.produtos.entities.Produto;

public class ProdutoResponseDTO {
    private String nome;
    private Double preco;

    public ProdutoResponseDTO(Produto produto) {
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }
}
