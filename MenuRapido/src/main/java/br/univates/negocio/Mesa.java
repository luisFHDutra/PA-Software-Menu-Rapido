/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.negocio;

/**
 *
 * @author luis.dutra
 */
public class Mesa {
    
    private int nroMesa;
    private int quantidadeLugares;

    public Mesa(int nroMesa, int quantidadeLugares) {
        this.nroMesa = nroMesa;
        this.quantidadeLugares = quantidadeLugares;
    }

    public int getNroMesa() {
        return nroMesa;
    }

    public int getQuantidadeLugares() {
        return quantidadeLugares;
    }
    
    
}
