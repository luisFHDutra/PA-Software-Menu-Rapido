/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.negocio;

/**
 *
 * @author luis.dutra
 */
public class TipoPagamento implements Comparable<TipoPagamento> {
    
    private Integer idTipo;
    private String nome;

    public TipoPagamento(Integer idTipo, String nome) {
        this.idTipo = idTipo;
        this.nome = nome;
    }

    public TipoPagamento() {
        this.idTipo = null;
        this.nome = "";
    }
    
    public Integer getIdTipo() {
        return idTipo;
    }

    public String getNome() {
        return nome;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public int compareTo(TipoPagamento tipo) {
        
        return (toString().compareTo(tipo.getNome()));
    }
    
    @Override
    public String toString()
    {
        return this.nome+"";
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
        TipoPagamento outroTipo = (TipoPagamento) objeto;
        if (idTipo == null) {
            return outroTipo.getIdTipo() == null;
        }
        return idTipo.equals(outroTipo.getIdTipo());
    }
    
    @Override
    public TipoPagamento clone()
    {
        return new TipoPagamento(this.idTipo,this.nome);
    }
}
