/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.persistencia;

import br.univates.menurapido.Sys;
import br.univates.negocio.TipoPagamento;
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
public class TipoPagamentoDaoPostgres extends DaoAdapter<TipoPagamento,Integer>{

    @Override
    public void create(TipoPagamento tipo) {
        DataBaseConnectionManager dbcm;
        try
        {
            dbcm = Sys.getInstance().getDB();
            
            String sql = "INSERT INTO tipo_pagamento VALUES ( ?, ?);";
            
            dbcm.runPreparedSQL(sql, tipo.getIdTipo(), tipo.getNome() );
        } 
        catch (DataBaseException ex)
        {
            System.out.println("deu pau");
        }
    }

    @Override
    public TipoPagamento read(Integer id_tipo) {
        TipoPagamento t = null;
        DataBaseConnectionManager dbcm;
        try
        {
            dbcm = Sys.getInstance().getDB();
            
            String sql = "SELECT * FROM tipo_pagamento WHERE id_tipo = ?";
            
            ResultSet rs = dbcm.runPreparedQuerySQL(sql, id_tipo );
            
            if (rs.isBeforeFirst()) // acho alguma coisa?
            {
                rs.next();
                // não precisa while por que eu sei que só tem um resultado
                int id = rs.getInt("id_tipo");
                String nome = rs.getString("nome");
                
                t = new TipoPagamento(id,nome);
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
        
        return t;
    }

    @Override
    public ArrayList<TipoPagamento> readAll() {
        ArrayList<TipoPagamento> lista = new ArrayList();
        
        DataBaseConnectionManager dbcm;
        try
        {
            dbcm = Sys.getInstance().getDB();
            
            String sql = "SELECT * FROM tipo_pagamento;";
            
            ResultSet rs = dbcm.runQuerySQL( sql );
            
            if (rs.isBeforeFirst()) // acho alguma coisa?
            {
                rs.next();
                while (!rs.isAfterLast())
                {
                    int id = rs.getInt("id_tipo");
                    String nome = rs.getString("nome");

                    TipoPagamento t = new TipoPagamento(id,nome);
                    lista.add(t);
                    
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
    public void update(TipoPagamento objeto) throws NotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer primaryKey) throws NotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
