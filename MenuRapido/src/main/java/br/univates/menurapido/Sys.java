/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.menurapido;

import br.univates.negocio.Usuario;
import br.univates.raiz.db.DataBaseConnectionManager;
import br.univates.raiz.db.DataBaseException;
import javax.swing.JOptionPane;

/**
 *
 * @author luis.dutra
 */
public class Sys {
    
    private String nomeSys;
    private String licenciado;
    private Usuario user;
    private DataBaseConnectionManager dbcm;
    public final static int permissaoAdmin = 1;
    public final static int permissaoUser = 2;
    public final static int permissaoIntermediaria = 3;
    
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
                    "menurapido","postgres","postgres");
        } 
        catch (DataBaseException ex)
        {
            JOptionPane.showMessageDialog(null, 
                    "Erro fatal na configuração de acesso ao banco de dados",
                    "Conexão com o banco de dados", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    public void setUser(Usuario user)
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

    public Usuario getUser()
    {
        return user;
    }

    public DataBaseConnectionManager getDB()
    {
        return dbcm;
    }
    
}
