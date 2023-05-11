/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.negocio;

/**
 *
 * @author luis.dutra
 */
public class StatusAtendimento {
    
    private int idStatus;
    private String nome;

    public StatusAtendimento(int idStatus, String nome) {
        this.idStatus = idStatus;
        this.nome = nome;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public String getNome() {
        return nome;
    }
    
    
    
}
