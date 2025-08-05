package com.senac.produtos.dtos.ItemPedido;

public class ItemPedidoRequestDTO {

    private Integer idPedido;
    private Integer idProduto;
    private Double quantidade;
    private Double valorUnitario;

    public Integer getIdPedido() {
        return idPedido;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }
}
