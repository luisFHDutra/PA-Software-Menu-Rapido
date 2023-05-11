/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.menurapido;

import br.univates.raiz.auth.User;
import br.univates.raiz.db.DataBaseConnectionManager;
import br.univates.raiz.db.DataBaseException;

/**
 *
 * @author luis.dutra
 */
public class Sys {
    
    private String nomeSys;
    private String licenciado;
    private User user;
    private DataBaseConnectionManager dbcm;
    
    private static Sys sys = new Sys();

    public static Sys getInstance()
    {
        return sys;
    }
    
    private Sys()
    {
        this.nomeSys = "Menu Rápido";
        this.licenciado = "Luís Dutra";
        this.user = null;
        try
        {
            this.dbcm = new DataBaseConnectionManager( DataBaseConnectionManager.POSTGRESQL,
                    "menuRapido","postgres","postgres");
        } 
        catch (DataBaseException ex)
        {
            System.exit(0);
        }
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public String getNomeSistema()
    {
        return nomeSys;
    }

    public String getNomeLicenciado()
    {
        return licenciado;
    }

    public User getUser()
    {
        return user;
    }

    public DataBaseConnectionManager getDB()
    {
        return dbcm;
    }
    
}
