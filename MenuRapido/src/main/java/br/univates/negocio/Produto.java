/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.negocio;

/**
 *
 * @author luis.dutra
 */
public class Produto {
    
    private int idProduto;
    private CategoriaProduto categoria;
    private String nome;
    private String descricao;
    private double valorProduto;

    public Produto(int idProduto, CategoriaProduto categoria, String nome, String descricao, double valorProduto) {
        this.idProduto = idProduto;
        this.categoria = categoria;
        this.nome = nome;
        this.descricao = descricao;
        this.valorProduto = valorProduto;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValorProduto() {
        return valorProduto;
    }
    
    
    
}
