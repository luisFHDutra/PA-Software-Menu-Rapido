/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.negocio;

import br.univates.raiz.auth.Authenticator;
import br.univates.raiz.auth.User;

/**
 *
 * @author luis.dutra
 */
public class Usuario implements User, Comparable<Usuario> {
    
    private int idUser;
    private String nome;
    private String user;
    private String hashCode;
    private UserPermissao permissao;

    public Usuario(int idUser, String nome, String user, String hashCode, UserPermissao permissao) {
        this.idUser = idUser;
        this.nome = nome;
        this.user = user;
        this.hashCode = hashCode;
        this.permissao = permissao;
    }

    public Usuario() {
        this.idUser = 0;
        this.nome = "";
        this.user = "";
        this.hashCode = "";
        this.permissao = null;
    }
    
    @Override
    public String getLogName() {
        return user;
    }

    @Override
    public String getName() {
        return nome;
    }

    @Override
    public String getHashCode() {
        return hashCode;
    }

    public int getIdUser() {
        return idUser;
    }

    public UserPermissao getPermissao() {
        return permissao;
    }
    
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPermissao(UserPermissao permissao) {
        this.permissao = permissao;
    }
    
    public void setHashCode(String hashCode) {
        this.hashCode = Authenticator.getHashCode(hashCode);
    }
    
    @Override
    public int compareTo(Usuario usuario) {
        
        return (toString().compareTo(usuario.idUser+""));
    }
    
    @Override
    public String toString()
    {
        return this.idUser+"";
    }
    
    @Override
    public boolean equals(Object objeto)
    {
        Usuario outroUsuario = (Usuario)objeto;
        return ( toString().equalsIgnoreCase(outroUsuario.getIdUser()+"") );
    }
    
    @Override
    public Usuario clone()
    {
        return new Usuario(this.idUser,this.nome,this.user,this.hashCode,this.permissao);
    }
}
