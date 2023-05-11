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
            System.out.println("deu pau");
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
            System.out.println("deu pau");
        } 
        catch (SQLException ex)
        {
            System.out.println("deu pau");
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
            System.out.println("deu pau");
        } 
        catch (SQLException ex)
        {
            System.out.println("deu pau");
        }
        
        return lista;
    }

    @Override
    public void update(Produto objeto) throws NotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer primaryKey) throws NotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
