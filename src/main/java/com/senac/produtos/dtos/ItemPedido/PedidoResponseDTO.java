package com.senac.produtos.dtos.ItemPedido;

import com.senac.produtos.entities.Pedido;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PedidoResponseDTO {
    private String data;
    private Double valorTotal;
    private Double valorFrete;
    private String enderecoEntrega;

    public PedidoResponseDTO(Pedido pedido) {
        this.data = new SimpleDateFormat("dd/MM/yyyy").format(pedido.getData());
        this.valorTotal = pedido.getValorTotal();
        this.valorFrete = pedido.getValorFrete();
        this.enderecoEntrega = pedido.getEnderecoEntrega();
    }


    public String getData() {
        return data;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public Double getValorFrete() {
        return valorFrete;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }
}
