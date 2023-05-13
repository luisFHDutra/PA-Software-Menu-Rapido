/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.univates.apresentacao;

import br.univates.menurapido.MenuRapido;
import br.univates.menurapido.Sys;
import br.univates.raiz.db.DataBaseException;
import javax.swing.JOptionPane;

/**
 *
 * @author luis.dutra
 */
public class TelaMenuUI extends javax.swing.JFrame {

    /**
     * Creates new form Tela
     */
    public TelaMenuUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        lbUsuarioConectado.setText(Sys.getInstance().getUser().getName());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        btnTelaUsuario = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbUsuarioConectado = new javax.swing.JLabel();
        btnTelaStatus = new javax.swing.JButton();
        btnTelaTipo = new javax.swing.JButton();
        btnTelaCategoria = new javax.swing.JButton();
        btnTelaMesas = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnSistema = new javax.swing.JMenu();
        btnLoggin = new javax.swing.JMenuItem();
        btnSair = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnTelaUsuario.setText("Usuários");
        btnTelaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelaUsuarioActionPerformed(evt);
            }
        });

        jLabel1.setText("Usuário Conectado: ");

        btnTelaStatus.setText("Status Atendimento");
        btnTelaStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelaStatusActionPerformed(evt);
            }
        });

        btnTelaTipo.setText("Tipo de Pagamento");
        btnTelaTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelaTipoActionPerformed(evt);
            }
        });

        btnTelaCategoria.setText("Categoria Produtos");
        btnTelaCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelaCategoriaActionPerformed(evt);
            }
        });

        btnTelaMesas.setText("Mesas");
        btnTelaMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelaMesasActionPerformed(evt);
            }
        });

        btnSistema.setText("Sistema");

        btnLoggin.setText("Log in / off");
        btnLoggin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogginActionPerformed(evt);
            }
        });
        btnSistema.add(btnLoggin);

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        btnSistema.add(btnSair);

        jMenuBar1.add(btnSistema);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lbUsuarioConectado, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTelaCategoria)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTelaTipo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTelaMesas))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTelaUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTelaStatus)))
                        .addGap(69, 69, 69))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lbUsuarioConectado, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTelaUsuario)
                    .addComponent(btnTelaStatus))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTelaTipo)
                    .addComponent(btnTelaMesas))
                .addGap(29, 29, 29)
                .addComponent(btnTelaCategoria)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            Sys.getInstance().getDB().closeConnection();
        } catch (DataBaseException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Erro fatal ao encerrar a conexão com o banco de dados",
                    "Conexão com o banco de dados", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        try {
            Sys.getInstance().getDB().closeConnection();
        } catch (DataBaseException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Erro fatal ao encerrar a conexão com o banco de dados",
                    "Conexão com o banco de dados", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnLogginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogginActionPerformed
        this.dispose();
        Sys.getInstance().setUser(null);
        MenuRapido.runMain();
    }//GEN-LAST:event_btnLogginActionPerformed

    private void btnTelaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelaUsuarioActionPerformed
        TelaUsuarioUI tela = new TelaUsuarioUI(this);
        tela.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnTelaUsuarioActionPerformed

    private void btnTelaStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelaStatusActionPerformed
        TelaStatusUI tela = new TelaStatusUI(this);
        tela.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnTelaStatusActionPerformed

    private void btnTelaTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelaTipoActionPerformed
        TelaTipoUI tela = new TelaTipoUI(this);
        tela.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnTelaTipoActionPerformed

    private void btnTelaCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelaCategoriaActionPerformed
        TelaCategoriaUI tela = new TelaCategoriaUI(this);
        tela.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnTelaCategoriaActionPerformed

    private void btnTelaMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelaMesasActionPerformed
        TelaMesaUI tela = new TelaMesaUI(this);
        tela.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnTelaMesasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnLoggin;
    private javax.swing.JMenuItem btnSair;
    private javax.swing.JMenu btnSistema;
    private javax.swing.JButton btnTelaCategoria;
    private javax.swing.JButton btnTelaMesas;
    private javax.swing.JButton btnTelaStatus;
    private javax.swing.JButton btnTelaTipo;
    private javax.swing.JButton btnTelaUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lbUsuarioConectado;
    // End of variables declaration//GEN-END:variables
}
