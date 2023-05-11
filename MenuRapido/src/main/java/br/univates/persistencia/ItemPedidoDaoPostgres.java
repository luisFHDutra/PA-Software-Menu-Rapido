/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.persistencia;

import br.univates.menurapido.Sys;
import br.univates.negocio.ItemPedido;
import br.univates.negocio.Pedido;
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
public class ItemPedidoDaoPostgres extends DaoAdapter<ItemPedido,Integer>{

    @Override
    public void create(ItemPedido item) {
        DataBaseConnectionManager dbcm;
        try
        {
            dbcm = Sys.getInstance().getDB();
            
            String sql = "INSERT INTO item_pedido VALUES ( ?, ?, ?, ?);";
            
            dbcm.runPreparedSQL(sql, item.getProduto().getIdProduto(), item.getPedido().getIdPedido(),
                    item.getValorProduto(), item.getQuantidade());
        } 
        catch (DataBaseException ex)
        {
            System.out.println("deu pau");
        }
    }

    @Override
    public ItemPedido read(Integer primaryKey) throws NotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ItemPedido> readAll() {
        ArrayList<ItemPedido> lista = new ArrayList();
        
        DataBaseConnectionManager dbcm;
        try
        {
            dbcm = Sys.getInstance().getDB();
            
            String sql = "SELECT * FROM item_pedido;";
            
            ResultSet rs = dbcm.runQuerySQL( sql );
            
            if (rs.isBeforeFirst()) // acho alguma coisa?
            {
                rs.next();
                while (!rs.isAfterLast())
                {
                    int idProduto = rs.getInt("id_produto");
                    int idPedido = rs.getInt("id_pedido");
                    double valor = rs.getDouble("pro_valor");
                    int quantidade = rs.getInt("quantidade");
                
                    Produto pro = null;
                    try {
                        pro = DaoFactory.criarProdutoDao().read(idProduto);
                    } catch (NotFoundException ex) {
                        System.out.println("não existe");
                    }

                    Pedido pe = null;
                    try {
                        pe = DaoFactory.criarPedidoDao().read(idPedido);
                    } catch (NotFoundException ex) {
                        System.out.println("não existe");
                    }
                    
                    ItemPedido i = new ItemPedido(pro,pe,valor,quantidade);
                    lista.add(i);
                    
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
    public void update(ItemPedido objeto) throws NotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer primaryKey) throws NotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
