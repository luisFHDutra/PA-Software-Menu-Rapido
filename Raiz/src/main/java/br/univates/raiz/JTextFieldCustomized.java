/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.raiz;

import java.awt.Color;
import java.io.InputStream;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

/**
 *
 * @author mouriac
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFormattedTextField;

public class JTextFieldCustomized extends JFormattedTextField {
    private String placeholder;
    private Color placeholderColor;
    private boolean isPlaceholderVisible;
    private boolean required;

    public JTextFieldCustomized() {
        this.placeholder = "";
        this.placeholderColor = Color.GRAY;
        this.isPlaceholderVisible = false;
        this.required = false;

        addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                isPlaceholderVisible = false;
                setBackground(Color.WHITE);
            }

            public void focusLost(FocusEvent e) {
                isPlaceholderVisible = (getText().isEmpty() && !isRequired());
                setBackground(isRequired() && isPlaceholderVisible ? Color.YELLOW : Color.WHITE);
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (isPlaceholderVisible) {
            g.setColor(placeholderColor);
            g.setFont(getFont().deriveFont(Font.ITALIC));
            int x = getInsets().left;
            int y = (getHeight() - g.getFontMetrics().getHeight()) / 2 + g.getFontMetrics().getAscent();
            g.drawString(placeholder, x, y);
        }
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
        repaint();
    }

    public Color getPlaceholderColor() {
        return placeholderColor;
    }

    public void setPlaceholderColor(Color placeholderColor) {
        this.placeholderColor = placeholderColor;
        repaint();
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public String getTextFlat() {
        String without = "./-";
        return getText().replaceAll("[" + without + "]", "").trim();
    }
}
