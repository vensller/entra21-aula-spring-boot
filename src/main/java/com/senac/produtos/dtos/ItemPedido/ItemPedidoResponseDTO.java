package com.senac.produtos.dtos.ItemPedido;

import com.senac.produtos.entities.ItemPedido;

public class ItemPedidoResponseDTO {
    private Integer id;
    private Double quantidade;
    private Double valorUnitario;
    private PedidoResponseDTO pedido;
    private ProdutoResponseDTO produto;

    public ItemPedidoResponseDTO(ItemPedido itemPedido) {
        this.id = itemPedido.getId();
        this.quantidade = itemPedido.getQuantidade();
        this.valorUnitario = itemPedido.getValorUnitario();
        this.pedido = new PedidoResponseDTO(itemPedido.getPedido());
        this.produto = new ProdutoResponseDTO(itemPedido.getProduto());
    }

    public Integer getId() {
        return id;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public PedidoResponseDTO getPedido() {
        return pedido;
    }

    public ProdutoResponseDTO getProduto() {
        return produto;
    }
}
