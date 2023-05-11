/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.persistencia;

import br.univates.menurapido.Sys;
import br.univates.negocio.StatusAtendimento;
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
public class StatusAtendimentoDaoPostgres extends DaoAdapter<StatusAtendimento,Integer>{

    @Override
    public void create(StatusAtendimento status) {
        DataBaseConnectionManager dbcm;
        try
        {
            dbcm = Sys.getInstance().getDB();
            
            String sql = "INSERT INTO status_atendimento VALUES ( ?, ?);";
            
            dbcm.runPreparedSQL(sql, status.getIdStatus(), status.getNome() );
        } 
        catch (DataBaseException ex)
        {
            System.out.println("deu pau");
        }
    }

    @Override
    public StatusAtendimento read(Integer id_status) {
        StatusAtendimento s = null;
        DataBaseConnectionManager dbcm;
        try
        {
            dbcm = Sys.getInstance().getDB();
            
            String sql = "SELECT * FROM status_atendimento WHERE id_status = ?";
            
            ResultSet rs = dbcm.runPreparedQuerySQL(sql, id_status );
            
            if (rs.isBeforeFirst()) // acho alguma coisa?
            {
                rs.next();
                // não precisa while por que eu sei que só tem um resultado
                int id = rs.getInt("id_status");
                String nome = rs.getString("nome");
                
                s = new StatusAtendimento(id,nome);
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
        
        return s;
    }

    @Override
    public ArrayList<StatusAtendimento> readAll() {
        ArrayList<StatusAtendimento> lista = new ArrayList();
        
        DataBaseConnectionManager dbcm;
        try
        {
            dbcm = Sys.getInstance().getDB();
            
            String sql = "SELECT * FROM status_atendimento;";
            
            ResultSet rs = dbcm.runQuerySQL( sql );
            
            if (rs.isBeforeFirst()) // acho alguma coisa?
            {
                rs.next();
                while (!rs.isAfterLast())
                {
                    int id = rs.getInt("id_status");
                    String nome = rs.getString("nome");

                    StatusAtendimento s = new StatusAtendimento(id,nome);
                    lista.add(s);
                    
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
    public void update(StatusAtendimento objeto) throws NotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer primaryKey) throws NotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
