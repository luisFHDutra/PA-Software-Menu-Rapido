/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.apresentacao;

import br.univates.negocio.CategoriaProduto;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author luis.dutra
 */
public class ClassCellRenderer extends JLabel implements ListCellRenderer<CategoriaProduto> {

    @Override
    public Component getListCellRendererComponent(JList<? extends CategoriaProduto> list, CategoriaProduto value, int index,
            boolean isSelected, boolean cellHasFocus) {

        if (value != null) {
            setText(value.getNome()); // Defina o texto como o valor do atributo 'nome'
        } else {
            setText("");
        }

        return this;
    }
}