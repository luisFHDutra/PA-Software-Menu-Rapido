/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.persistencia;

import br.univates.menurapido.Sys;
import br.univates.negocio.Usuario;
import br.univates.raiz.db.DataBaseConnectionManager;
import br.univates.raiz.db.DataBaseException;
import br.univates.raiz.persistence.DaoAdapter;
import br.univates.raiz.persistence.NotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author luis.dutra
 */
public class UsuarioDaoPostgres extends DaoAdapter<Usuario,Integer>{

    @Override
    public void create(Usuario user) {
        
        DataBaseConnectionManager dbcm;
        try
        {
            dbcm = Sys.getInstance().getDB();
            
            String sql = "INSERT INTO usuario VALUES ( ?, ?, ?, ?);";
            
            dbcm.runPreparedSQL(sql, user.getIdUser(), user.getName(),
                    user.getLogName(), user.getHashCode());
        } 
        catch (DataBaseException ex)
        {
            System.out.println("deu pau");
        }
        
    }

    @Override
    public Usuario read(Integer id_usuario) {
        Usuario u = null;
        DataBaseConnectionManager dbcm;
        try
        {
            dbcm = Sys.getInstance().getDB();
            
            String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
            
            ResultSet rs = dbcm.runPreparedQuerySQL(sql, id_usuario );
            
            if (rs.isBeforeFirst()) // acho alguma coisa?
            {
                rs.next();
                // não precisa while por que eu sei que só tem um resultado
                int id = rs.getInt("id_usuario");
                String nome = rs.getString("nome");
                String user = rs.getString("user");
                String hashCode = rs.getString("hash_code");
                
                u = new Usuario(id,nome,user,hashCode);
            }
        } 
        catch (DataBaseException ex)
        {
            System.out.println("deu pau");
        } 
        catch (SQLException ex)
        {
            System.out.println("deu pau");
        }
        
        return u;
    }

    @Override
    public ArrayList<Usuario> readAll() {
        ArrayList<Usuario> lista = new ArrayList();
        
        DataBaseConnectionManager dbcm;
        try
        {
            dbcm = Sys.getInstance().getDB();
            
            String sql = "SELECT * FROM usuario;";
            
            ResultSet rs = dbcm.runQuerySQL( sql );
            
            if (rs.isBeforeFirst()) // acho alguma coisa?
            {
                rs.next();
                while (!rs.isAfterLast())
                {
                    int id = rs.getInt("id_usuario");
                    String nome = rs.getString("nome");
                    String user = rs.getString("user");
                    String hashCode = rs.getString("hash_code");

                    Usuario u = new Usuario(id,nome,user,hashCode);
                    lista.add(u);
                    
                    rs.next();
                }
            }

        } 
        catch (DataBaseException ex)
        {
            System.out.println("deu pau");
        } 
        catch (SQLException ex)
        {
            System.out.println("deu pau");
        }
        
        return lista;
    }

    @Override
    public void update(Usuario objeto) throws NotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer primaryKey) throws NotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
