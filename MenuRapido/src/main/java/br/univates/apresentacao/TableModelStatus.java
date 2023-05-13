/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.apresentacao;

import br.univates.negocio.StatusAtendimento;
import java.util.ArrayList;

/**
 *
 * @author luis.dutra
 */
public class TableModelStatus extends TableModelViewAdapter{

    private ArrayList<StatusAtendimento> lista;

    public TableModelStatus(ArrayList<StatusAtendimento> lista)
    {
        this.lista = lista;
    }

    public ArrayList<StatusAtendimento> getStatus() {
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
        return 2;
    }

    @Override
    public String getColumnName(int columnIndex)
    {
        String[] col = { "ID","Nome" };
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
        StatusAtendimento aux = lista.get(rowIndex);
        Object[] vet = { aux.getIdStatus(), aux.getNome() };
        return vet[columnIndex];
    }
    
}
