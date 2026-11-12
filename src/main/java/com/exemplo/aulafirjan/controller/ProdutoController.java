package com.exemplo.aulafirjan.controller;


import com.exemplo.aulafirjan.model.ProdutoModel;
import com.exemplo.aulafirjan.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Define que a classe é um controlador REST
@RequestMapping("/api/produtos") // Prefixo da URL para os endpoints
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    // GET: Listar todos (Ex: GET /api/produtos)
    @GetMapping
    public ResponseEntity<List<ProdutoModel>> listar() {
        List<ProdutoModel> produtos = produtoService.listarTodos();
        return ResponseEntity.ok(produtos);
    }

    // GET por ID: Buscar um produto específico (Ex: GET /api/produtos/1)
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoModel> buscarPorId(@PathVariable Long id) {
        ProdutoModel produto = produtoService.buscarPorId(id);
        if (produto != null) {
            return ResponseEntity.ok(produto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // POST: Criar um novo produto (Ex: POST /api/produtos)
    @PostMapping
    public ResponseEntity<ProdutoModel> criar(@RequestBody ProdutoModel produto) {
        ProdutoModel novoProduto = produtoService.salvar(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
    }

    // DELETE: Remover um produto (Ex: DELETE /api/produtos/1)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}