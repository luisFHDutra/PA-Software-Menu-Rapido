/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.negocio;

/**
 *
 * @author luis.dutra
 */
public class ItemPedido implements Comparable<ItemPedido> {
    
    private Produto produto;
    private double valorProduto;
    private int quantidade;

    public ItemPedido(Produto produto, double valorProduto, int quantidade) {
        this.produto = produto;
        this.valorProduto = valorProduto;
        this.quantidade = quantidade;
    }

    public ItemPedido() {
       this.produto = null;
    }
    
    public Produto getProduto() {
        return produto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }
    
    public double getTotalItem() {
        return quantidade * valorProduto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    @Override
    public int compareTo(ItemPedido item) {
        
        return (toString().compareTo(item.produto.getNome()));
    }
    
    @Override
    public String toString()
    {
        return this.produto.getNome()+"";
    }
    
    @Override
    public boolean equals(Object objeto)
    {
        ItemPedido outroItem = (ItemPedido)objeto;
        return ( this.produto.getIdProduto() == outroItem.getProduto().getIdProduto());
    }
    
    @Override
    public ItemPedido clone()
    {
        return new ItemPedido(this.produto,this.valorProduto,this.quantidade);
    }
}
