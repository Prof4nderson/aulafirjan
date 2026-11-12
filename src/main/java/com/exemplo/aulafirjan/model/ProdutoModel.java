package com.exemplo.aulafirjan.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_produto") // Define o nome da tabela no PostgreSQL
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremento no banco
    private Long id;

    private String nome;
    private String fabricante;
    private Double valor;

    // Construtor padrão exigido pelo JPA
    public ProdutoModel() {}

    // Construtor completo
    public ProdutoModel(Long id, String nome, String fabricante, Double valor) {
        this.id = id;
        this.nome = nome;
        this.fabricante = fabricante;
        this.valor = valor;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getFabricante() { return fabricante; }
    public void setFabricante(String fabricante) { this.fabricante = fabricante; }

    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }
}