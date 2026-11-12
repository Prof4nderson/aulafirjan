package com.exemplo.aulafirjan.service;


import com.exemplo.aulafirjan.model.ProdutoModel;
import com.exemplo.aulafirjan.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Indica que esta classe gerencia regras de negócio
public class ProdutoService {

    @Autowired // Injeção de dependência automática do Repository
    private ProdutoRepository produtoRepository;

    // Listar todos os produtos
    public List<ProdutoModel> listarTodos() {
        return produtoRepository.findAll();
    }

    // Buscar por ID
    public ProdutoModel buscarPorId(Long id) {
        Optional<ProdutoModel> produto = produtoRepository.findById(id);
        return produto.orElse(null); // Retorna o produto ou null se não achar
    }

    // Salvar ou atualizar produto
    public ProdutoModel salvar(ProdutoModel produto) {
        return produtoRepository.save(produto);
    }

    // Deletar produto
    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }
}