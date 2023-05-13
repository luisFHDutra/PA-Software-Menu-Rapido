/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.negocio;

/**
 *
 * @author luis.dutra
 */
public class Mesa implements Comparable<Mesa>{
    
    private int nroMesa;
    private int quantidadeLugares;

    public Mesa(int nroMesa, int quantidadeLugares) {
        this.nroMesa = nroMesa;
        this.quantidadeLugares = quantidadeLugares;
    }

    public Mesa() {
        this.nroMesa = 0;
        this.quantidadeLugares = 0;
    }
    
    public int getNroMesa() {
        return nroMesa;
    }

    public int getQuantidadeLugares() {
        return quantidadeLugares;
    }

    public void setNroMesa(int nroMesa) {
        this.nroMesa = nroMesa;
    }

    public void setQuantidadeLugares(int quantidadeLugares) {
        this.quantidadeLugares = quantidadeLugares;
    }
    
    @Override
    public int compareTo(Mesa mesa) {
        
        return (toString().compareTo(mesa.getNroMesa()+""));
    }
    
    @Override
    public String toString()
    {
        return this.nroMesa+"";
    }
    
    @Override
    public boolean equals(Object objeto)
    {
        Mesa outraMesa = (Mesa)objeto;
        return ( toString().equalsIgnoreCase(outraMesa.getNroMesa()+"") );
    }
    
    @Override
    public Mesa clone()
    {
        return new Mesa(this.nroMesa,this.quantidadeLugares);
    }
}
