/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.negocio;

import br.univates.raiz.auth.User;

/**
 *
 * @author luis.dutra
 */
public class Usuario implements User {
    
    private int idUser;
    private String nome;
    private String user;
    private String hashCode;

    public Usuario(int idUser, String nome, String user, String hashCode) {
        this.idUser = idUser;
        this.nome = nome;
        this.user = user;
        this.hashCode = hashCode;
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
    
}
