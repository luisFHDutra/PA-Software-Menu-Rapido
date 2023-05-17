/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.persistencia;

import br.univates.menurapido.Sys;
import br.univates.negocio.CategoriaProduto;
import br.univates.negocio.Produto;
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
public class ProdutoDaoPostgres extends DaoAdapter<Produto,Integer>{

    @Override
    public void create(Produto produto) {
        DataBaseConnectionManager dbcm;
        try
        {
            dbcm = Sys.getInstance().getDB();
            
            String sql = "INSERT INTO produto VALUES ( ?, ?, ?, ?, ?);";
            
            dbcm.runPreparedSQL(sql, produto.getIdProduto(), produto.getCategoria().getIdCategoria(),
                    produto.getNome(), produto.getDescricao(), produto.getValorProduto());
        } 
        catch (DataBaseException ex)
        {
            JOptionPane.showMessageDialog(null, 
                    "Chave primária duplicada",
                    "Inserção no banco de dados", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public Produto read(Integer id_produto) {
        Produto p = null;
        DataBaseConnectionManager dbcm;
        try
        {
            dbcm = Sys.getInstance().getDB();
            
            String sql = "SELECT * FROM produto WHERE id_produto = ?";
            
            ResultSet rs = dbcm.runPreparedQuerySQL(sql, id_produto );
            
            if (rs.isBeforeFirst()) // acho alguma coisa?
            {
                rs.next();
                // não precisa while por que eu sei que só tem um resultado
                int id = rs.getInt("id_produto");
                int idCategoria = rs.getInt("id_categoria");
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                double valor = rs.getDouble("pro_valor");
                
                CategoriaProduto c = null;
                try {
                    c = DaoFactory.criarCategoriaProdutoDao().read(idCategoria);
                } catch (NotFoundException ex) {
                    System.out.println("não existe");
                }
                
                p = new Produto(id,c,nome,descricao,valor);
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
        
        return p;
    }

    @Override
    public ArrayList<Produto> readAll() {
        ArrayList<Produto> lista = new ArrayList();
        
        DataBaseConnectionManager dbcm;
        try
        {
            dbcm = Sys.getInstance().getDB();
            
            String sql = "SELECT * FROM produto;";
            
            ResultSet rs = dbcm.runQuerySQL( sql );
            
            if (rs.isBeforeFirst()) // acho alguma coisa?
            {
                rs.next();
                while (!rs.isAfterLast())
                {
                    int id = rs.getInt("id_produto");
                    int idCategoria = rs.getInt("id_categoria");
                    String nome = rs.getString("nome");
                    String descricao = rs.getString("descricao");
                    double valor = rs.getDouble("pro_valor");
                
                    CategoriaProduto c = null;
                    try {
                        c = DaoFactory.criarCategoriaProdutoDao().read(idCategoria);
                    } catch (NotFoundException ex) {
                        System.out.println("não existe");
                    }

                    Produto p = new Produto(id,c,nome,descricao,valor);
                    lista.add(p);
                    
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
    public void update(Produto produto) throws NotFoundException {
        DataBaseConnectionManager dbcm;
        
        try
        {
            dbcm = Sys.getInstance().getDB();
            
            String sql = "UPDATE produto SET pro_valor = ? WHERE id_produto = ?";
            dbcm.runPreparedSQL(sql, produto.getValorProduto(), produto.getIdProduto() );
        } 
        catch (DataBaseException ex)
        {
            throw new NotFoundException();
        }
    }

    @Override
    public void delete(Integer id_produto) throws NotFoundException {
        DataBaseConnectionManager dbcm;
        
        try
        {
            dbcm = Sys.getInstance().getDB();
            
            String sql = "DELETE FROM produto WHERE id_produto = ?";
            dbcm.runPreparedSQL(sql, id_produto );
        } 
        catch (DataBaseException ex)
        {
            throw new NotFoundException();
        }
    }
    
}
