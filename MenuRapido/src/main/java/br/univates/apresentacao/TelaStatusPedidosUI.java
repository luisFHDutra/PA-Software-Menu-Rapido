/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.univates.apresentacao;

import br.univates.menurapido.Sys;
import br.univates.negocio.Pedido;
import br.univates.negocio.StatusAtendimento;
import br.univates.persistencia.DaoFactory;
import br.univates.raiz.db.DataBaseException;
import br.univates.raiz.persistence.IDao;
import br.univates.raiz.persistence.NotFoundException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author luis.dutra
 */
public class TelaStatusPedidosUI extends javax.swing.JFrame {

    private Pedido pedidoCurrent;
    private Pedido pedidoOld;
    private TelaMenuUI telaMenu;

    /**
     * Creates new form TelaUsuarioUI
     */
    public TelaStatusPedidosUI(TelaMenuUI tela) {
        initComponents();

        this.setTitle("Status dos Pedidos");
        
        ArrayList<Pedido> pedidos = DaoFactory.criarPedidoDao().readAll();

        this.tbConsulta.setModel(new TableModelStatusPedidos(pedidos));

        this.btnSalvar.setEnabled(false);
        this.btnCancelar.setEnabled(false);

        this.btnVoltar.setEnabled(true);

        ArrayList<StatusAtendimento> status = DaoFactory.criarStatusAtendimentoDao().readAll();
        if (status == null) {
            this.initCBStatus(new ArrayList<>());
        } else {
            this.initCBStatus(status);
        }

        this.cbStatusAtendimento.setEnabled(false);

        this.telaMenu = tela;

        this.setLocationRelativeTo(null);
    }

    public void setProduto(Pedido pedido) {

        this.pedidoCurrent = pedido;
        
        if (pedido.getStatusAtendimento()!= null) {
            this.cbStatusAtendimento.setSelectedItem(pedido.getStatusAtendimento());
        }

    }

    private void initCBStatus(ArrayList<StatusAtendimento> status) {
        this.cbStatusAtendimento.removeAllItems();
        for (StatusAtendimento statusAtendimento : status) {
            cbStatusAtendimento.addItem(statusAtendimento);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tbConsulta = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        cbStatusAtendimento = new javax.swing.JComboBox<>();
        btnVoltar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 368));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tbConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbConsultaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbConsulta);

        jLabel3.setText("Status Atendimento:");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        cbStatusAtendimento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbStatusAtendimentoFocusLost(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVoltar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbStatusAtendimento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar)))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbStatusAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnEditar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbConsultaMouseClicked
        int linhaSelecionada = this.tbConsulta.getSelectedRow();

        TableModelStatusPedidos model = (TableModelStatusPedidos) this.tbConsulta.getModel();
        Pedido pedido = model.getPedidos().get(linhaSelecionada);

        this.setProduto(pedido);
    }//GEN-LAST:event_tbConsultaMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        if (pedidoCurrent != null) {
            this.pedidoOld = pedidoCurrent.clone();
            this.btnSalvar.setEnabled(true);
            this.btnCancelar.setEnabled(true);
            this.btnVoltar.setEnabled(true);

            this.cbStatusAtendimento.setEnabled(true);

        } else {
            JOptionPane.showMessageDialog(this, "Selecione um pedido na tabela", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        telaMenu.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            Sys.getInstance().getDB().closeConnection();
        } catch (DataBaseException ex) {
            JOptionPane.showMessageDialog(null,
                    "Erro fatal ao encerrar a conexão com o banco de dados",
                    "Conexão com o banco de dados", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    private void cbStatusAtendimentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbStatusAtendimentoFocusLost
        this.pedidoCurrent.setStatusAtendimento((StatusAtendimento) this.cbStatusAtendimento.getSelectedItem());
    }//GEN-LAST:event_cbStatusAtendimentoFocusLost

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        IDao<Pedido, Integer> dao = DaoFactory.criarPedidoDao();

        try {

            dao.update(pedidoCurrent);

            this.tbConsulta.revalidate();
            this.tbConsulta.repaint();

            this.cbStatusAtendimento.setEnabled(false);

            this.btnSalvar.setEnabled(false);
            this.btnCancelar.setEnabled(false);
            this.btnVoltar.setEnabled(true);
        } catch (NotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (pedidoOld != null) {
            this.pedidoCurrent.setIdPedido(this.pedidoOld.getIdPedido());
            this.pedidoCurrent.setMesa(this.pedidoOld.getMesa());
            this.pedidoCurrent.setPagamento(this.pedidoOld.getPagamento());
            this.pedidoCurrent.setStatusAtendimento(this.pedidoOld.getStatusAtendimento());
            this.pedidoCurrent.setItemPedido(this.pedidoOld.getItemPedido());
            this.cbStatusAtendimento.setSelectedItem(this.pedidoOld.getStatusAtendimento());
        }

        this.tbConsulta.revalidate();
        this.tbConsulta.repaint();

        this.cbStatusAtendimento.setEnabled(false);

        this.btnSalvar.setEnabled(false);
        this.btnCancelar.setEnabled(false);
        this.btnVoltar.setEnabled(true);
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<StatusAtendimento> cbStatusAtendimento;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbConsulta;
    // End of variables declaration//GEN-END:variables
}