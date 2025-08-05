package com.senac.produtos.controllers;

import com.senac.produtos.entities.Pedido;
import com.senac.produtos.repositories.PedidoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoRepository pedidoRepository;

    public PedidoController(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    @GetMapping("/{idPedido}")
    public Pedido buscarPorId(
            @PathVariable Integer idPedido
    ) {
        return pedidoRepository.findById(idPedido).get();
    }

    @PostMapping
    public Pedido criarPedido(
            @RequestBody Pedido novoPedido
    ) {
        return pedidoRepository.save(novoPedido);
    }

    @PutMapping("/{idPedido}")
    public Pedido alterarPedido(
            @PathVariable Integer idPedido,
            @RequestBody Pedido alterar
    ) {
        Pedido pedido = pedidoRepository.findById(idPedido).get();
        pedido.setData(alterar.getData());
        pedido.setEnderecoEntrega(alterar.getEnderecoEntrega());
        pedido.setValorFrete(alterar.getValorFrete());
        pedido.setValorTotal(alterar.getValorTotal());

        return pedidoRepository.save(pedido);
    }

    @DeleteMapping("/{idPedido}")
    public Pedido removerPedido(
            @PathVariable Integer idPedido
    ) {
        Pedido pedido = pedidoRepository.findById(idPedido).get();
        pedidoRepository.delete(pedido);
        return pedido;
    }
}
