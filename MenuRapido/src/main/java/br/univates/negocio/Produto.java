/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.negocio;

/**
 *
 * @author luis.dutra
 */
public class Produto implements Comparable<Produto> {
    
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

    public Produto() {
        this.idProduto = 0;
        this.categoria = null;
        this.nome = "";
        this.descricao = "";
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

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public void setCategoria(CategoriaProduto categoria) {
        this.categoria = categoria;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }
    
    @Override
    public int compareTo(Produto produto) {
        
        return (toString().compareTo(produto.idProduto+""));
    }
    
    @Override
    public String toString()
    {
        return this.idProduto+"";
    }
    
    @Override
    public boolean equals(Object objeto)
    {
        Produto outroProduto = (Produto)objeto;
        return ( toString().equalsIgnoreCase(outroProduto.getIdProduto()+"") );
    }
    
    @Override
    public Produto clone()
    {
        return new Produto(this.idProduto, this.categoria, this.nome, this.descricao, this.valorProduto);
    }
    
}
