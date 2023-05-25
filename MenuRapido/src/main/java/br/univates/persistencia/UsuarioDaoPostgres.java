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
import javax.swing.JOptionPane;

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
            JOptionPane.showMessageDialog(null, 
                    "Chave primária duplicada",
                    "Inserção no banco de dados", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null, 
                    "Erro de sintaxe ou semântica",
                    "Consulta no banco de dados", JOptionPane.ERROR_MESSAGE);
        } 
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, 
                    "DataType errado na query",
                    "Consulta no banco de dados", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null, 
                    "Erro de sintaxe ou semântica",
                    "Consulta no banco de dados", JOptionPane.ERROR_MESSAGE);
        } 
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, 
                    "DataType errado na query",
                    "Consulta no banco de dados", JOptionPane.ERROR_MESSAGE);
        }
        
        return lista;
    }

    @Override
    public void update(Usuario usuario) throws NotFoundException {
        DataBaseConnectionManager dbcm;
        
        try
        {
            dbcm = Sys.getInstance().getDB();
            
            String sql = "UPDATE usuario SET nome = ?, user = ?, hash_code = ? WHERE id_usuario = ?";
            dbcm.runPreparedSQL(sql, usuario.getName(), 
                    usuario.getLogName(), usuario.getHashCode(), usuario.getIdUser() );
        } 
        catch (DataBaseException ex)
        {
            throw new NotFoundException();
        }
    }

    @Override
    public void delete(Integer id_usuario) throws NotFoundException {
        DataBaseConnectionManager dbcm;
        
        try
        {
            dbcm = Sys.getInstance().getDB();
            
            String sql = "DELETE FROM usuario WHERE id_usuario = ?";
            dbcm.runPreparedSQL(sql, id_usuario );
        } 
        catch (DataBaseException ex)
        {
            throw new NotFoundException();
        }
    }
    
}
