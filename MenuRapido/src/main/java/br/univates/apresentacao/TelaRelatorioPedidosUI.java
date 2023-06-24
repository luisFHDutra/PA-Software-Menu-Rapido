/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.univates.apresentacao;

import br.univates.menurapido.Sys;
import br.univates.negocio.ItemPedido;
import br.univates.negocio.Mesa;
import br.univates.negocio.Pedido;
import br.univates.negocio.StatusAtendimento;
import br.univates.negocio.TipoPagamento;
import br.univates.persistencia.DaoFactory;
import br.univates.raiz.Data;
import br.univates.raiz.InvalidDateException;
import br.univates.raiz.db.DataBaseException;
import br.univates.raiz.persistence.Filter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author luis.dutra
 */
public class TelaRelatorioPedidosUI extends javax.swing.JFrame {

    private Pedido pedidoCurrent;
    private TelaMenuUI telaMenu;
    public ArrayList<ItemPedido> itens;
    public String dataSelecionada;
    public int ano;
    public int mes;
    public int dia;
    
    /**
     * Creates new form TelaUsuarioUI
     */
    public TelaRelatorioPedidosUI(TelaMenuUI tela) {
        initComponents();

        this.setTitle("Relatório dos Pedidos");

        this.pedidoCurrent = new Pedido();
        
        ArrayList<Pedido> pedidos = DaoFactory.criarPedidoDao().readAll(new Filter<Pedido>() {
            @Override
            public boolean isAccept(Pedido record) {
                return record.getIdPedido() == 0;
            }
            });

        this.tbConsulta.setModel(new TableModelRelatorioPedidos(pedidos));
        
        ArrayList<TipoPagamento> tipos = DaoFactory.criarTipoPagamentoDao().readAll();
        if (tipos == null) {
            this.initCBTipo(new ArrayList<>());
        } else {
            this.initCBTipo(tipos);
        }

        ArrayList<StatusAtendimento> status = DaoFactory.criarStatusAtendimentoDao().readAll();
        if (status == null) {
            this.initCBStatus(new ArrayList<>());
        } else {
            this.initCBStatus(status);
        }
        
        this.btnVoltar.setEnabled(true);

        this.telaMenu = tela;
        
        this.setLocationRelativeTo(null);
    }

    private void initCBTipo(ArrayList<TipoPagamento> tipos) {
        this.cbTipoPagamento.removeAllItems();
        for (TipoPagamento tipo : tipos) {
            cbTipoPagamento.addItem(tipo);
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
        btnVoltar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfAno = new br.univates.raiz.JIntegerField();
        tfMes = new br.univates.raiz.JIntegerField();
        tfDia = new br.univates.raiz.JIntegerField();
        jLabel2 = new javax.swing.JLabel();
        cbStatusAtendimento = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbTipoPagamento = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        lbQtdPedidos = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbFaturamentoTotal = new javax.swing.JLabel();
        btnConsulta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
        jScrollPane2.setViewportView(tbConsulta);

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        jPanel1.setToolTipText("");

        jLabel1.setText("Data do pedido:");

        tfAno.setPlaceholder("ANO");
        tfAno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfAnoFocusLost(evt);
            }
        });

        tfMes.setPlaceholder("MÊS");
        tfMes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfMesFocusLost(evt);
            }
        });

        tfDia.setPlaceholder("DIA");
        tfDia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfDiaFocusLost(evt);
            }
        });

        jLabel2.setText("Status de atendimento:");

        cbStatusAtendimento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbStatusAtendimentoFocusLost(evt);
            }
        });

        jLabel3.setText("Meio de pagamento:");

        cbTipoPagamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbTipoPagamentoFocusLost(evt);
            }
        });

        jLabel4.setText("Quantidade de pedidos:");

        jLabel5.setText("Faturamento total:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(lbQtdPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbFaturamentoTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbTipoPagamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbStatusAtendimento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(tfAno, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(tfMes, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfDia, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbStatusAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbTipoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 3, Short.MAX_VALUE)
                                        .addComponent(jLabel5))
                                    .addComponent(lbQtdPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbFaturamentoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        btnConsulta.setText("Consultar");
        btnConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnConsulta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVoltar)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnConsulta))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void cbTipoPagamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbTipoPagamentoFocusLost
        this.pedidoCurrent.setPagamento((TipoPagamento) this.cbTipoPagamento.getSelectedItem());
    }//GEN-LAST:event_cbTipoPagamentoFocusLost

    private void btnConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaActionPerformed
        try {
            Data data = new Data(dia, mes, ano);
            this.dataSelecionada = data.getDataFormatada();
            
            ArrayList<Pedido> pedidos = DaoFactory.criarPedidoDao().readAll(new Filter<Pedido>() {
            @Override
            public boolean isAccept(Pedido record) {
                return record.getStatusAtendimento().getIdStatus() == pedidoCurrent.getStatusAtendimento().getIdStatus()
                        && record.getPagamento().getIdTipo() == pedidoCurrent.getPagamento().getIdTipo()
                        && record.getDataString().equals(dataSelecionada);
            }
            });

            this.tbConsulta.setModel(new TableModelRelatorioPedidos(pedidos));
            
            this.lbQtdPedidos.setText(""+pedidos.size());
            
            double valorTotal = 0;
        
            for (Pedido pedido: pedidos) {
                valorTotal += pedido.getTotalPedido();
            }
            
            this.lbFaturamentoTotal.setText(""+valorTotal);
            
        } catch (InvalidDateException ex) {
            Logger.getLogger(TelaRelatorioPedidosUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnConsultaActionPerformed

    private void tfAnoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfAnoFocusLost
        this.ano = this.tfAno.getInteger();
    }//GEN-LAST:event_tfAnoFocusLost

    private void tfMesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfMesFocusLost
        this.mes = this.tfMes.getInteger();
    }//GEN-LAST:event_tfMesFocusLost

    private void tfDiaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDiaFocusLost
        this.dia = this.tfDia.getInteger();
    }//GEN-LAST:event_tfDiaFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsulta;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<StatusAtendimento> cbStatusAtendimento;
    private javax.swing.JComboBox<TipoPagamento> cbTipoPagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbFaturamentoTotal;
    private javax.swing.JLabel lbQtdPedidos;
    private javax.swing.JTable tbConsulta;
    private br.univates.raiz.JIntegerField tfAno;
    private br.univates.raiz.JIntegerField tfDia;
    private br.univates.raiz.JIntegerField tfMes;
    // End of variables declaration//GEN-END:variables
}