/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.persistencia;

import br.univates.menurapido.Sys;
import br.univates.negocio.Mesa;
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
public class MesaDaoPostgres extends DaoAdapter<Mesa,Integer>{

    @Override
    public void create(Mesa mesa) {
        DataBaseConnectionManager dbcm;
        try
        {
            dbcm = Sys.getInstance().getDB();
            
            String sql = "INSERT INTO mesa VALUES ( ?, ?);";
            
            dbcm.runPreparedSQL(sql, mesa.getNroMesa(), mesa.getQuantidadeLugares() );
        } 
        catch (DataBaseException ex)
        {
            JOptionPane.showMessageDialog(null, 
                    "Chave primária duplicada",
                    "Inserção no banco de dados", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public Mesa read(Integer nro_mesa) {
        Mesa m = null;
        DataBaseConnectionManager dbcm;
        try
        {
            dbcm = Sys.getInstance().getDB();
            
            String sql = "SELECT * FROM mesa WHERE nro_mesa = ?";
            
            ResultSet rs = dbcm.runPreparedQuerySQL(sql, nro_mesa );
            
            if (rs.isBeforeFirst()) // acho alguma coisa?
            {
                rs.next();
                // não precisa while por que eu sei que só tem um resultado
                int id = rs.getInt("nro_mesa");
                int lugares = rs.getInt("quant_lugares");
                
                m = new Mesa(id,lugares);
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
        
        return m;
    }

    @Override
    public ArrayList<Mesa> readAll() {
        ArrayList<Mesa> lista = new ArrayList();
        
        DataBaseConnectionManager dbcm;
        try
        {
            dbcm = Sys.getInstance().getDB();
            
            String sql = "SELECT * FROM mesa;";
            
            ResultSet rs = dbcm.runQuerySQL( sql );
            
            if (rs.isBeforeFirst()) // acho alguma coisa?
            {
                rs.next();
                while (!rs.isAfterLast())
                {
                    int id = rs.getInt("nro_mesa");
                    int lugares = rs.getInt("quant_lugares");

                    Mesa m = new Mesa(id,lugares);
                    lista.add(m);
                    
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
    public void update(Mesa objeto) throws NotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer primaryKey) throws NotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
