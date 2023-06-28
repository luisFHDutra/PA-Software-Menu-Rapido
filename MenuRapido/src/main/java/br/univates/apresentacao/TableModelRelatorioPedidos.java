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
public class TableModelRelatorioPedidos extends TableModelViewAdapter{

    private ArrayList<Pedido> lista;

    public TableModelRelatorioPedidos(ArrayList<Pedido> lista)
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
        String[] col = { "ID","Status do Pedido","Mesa","Valor Total","Data de Abertura" };
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
        Object[] vet = { aux.getIdPedido(), aux.getStatusAtendimento().getNome(),
            aux.getMesa().getNroMesa(), aux.getTotalPedido(), aux.getDataString() };
        return vet[columnIndex];
    }
    
}
