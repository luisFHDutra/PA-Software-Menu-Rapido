/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.apresentacao;

import br.univates.negocio.ItemPedido;
import java.util.ArrayList;

/**
 *
 * @author luis.dutra
 */
public class TableModelItem extends TableModelViewAdapter{

    private ArrayList<ItemPedido> lista;

    public TableModelItem(ArrayList<ItemPedido> lista)
    {
        this.lista = lista;
    }

    public ArrayList<ItemPedido> getItens() {
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
        return 3;
    }

    @Override
    public String getColumnName(int columnIndex)
    {
        String[] col = { "Produto","Quantidade","Valor Produto" };
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
        ItemPedido aux = lista.get(rowIndex);
        Object[] vet = { aux.getProduto().getNome(), aux.getQuantidade(), aux.getValorProduto() };
        return vet[columnIndex];
    }
    
}
