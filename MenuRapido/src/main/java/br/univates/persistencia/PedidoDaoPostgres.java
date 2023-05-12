/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.persistencia;

import br.univates.menurapido.Sys;
import br.univates.negocio.ItemPedido;
import br.univates.negocio.Mesa;
import br.univates.negocio.Pedido;
import br.univates.negocio.StatusAtendimento;
import br.univates.negocio.TipoPagamento;
import br.univates.raiz.db.DataBaseConnectionManager;
import br.univates.raiz.db.DataBaseException;
import br.univates.raiz.persistence.DaoAdapter;
import br.univates.raiz.persistence.Filter;
import br.univates.raiz.persistence.NotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author luis.dutra
 */
public class PedidoDaoPostgres extends DaoAdapter<Pedido, Integer> {

    @Override
    public void create(Pedido pedido) {
        DataBaseConnectionManager dbcm;
        try {
            dbcm = Sys.getInstance().getDB();

            String sql = "INSERT INTO pedido VALUES ( ?, ?, ?, ?);";

            dbcm.runPreparedSQL(sql, pedido.getIdPedido(), pedido.getStatusAtendimento().getIdStatus(),
                    pedido.getMesa().getNroMesa(), pedido.getPagamento().getIdTipo());
        } catch (DataBaseException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Chave primária duplicada",
                    "Inserção no banco de dados", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public Pedido read(Integer id_pedido) {
        Pedido p = null;
        DataBaseConnectionManager dbcm;
        try {
            dbcm = Sys.getInstance().getDB();

            String sql = "SELECT * FROM pedido WHERE id_pedido = ?";

            ResultSet rs = dbcm.runPreparedQuerySQL(sql, id_pedido);

            if (rs.isBeforeFirst()) // acho alguma coisa?
            {
                rs.next();
                // não precisa while por que eu sei que só tem um resultado
                int id = rs.getInt("id_pedido");
                int idStatus = rs.getInt("id_status");
                int mesa = rs.getInt("nro_mesa");
                int idTipo = rs.getInt("id_tipo");

                StatusAtendimento s = null;
                try {
                    s = DaoFactory.criarStatusAtendimentoDao().read(idStatus);
                } catch (NotFoundException ex) {
                    System.out.println("não existe");
                }

                Mesa m = null;
                try {
                    m = DaoFactory.criarMesaDao().read(mesa);
                } catch (NotFoundException ex) {
                    System.out.println("não existe");
                }

                TipoPagamento t = null;
                try {
                    t = DaoFactory.criarTipoPagamentoDao().read(idTipo);
                } catch (NotFoundException ex) {
                    System.out.println("não existe");
                }

                ArrayList<ItemPedido> itens = DaoFactory.criarItemPedidoDao().readAll(new Filter<ItemPedido>() {
                    @Override
                    public boolean isAccept(ItemPedido record) {
                        return (record.getPedido().getIdPedido() == id);
                    }
                });

                p = new Pedido(id, s, m, t, itens);
            }
        }catch (DataBaseException ex)
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
    public ArrayList<Pedido> readAll() {
        ArrayList<Pedido> lista = new ArrayList();

        DataBaseConnectionManager dbcm;
        try {
            dbcm = Sys.getInstance().getDB();

            String sql = "SELECT * FROM pedido;";

            ResultSet rs = dbcm.runQuerySQL(sql);

            if (rs.isBeforeFirst()) // acho alguma coisa?
            {
                rs.next();
                while (!rs.isAfterLast()) {
                    int id = rs.getInt("id_pedido");
                    int idStatus = rs.getInt("id_status");
                    int mesa = rs.getInt("nro_mesa");
                    int idTipo = rs.getInt("id_tipo");

                    StatusAtendimento s = null;
                    try {
                        s = DaoFactory.criarStatusAtendimentoDao().read(idStatus);
                    } catch (NotFoundException ex) {
                        System.out.println("não existe");
                    }

                    Mesa m = null;
                    try {
                        m = DaoFactory.criarMesaDao().read(mesa);
                    } catch (NotFoundException ex) {
                        System.out.println("não existe");
                    }

                    TipoPagamento t = null;
                    try {
                        t = DaoFactory.criarTipoPagamentoDao().read(idTipo);
                    } catch (NotFoundException ex) {
                        System.out.println("não existe");
                    }

                    ArrayList<ItemPedido> itens = DaoFactory.criarItemPedidoDao().readAll(new Filter<ItemPedido>() {
                        @Override
                        public boolean isAccept(ItemPedido record) {
                            return (record.getPedido().getIdPedido() == id);
                        }
                    });

                    Pedido p = new Pedido(id, s, m, t, itens);
                    lista.add(p);

                    rs.next();
                }
            }

        }catch (DataBaseException ex)
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
    public void update(Pedido objeto) throws NotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer primaryKey) throws NotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
