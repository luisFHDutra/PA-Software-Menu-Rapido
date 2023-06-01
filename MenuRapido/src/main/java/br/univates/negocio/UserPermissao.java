/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.negocio;

/**
 *
 * @author luis.dutra
 */
public class UserPermissao implements Comparable<UserPermissao> {
    
    private int idPermissao;
    private String nome;

    public UserPermissao(int idPermissao, String nome) {
        this.idPermissao = idPermissao;
        this.nome = nome;
    }

    public UserPermissao() {
        this.idPermissao = 0;
        this.nome = "";
    }

    public int getIdPermissao() {
        return idPermissao;
    }

    public void setIdPermissao(int idPermissao) {
        this.idPermissao = idPermissao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public int compareTo(UserPermissao permissao) {
        
        return (toString().compareTo(permissao.getNome()));
    }
    
    @Override
    public String toString()
    {
        return this.nome+"";
    }
    
    @Override
    public boolean equals(Object objeto)
    {
        UserPermissao outraPermissao = (UserPermissao)objeto;
        return ( this.idPermissao == outraPermissao.getIdPermissao());
    }
    
    @Override
    public UserPermissao clone()
    {
        return new UserPermissao(this.idPermissao,this.nome);
    }
}
