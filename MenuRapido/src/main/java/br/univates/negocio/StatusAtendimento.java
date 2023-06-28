/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.negocio;

/**
 *
 * @author luis.dutra
 */
public class StatusAtendimento implements Comparable<StatusAtendimento> {
    
    private Integer idStatus;
    private String nome;

    public StatusAtendimento(Integer idStatus, String nome) {
        this.idStatus = idStatus;
        this.nome = nome;
    }

    public StatusAtendimento() {
        this.idStatus = null;
        this.nome = "";
    }
    
    public Integer getIdStatus() {
        return idStatus;
    }

    public String getNome() {
        return nome;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public int compareTo(StatusAtendimento status) {
        
        return (toString().compareTo(status.getNome()));
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
        StatusAtendimento outroStatus = (StatusAtendimento) objeto;
        if (idStatus == null) {
            return outroStatus.getIdStatus() == null;
        }
        return idStatus.equals(outroStatus.getIdStatus());
    }
    
    @Override
    public StatusAtendimento clone()
    {
        return new StatusAtendimento(this.idStatus,this.nome);
    }
    
}
