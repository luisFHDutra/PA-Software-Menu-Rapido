/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.negocio;

/**
 *
 * @author luis.dutra
 */
public class ItemPedido {
    
    private Produto produto;
    private Pedido pedido;
    private double valorProduto;
    private int quantidade;

    public ItemPedido(Produto produto, Pedido pedido, double valorProduto, int quantidade) {
        this.produto = produto;
        this.pedido = pedido;
        this.valorProduto = valorProduto;
        this.quantidade = quantidade;
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

    public Pedido getPedido() {
        return pedido;
    }
    
    public double getTotalItem() {
        return quantidade * valorProduto;
    }
}
