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
    
    private int idTipo;
    private String nome;

    public TipoPagamento(int idTipo, String nome) {
        this.idTipo = idTipo;
        this.nome = nome;
    }

    public TipoPagamento() {
        this.idTipo = 0;
        this.nome = "";
    }
    
    public int getIdTipo() {
        return idTipo;
    }

    public String getNome() {
        return nome;
    }

    public void setIdTipo(int idTipo) {
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
        TipoPagamento outroTipo = (TipoPagamento)objeto;
        return ( this.idTipo == outroTipo.getIdTipo() );
    }
    
    @Override
    public TipoPagamento clone()
    {
        return new TipoPagamento(this.idTipo,this.nome);
    }
}
