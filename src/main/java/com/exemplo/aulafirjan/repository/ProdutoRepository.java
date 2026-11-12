package com.exemplo.aulafirjan.repository;


import com.exemplo.aulafirjan.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Indica que é um componente de acesso a dados do Spring
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
    // O JpaRepository já traz prontos métodos como: save(), findAll(), findById(), deleteById()
}