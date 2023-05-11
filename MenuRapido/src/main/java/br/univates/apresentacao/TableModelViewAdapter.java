/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.apresentacao;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author luis.dutra
 */
public abstract class TableModelViewAdapter implements TableModel {
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return false;
    }


    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        
    }

    @Override
    public void addTableModelListener(TableModelListener l)
    {
        
    }

    @Override
    public void removeTableModelListener(TableModelListener l)
    {
        
    }
    
}
