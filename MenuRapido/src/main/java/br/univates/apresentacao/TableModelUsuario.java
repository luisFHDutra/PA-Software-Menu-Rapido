/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.apresentacao;

import br.univates.negocio.Usuario;
import java.util.ArrayList;

/**
 *
 * @author luis.dutra
 */
public class TableModelUsuario extends TableModelViewAdapter{

    private ArrayList<Usuario> lista;

    public TableModelUsuario(ArrayList<Usuario> lista)
    {
        this.lista = lista;
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
        String[] col = { "ID","LogName","Nome" };
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
        Usuario aux = lista.get(rowIndex);
        Object[] vet = { aux.getIdUser(), aux.getLogName(), aux.getName() };
        return vet[columnIndex];
    }
    
}
