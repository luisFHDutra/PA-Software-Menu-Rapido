/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.persistencia;

import br.univates.menurapido.Sys;
import br.univates.negocio.CategoriaProduto;
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
public class CategoriaProdutoDaoPostgres extends DaoAdapter<CategoriaProduto,Integer>{

    @Override
    public void create(CategoriaProduto categoria) {
        DataBaseConnectionManager dbcm;
        try
        {
            dbcm = Sys.getInstance().getDB();
            
            String sql = "INSERT INTO categoria_produto VALUES ( ?, ?);";
            
            dbcm.runPreparedSQL(sql, categoria.getIdCategoria(), categoria.getNome() );
        } 
        catch (DataBaseException ex)
        {
            System.out.println("deu pau");
        }
    }

    @Override
    public CategoriaProduto read(Integer id_categoria) {
        CategoriaProduto c = null;
        DataBaseConnectionManager dbcm;
        try
        {
            dbcm = Sys.getInstance().getDB();
            
            String sql = "SELECT * FROM categoria_produto WHERE id_categoria = ?";
            
            ResultSet rs = dbcm.runPreparedQuerySQL(sql, id_categoria );
            
            if (rs.isBeforeFirst()) // acho alguma coisa?
            {
                rs.next();
                // não precisa while por que eu sei que só tem um resultado
                int id = rs.getInt("id_categoria");
                String nome = rs.getString("nome");
                
                c = new CategoriaProduto(id,nome);
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
        
        return c;
    }

    @Override
    public ArrayList<CategoriaProduto> readAll() {
        ArrayList<CategoriaProduto> lista = new ArrayList();
        
        DataBaseConnectionManager dbcm;
        try
        {
            dbcm = Sys.getInstance().getDB();
            
            String sql = "SELECT * FROM categoria_produto;";
            
            ResultSet rs = dbcm.runQuerySQL( sql );
            
            if (rs.isBeforeFirst()) // acho alguma coisa?
            {
                rs.next();
                while (!rs.isAfterLast())
                {
                    int id = rs.getInt("id_categoria");
                    String nome = rs.getString("nome");

                    CategoriaProduto c = new CategoriaProduto(id,nome);
                    lista.add(c);
                    
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
    public void update(CategoriaProduto objeto) throws NotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer primaryKey) throws NotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
