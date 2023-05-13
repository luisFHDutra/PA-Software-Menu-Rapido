/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.apresentacao;

import br.univates.negocio.Mesa;
import java.util.ArrayList;

/**
 *
 * @author luis.dutra
 */
public class TableModelMesa extends TableModelViewAdapter{

    private ArrayList<Mesa> lista;

    public TableModelMesa(ArrayList<Mesa> lista)
    {
        this.lista = lista;
    }

    public ArrayList<Mesa> getMesas() {
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
        String[] col = { "Número","Quantidade de lugares" };
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
        Mesa aux = lista.get(rowIndex);
        Object[] vet = { aux.getNroMesa(), aux.getQuantidadeLugares() };
        return vet[columnIndex];
    }
    
}
