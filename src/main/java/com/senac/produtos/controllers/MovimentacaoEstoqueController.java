package com.senac.produtos.controllers;

import com.senac.produtos.entities.MovimentacaoEstoque;
import com.senac.produtos.entities.Produto;
import com.senac.produtos.repositories.MovimentacaoEstoqueRepository;
import com.senac.produtos.repositories.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos/{idProduto}/movimentacoes")
public class MovimentacaoEstoqueController {
    private final ProdutoRepository produtoRepository;
    private final MovimentacaoEstoqueRepository movimentacaoEstoqueRepository;

    public MovimentacaoEstoqueController(ProdutoRepository produtoRepository, MovimentacaoEstoqueRepository movimentacaoEstoqueRepository) {
        this.produtoRepository = produtoRepository;
        this.movimentacaoEstoqueRepository = movimentacaoEstoqueRepository;
    }

    @GetMapping
    public List<MovimentacaoEstoque> listarMovimentacoes(
            @PathVariable Integer idProduto
    ) {
//        Produto produto = this.produtoRepository.findById(idProduto).orElseThrow();
//        return produto.getMovimentacoes();
        List<MovimentacaoEstoque> movimentacoes = this.movimentacaoEstoqueRepository.findByProdutoId(idProduto);
        return movimentacoes;
    }

    @PostMapping
    public MovimentacaoEstoque criarMovimentacao(
            @RequestBody MovimentacaoEstoque movimentacao,
            @PathVariable Integer idProduto
    ) {
        Produto produto = this.produtoRepository.findById(idProduto).orElseThrow();

        movimentacao.setProduto(produto);
        this.movimentacaoEstoqueRepository.save(movimentacao);
        return movimentacao;
    }
}
