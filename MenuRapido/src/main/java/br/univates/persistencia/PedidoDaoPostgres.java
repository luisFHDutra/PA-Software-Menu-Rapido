/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.persistencia;

import br.univates.menurapido.Sys;
import br.univates.negocio.ItemPedido;
import br.univates.negocio.Mesa;
import br.univates.negocio.Pedido;
import br.univates.negocio.Produto;
import br.univates.negocio.StatusAtendimento;
import br.univates.negocio.TipoPagamento;
import br.univates.raiz.db.DataBaseConnectionManager;
import br.univates.raiz.db.DataBaseException;
import br.univates.raiz.persistence.DaoAdapter;
import br.univates.raiz.persistence.NotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author luis.dutra
 */
public class PedidoDaoPostgres extends DaoAdapter<Pedido, Integer> {

    @Override
    public void create(Pedido pedido) {
        DataBaseConnectionManager dbcm;
        dbcm = Sys.getInstance().getDB();

        try {
            dbcm.runSQL("begin transaction;");

            String sql = "INSERT INTO pedido VALUES ( ?, ?, ?, ?);";

            dbcm.runPreparedSQL(sql, pedido.getIdPedido(), pedido.getDataString(), pedido.getPago(), pedido.getMesa().getNroMesa());

            createItem(pedido);

            dbcm.runSQL("commit;");

        } catch (DataBaseException ex) {
            try {
                dbcm.runSQL("rollback;");
            } catch (DataBaseException ex1) {
                Logger.getLogger(PedidoDaoPostgres.class.getName()).log(Level.SEVERE, null, ex1);
            }

            JOptionPane.showMessageDialog(null,
                    "Erro no banco de dados",
                    "Inserção no banco de dados", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createItem(Pedido pedido) {
        DataBaseConnectionManager dbcm = Sys.getInstance().getDB();

        ArrayList<ItemPedido> itens = pedido.getItemPedido();

        String sql = "INSERT INTO item_pedido (id_produto, id_pedido, quantidade, pro_valor) VALUES (?, ?, ?, ?)";

        PreparedStatement statement = null;
        try {

            // Prepara a instrução SQL
            statement = dbcm.prepareStatement(sql);

            // Percorre a lista de itens e insere cada um no banco de dados
            for (ItemPedido item : itens) {
                statement.setInt(1, item.getProduto().getIdProduto());
                statement.setInt(2, pedido.getIdPedido());
                statement.setInt(3, item.getQuantidade());
                statement.setDouble(4, item.getValorProduto());

                // Executa a instrução SQL para inserir o item
                statement.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDaoPostgres.class.getName()).log(Level.SEVERE, null, ex);
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
                int pago = rs.getInt("pago");
                String data = rs.getDate("data_abertura").toString();

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

                ArrayList<ItemPedido> itens = new ArrayList();

                String sqlItem = "SELECT * FROM item_pedido WHERE id_pedido = ?;";
                ResultSet rsItem = dbcm.runPreparedQuerySQL(sqlItem, id_pedido);

                if (rsItem.isBeforeFirst()) // acho alguma coisa?
                {
                    rsItem.next();
                    while (!rs.isAfterLast()) {
                        int idProduto = rsItem.getInt("id_produto");
                        int quantidade = rsItem.getInt("quantidade");
                        double pro_valor = rsItem.getDouble("pro_valor");

                        Produto pro = null;
                        try {
                            pro = DaoFactory.criarProdutoDao().read(idProduto);
                        } catch (NotFoundException ex) {
                            System.out.println("não existe");
                        }

                        ItemPedido i = new ItemPedido(pro, pro_valor, quantidade);
                        itens.add(i);

                        rs.next();
                    }
                }

                p = new Pedido(id, s, m, t, itens, pago, data);
            }
        } catch (DataBaseException ex) {
            JOptionPane.showMessageDialog(null,
                    "Erro de sintaxe ou semântica",
                    "Consulta no banco de dados", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
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
                    int idPedido = rs.getInt("id_pedido");
                    int idStatus = rs.getInt("id_status");
                    int mesa = rs.getInt("nro_mesa");
                    int idTipo = rs.getInt("id_tipo");
                    int pago = rs.getInt("pago");
                    String data = rs.getDate("data_abertura").toString();

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

                    ArrayList<ItemPedido> itens = new ArrayList();

                    String sqlItem = "SELECT * FROM item_pedido WHERE id_pedido = ?;";
                    ResultSet rsItem = dbcm.runPreparedQuerySQL(sqlItem, idPedido);

                    if (rsItem.isBeforeFirst()) // acho alguma coisa?
                    {
                        rsItem.next();
                        while (!rsItem.isAfterLast()) {
                            int idProduto = rsItem.getInt("id_produto");
                            int quantidade = rsItem.getInt("quantidade");
                            double pro_valor = rsItem.getDouble("pro_valor");

                            Produto pro = null;
                            try {
                                pro = DaoFactory.criarProdutoDao().read(idProduto);
                            } catch (NotFoundException ex) {
                                System.out.println("não existe");
                            }

                            ItemPedido i = new ItemPedido(pro, pro_valor, quantidade);
                            itens.add(i);

                            rsItem.next();
                        }
                    }

                    Pedido p = new Pedido(idPedido, s, m, t, itens, pago, data);

                    lista.add(p);

                    rs.next();
                }
            }

        } catch (DataBaseException ex) {
            JOptionPane.showMessageDialog(null,
                    "Erro de sintaxe ou semântica",
                    "Consulta no banco de dados", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "DataType errado na query",
                    "Consulta no banco de dados", JOptionPane.ERROR_MESSAGE);
        }

        return lista;
    }

    @Override
    public void update(Pedido pedido) throws NotFoundException {
        DataBaseConnectionManager dbcm;

        try {
            dbcm = Sys.getInstance().getDB();

            String sql = "";
            
            if (pedido.getPagamento() != null) 
            {
                sql = "UPDATE pedido SET id_tipo = ?, pago = ?, nro_mesa = ? WHERE id_pedido = ?";
                dbcm.runPreparedSQL(sql, pedido.getPagamento().getIdTipo(), pedido.getPago(), pedido.getMesa().getNroMesa(), pedido.getIdPedido());
            } else if (pedido.getStatusAtendimento() != null) 
            {
                sql = "UPDATE pedido SET id_status = ?, pago = ?, nro_mesa = ? WHERE id_pedido = ?";
                dbcm.runPreparedSQL(sql, pedido.getStatusAtendimento().getIdStatus(), pedido.getPago(), pedido.getMesa().getNroMesa(), pedido.getIdPedido());
            } else if (pedido.getPagamento() == null && pedido.getStatusAtendimento() == null) 
            {
                sql = "UPDATE pedido SET nro_mesa = ? WHERE id_pedido = ?";
                dbcm.runPreparedSQL(sql, pedido.getMesa().getNroMesa(), pedido.getIdPedido());
            }
            else {
                sql = "UPDATE pedido SET id_status = ?, pago = ?, nro_mesa = ?, id_tipo = ?  WHERE id_pedido = ?";
                dbcm.runPreparedSQL(sql, pedido.getStatusAtendimento().getIdStatus(), pedido.getPago(), 
                    pedido.getMesa().getNroMesa(), pedido.getPagamento().getIdTipo(), pedido.getIdPedido());
            }
        }
            
        catch (DataBaseException ex)
        {
            throw new NotFoundException();
        }
    }

    @Override
    public void delete(Integer id_pedido) throws NotFoundException {
        DataBaseConnectionManager dbcm;

        try {
            dbcm = Sys.getInstance().getDB();

            String sqlDeleteItens = "DELETE FROM item_pedido WHERE id_pedido = ?";
            dbcm.runPreparedSQL(sqlDeleteItens, id_pedido);

            String sql = "DELETE FROM pedido WHERE id_pedido = ?";
            dbcm.runPreparedSQL(sql, id_pedido);
        } catch (DataBaseException ex) {
            throw new NotFoundException();
        }
    }

}
