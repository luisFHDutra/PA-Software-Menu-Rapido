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
    
    private int idStatus;
    private String nome;

    public StatusAtendimento(int idStatus, String nome) {
        this.idStatus = idStatus;
        this.nome = nome;
    }

    public StatusAtendimento() {
        this.idStatus = 0;
        this.nome = "";
    }
    
    public int getIdStatus() {
        return idStatus;
    }

    public String getNome() {
        return nome;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public int compareTo(StatusAtendimento status) {
        
        return (toString().compareTo(status.getIdStatus()+""));
    }
    
    @Override
    public String toString()
    {
        return this.idStatus+"";
    }
    
    @Override
    public boolean equals(Object objeto)
    {
        StatusAtendimento outroStatus = (StatusAtendimento)objeto;
        return ( toString().equalsIgnoreCase(outroStatus.getIdStatus()+"") );
    }
    
    @Override
    public StatusAtendimento clone()
    {
        return new StatusAtendimento(this.idStatus,this.nome);
    }
    
}
