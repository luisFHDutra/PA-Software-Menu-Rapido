/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.negocio;

import java.util.ArrayList;

/**
 *
 * @author luis.dutra
 */
public class Pedido {
    
    private int idPedido;
    private StatusAtendimento statusAtendimento;
    private Mesa mesa;
    private TipoPagamento pagamento;
    private ArrayList<ItemPedido> itemPedido;

    public Pedido(int idPedido, StatusAtendimento statusAtendimento, Mesa mesa, TipoPagamento pagamento, ArrayList<ItemPedido> itemPedido) {
        this.idPedido = idPedido;
        this.statusAtendimento = statusAtendimento;
        this.mesa = mesa;
        this.pagamento = pagamento;
        this.itemPedido = itemPedido;
    }
    
    public int getIdPedido() {
        return idPedido;
    }

    public StatusAtendimento getStatusAtendimento() {
        return statusAtendimento;
    }
    
    public ArrayList<ItemPedido> getItem() {
        return itemPedido;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public TipoPagamento getPagamento() {
        return pagamento;
    }

    public ArrayList<ItemPedido> getItemPedido() {
        return itemPedido;
    }
    
    public double getTotalPedido() {
        
        double valorTotal = 0;
        
        for (ItemPedido item: itemPedido) {
            valorTotal += item.getTotalItem();
        }
        
        return valorTotal;
    }
    
}
