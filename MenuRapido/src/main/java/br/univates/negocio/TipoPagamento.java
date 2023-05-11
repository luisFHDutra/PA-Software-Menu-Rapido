/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.negocio;

/**
 *
 * @author luis.dutra
 */
public class TipoPagamento {
    
    private int idTipo;
    private String nome;

    public TipoPagamento(int idTipo, String nome) {
        this.idTipo = idTipo;
        this.nome = nome;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public String getNome() {
        return nome;
    }
    
    
}
