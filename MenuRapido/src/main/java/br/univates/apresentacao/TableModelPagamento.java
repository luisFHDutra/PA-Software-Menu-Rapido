/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.apresentacao;

import br.univates.negocio.Pedido;
import java.util.ArrayList;

/**
 *
 * @author luis.dutra
 */
public class TableModelPagamento extends TableModelViewAdapter{

    private ArrayList<Pedido> lista;

    public TableModelPagamento(ArrayList<Pedido> lista)
    {
        this.lista = lista;
    }

    public ArrayList<Pedido> getPedidos() {
        return lista;
    }
    
    @Override
    public int getRowCount()
    {
        return lista.size();
    }

    @Override
    public int getColumnCount()
    {
        return 5;
    }

    @Override
    public String getColumnName(int columnIndex)
    {
        String[] col = { "ID","Status","Mesa","Pagamento","Valor Total" };
        return col[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        if (columnIndex == 0)
        {
            return Integer.class;
        }
        return String.class;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Pedido aux = lista.get(rowIndex);
        
        String tipoPagamento = "";
        if (aux.getPagamento() != null) tipoPagamento = aux.getPagamento().getNome();
        
        String statusPedido = "";
        if (aux.getStatusAtendimento()!= null) statusPedido = aux.getStatusAtendimento().getNome();
        
        Object[] vet = { aux.getIdPedido(), statusPedido, 
            aux.getMesa().getNroMesa(), tipoPagamento, aux.getTotalPedido() };
        return vet[columnIndex];
    }
    
}
