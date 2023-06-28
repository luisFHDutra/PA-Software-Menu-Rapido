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
    
    private Integer nroMesa;
    private Integer quantidadeLugares;

    public Mesa(Integer nroMesa, Integer quantidadeLugares) {
        this.nroMesa = nroMesa;
        this.quantidadeLugares = quantidadeLugares;
    }

    public Mesa() {
        this.nroMesa = null;
        this.quantidadeLugares = null;
    }
    
    public Integer getNroMesa() {
        return nroMesa;
    }

    public Integer getQuantidadeLugares() {
        return quantidadeLugares;
    }

    public void setNroMesa(Integer nroMesa) {
        this.nroMesa = nroMesa;
    }

    public void setQuantidadeLugares(Integer quantidadeLugares) {
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
        if (this == objeto) {
            return true;
        }
        if (objeto == null || getClass() != objeto.getClass()) {
            return false;
        }
        Mesa outraMesa = (Mesa) objeto;
        if (nroMesa == null) {
            return outraMesa.getNroMesa() == null;
        }
        return nroMesa.equals(outraMesa.getNroMesa());
    }
    
    @Override
    public Mesa clone()
    {
        return new Mesa(this.nroMesa,this.quantidadeLugares);
    }
}
