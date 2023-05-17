/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.apresentacao;

import br.univates.negocio.Produto;
import java.util.ArrayList;

/**
 *
 * @author luis.dutra
 */
public class TableModelProduto extends TableModelViewAdapter{

    private ArrayList<Produto> lista;

    public TableModelProduto(ArrayList<Produto> lista)
    {
        this.lista = lista;
    }

    public ArrayList<Produto> getProdutos() {
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
        String[] col = { "ID","Categoria","Nome","Descrição","Valor" };
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
        Produto aux = lista.get(rowIndex);
        Object[] vet = { aux.getIdProduto(), aux.getCategoria().getNome(), aux.getNome(), aux.getDescricao(), aux.getValorProduto() };
        return vet[columnIndex];
    }
    
}
