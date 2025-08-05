package com.senac.produtos.controllers;

import com.senac.produtos.dtos.ItemPedido.ItemPedidoRequestDTO;
import com.senac.produtos.dtos.ItemPedido.ItemPedidoResponseDTO;
import com.senac.produtos.entities.ItemPedido;
import com.senac.produtos.repositories.ItemPedidoRepository;
import com.senac.produtos.repositories.PedidoRepository;
import com.senac.produtos.repositories.ProdutoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itens_pedido")
public class ItemPedidoController {

    private final ItemPedidoRepository itemPedidoRepository;
    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;

    public ItemPedidoController(ItemPedidoRepository itemPedidoRepository, PedidoRepository pedidoRepository, ProdutoRepository produtoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
        this.pedidoRepository = pedidoRepository;
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public ItemPedidoResponseDTO adicionar(
         @RequestBody ItemPedidoRequestDTO request
    ) {
        ItemPedido novo = new ItemPedido();

        novo.setQuantidade(request.getQuantidade());
        novo.setValorUnitario(request.getValorUnitario());

        novo.setProduto(produtoRepository.findById(request.getIdProduto()).get());
        novo.setPedido(pedidoRepository.findById(request.getIdPedido()).get());

        this.itemPedidoRepository.save(novo);

        return new ItemPedidoResponseDTO(novo);
    }
}
