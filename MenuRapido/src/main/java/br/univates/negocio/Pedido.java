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
public class Pedido implements Comparable<Pedido>{
    
    private int idPedido;
    private StatusAtendimento statusAtendimento;
    private Mesa mesa;
    private TipoPagamento pagamento;
    private ArrayList<ItemPedido> itemPedido;
    private int pago;

    public Pedido(int idPedido, StatusAtendimento statusAtendimento, Mesa mesa, TipoPagamento pagamento, ArrayList<ItemPedido> itemPedido, int pago) {
        this.idPedido = idPedido;
        this.statusAtendimento = statusAtendimento;
        this.mesa = mesa;
        this.pagamento = pagamento;
        this.itemPedido = itemPedido;
        this.pago = pago;
    }

    public Pedido() {
        this.idPedido = 0;
        this.statusAtendimento = null;
        this.mesa = null;
        this.pagamento = null;
        this.itemPedido = new ArrayList();
        this.pago = 0;
    }
    
    public int getIdPedido() {
        return idPedido;
    }

    public StatusAtendimento getStatusAtendimento() {
        return statusAtendimento;
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

    public int getPago() {
        return pago;
    }
    
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public void setStatusAtendimento(StatusAtendimento statusAtendimento) {
        this.statusAtendimento = statusAtendimento;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public void setPagamento(TipoPagamento pagamento) {
        this.pagamento = pagamento;
    }

    public void setItemPedido(ArrayList<ItemPedido> itemPedido) {
        this.itemPedido = itemPedido;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }
    
    @Override
    public int compareTo(Pedido pedido) {
        
        return (toString().compareTo(pedido.idPedido+""));
    }
    
    @Override
    public String toString()
    {
        return this.idPedido+"";
    }
    
    @Override
    public boolean equals(Object objeto)
    {
        Pedido outroPedido = (Pedido)objeto;
        return ( toString().equalsIgnoreCase(outroPedido.getIdPedido()+"") );
    }
    
    @Override
    public Pedido clone()
    {
        return new Pedido(this.idPedido, this.statusAtendimento, this.mesa, this.pagamento, this.itemPedido, this.pago);
    }
    
}
