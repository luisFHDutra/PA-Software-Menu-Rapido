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
import javax.swing.JOptionPane;

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
            JOptionPane.showMessageDialog(null, 
                    "Chave primária duplicada",
                    "Inserção no banco de dados", JOptionPane.ERROR_MESSAGE);
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
    public void update(CategoriaProduto categoria) throws NotFoundException {
        DataBaseConnectionManager dbcm;
        
        try
        {
            dbcm = Sys.getInstance().getDB();
            
            String sql = "UPDATE categoria_produto SET nome = ? WHERE id_categoria = ?";
            dbcm.runPreparedSQL(sql, categoria.getNome(), categoria.getIdCategoria() );
        } 
        catch (DataBaseException ex)
        {
            throw new NotFoundException();
        }
    }

    @Override
    public void delete(Integer id_categoria) throws NotFoundException {
        DataBaseConnectionManager dbcm;
        
        try
        {
            dbcm = Sys.getInstance().getDB();
            
            String sql = "DELETE FROM categoria_produto WHERE id_categoria = ?";
            dbcm.runPreparedSQL(sql, id_categoria );
        } 
        catch (DataBaseException ex)
        {
            throw new NotFoundException();
        }
    }
    
}
