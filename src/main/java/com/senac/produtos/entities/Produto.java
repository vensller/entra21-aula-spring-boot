package com.senac.produtos.entities;

public class Produto {
    private Integer id;
    private String nome;
    private Double preco;

    public Produto(Integer id, String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }
}
