/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.univates.apresentacao;

import br.univates.negocio.Usuario;
import br.univates.persistencia.DaoFactory;
import br.univates.raiz.persistence.IDao;
import br.univates.raiz.persistence.InvalidKeyException;
import br.univates.raiz.persistence.KeyViolationException;
import br.univates.raiz.persistence.NotFoundException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author luis.dutra
 */
public class TelaUsuarioUI extends javax.swing.JFrame {

    private Usuario usuarioCurrent;
    private Usuario usuarioOld;
    private boolean novo;
    
    /**
     * Creates new form TelaUsuarioUI
     */
    public TelaUsuarioUI() {
        initComponents();
        
        ArrayList<Usuario> usuarios = DaoFactory.criarUsuarioDao().readAll();
        
        this.tbConsultaUsuarios.setModel( new TableModelUsuario(usuarios));
        this.novo = false;
        
        this.btnSalvar.setEnabled(false);
        
        this.btnCancelar.setEnabled(false);
        
        this.btnVoltar.setEnabled(true);
        
        this.setLocationRelativeTo(null);
    }
    
    public void setUsuario(Usuario usuario) {
    
        this.usuarioCurrent = usuario;
        
        if (usuario.getIdUser() == 0) {
            this.tfIDUsuario.setText("" );
        } else {
            this.tfIDUsuario.setInteger(usuario.getIdUser());
        }
        
        this.tfNomeUsuario.setText(usuario.getName());
        this.tfSenhaUsuario.setText("");
        this.tfUserUsuario.setText(usuario.getLogName());
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
        tbConsultaUsuarios = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        tfIDUsuario = new br.univates.raiz.JIntegerField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfNomeUsuario = new br.univates.raiz.JTextFieldCustomized();
        jLabel4 = new javax.swing.JLabel();
        tfUserUsuario = new br.univates.raiz.JTextFieldCustomized();
        tfSenhaUsuario = new br.univates.raiz.JTextFieldCustomized();
        jLabel5 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbConsultaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        tbConsultaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbConsultaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbConsultaUsuarios);

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        tfIDUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfIDUsuarioFocusLost(evt);
            }
        });

        jLabel2.setText("ID: ");

        jLabel3.setText("Nome: ");

        tfNomeUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfNomeUsuarioFocusLost(evt);
            }
        });

        jLabel4.setText("User: ");

        tfUserUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfUserUsuarioFocusLost(evt);
            }
        });

        tfSenhaUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfSenhaUsuarioFocusLost(evt);
            }
        });

        jLabel5.setText("Senha: ");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfUserUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfSenhaUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNomeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfIDUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfIDUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfUserUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSenhaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNovo)
                .addGap(18, 18, 18)
                .addComponent(btnEditar)
                .addGap(18, 18, 18)
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(btnVoltar)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnExcluir)
                        .addComponent(btnEditar)
                        .addComponent(btnNovo))
                    .addComponent(btnVoltar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbConsultaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbConsultaUsuariosMouseClicked
        int linhaSelecionada  = this.tbConsultaUsuarios.getSelectedRow();
        
        TableModelUsuario model = (TableModelUsuario)this.tbConsultaUsuarios.getModel();
        Usuario usuario = model.getUsuarios().get( linhaSelecionada );
        
        this.setUsuario(usuario);
    }//GEN-LAST:event_tbConsultaUsuariosMouseClicked

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        
        this.btnSalvar.setEnabled(true);
        this.btnCancelar.setEnabled(true);
        this.btnVoltar.setEnabled(true);
        
        this.tfIDUsuario.setEditable(true);
        this.tfNomeUsuario.setEditable(true);
        this.tfUserUsuario.setEditable(true);
        this.tfSenhaUsuario.setEditable(true);
        
        this.novo = true;
        
        if (usuarioCurrent != null) {
            this.usuarioOld = usuarioCurrent.clone();
        }
        
        this.setUsuario(new Usuario());
        this.tfIDUsuario.requestFocus();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        
        if (usuarioCurrent != null) {
            this.usuarioOld = usuarioCurrent.clone();
            this.btnSalvar.setEnabled(true);
            this.btnCancelar.setEnabled(true);
            this.btnVoltar.setEnabled(true);
            
            this.novo = false;
            this.tfIDUsuario.setEditable(false);
            this.tfUserUsuario.setEditable(false);
            this.tfSenhaUsuario.setEditable(false);
            this.tfNomeUsuario.setEditable(true);
            this.tfNomeUsuario.requestFocus();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um usuário na tabela");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (usuarioCurrent != null)
        {
            try
            {
                int x = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir?", 
                                                            "Confirmação", 
                                                            JOptionPane.YES_NO_OPTION);
                
                if (x == 0)
                {
                    DaoFactory.criarUsuarioDao().delete( usuarioCurrent.getIdUser() );

                    TableModelUsuario model = (TableModelUsuario)this.tbConsultaUsuarios.getModel();
                    model.getUsuarios().remove(usuarioCurrent);

                    this.tbConsultaUsuarios.revalidate();
                    this.tbConsultaUsuarios.repaint();
                    this.tfIDUsuario.setText( "" );
                    this.tfNomeUsuario.setText( "" );
                    this.tfSenhaUsuario.setText( "" );
                    this.tfUserUsuario.setText( "" );
                    
                    this.tfSenhaUsuario.setText( "" );
                    this.tfSenhaUsuario.setVisible(false);
                    
                    this.usuarioCurrent = null;
                }
            } 
            catch (NotFoundException ex)
            {
                JOptionPane.showMessageDialog(this, "Este usuário não pode ser deletado");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Selecione um usuário na tabela");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void tfIDUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfIDUsuarioFocusLost
        this.usuarioCurrent.setIdUser(this.tfIDUsuario.getInteger());
    }//GEN-LAST:event_tfIDUsuarioFocusLost

    private void tfNomeUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNomeUsuarioFocusLost
        this.usuarioCurrent.setNome(this.tfNomeUsuario.getText());
    }//GEN-LAST:event_tfNomeUsuarioFocusLost

    private void tfUserUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfUserUsuarioFocusLost
        this.usuarioCurrent.setUser(this.tfUserUsuario.getText());
    }//GEN-LAST:event_tfUserUsuarioFocusLost

    private void tfSenhaUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfSenhaUsuarioFocusLost
        this.usuarioCurrent.setHashCode(this.tfSenhaUsuario.getText());
    }//GEN-LAST:event_tfSenhaUsuarioFocusLost

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (usuarioOld != null)
        {
            this.usuarioCurrent.setIdUser(this.usuarioOld.getIdUser() );
            this.usuarioCurrent.setNome( this.usuarioOld.getName() );
            this.usuarioCurrent.setUser(this.usuarioOld.getLogName() );
            this.usuarioCurrent.setHashCode(this.usuarioOld.getHashCode() );
            this.tfIDUsuario.setText( this.usuarioOld.getIdUser()+"" );
            this.tfNomeUsuario.setText( this.usuarioOld.getName());
            this.tfUserUsuario.setText( this.usuarioOld.getLogName());
            this.tfSenhaUsuario.setText( "" );
        }
        
        this.tbConsultaUsuarios.revalidate();
        this.tbConsultaUsuarios.repaint();
        
        this.tfIDUsuario.setEditable(false);
        this.tfNomeUsuario.setEditable(false);
        this.tfUserUsuario.setEditable(false);
        this.tfSenhaUsuario.setEditable(false);

        this.btnSalvar.setEnabled(false);
        this.btnCancelar.setEnabled(false);
        this.btnVoltar.setEnabled(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        IDao<Usuario,Integer> dao = DaoFactory.criarUsuarioDao();

        try
        {
            if (novo)
            {
                dao.create(usuarioCurrent);

                TableModelUsuario model = (TableModelUsuario)this.tbConsultaUsuarios.getModel();
                model.getUsuarios().add(usuarioCurrent);
            } else {
                dao.update(usuarioCurrent);
            }

            this.tbConsultaUsuarios.revalidate();
            this.tbConsultaUsuarios.repaint();

            this.tfIDUsuario.setEditable(false);
            this.tfNomeUsuario.setEditable(false);
            this.tfUserUsuario.setEditable(false);
            this.tfSenhaUsuario.setEditable(false);

            this.btnSalvar.setEnabled(false);
            this.btnCancelar.setEnabled(false);
            this.btnVoltar.setEnabled(true);
        }
        catch (KeyViolationException | InvalidKeyException ex) 
        {
            JOptionPane.showMessageDialog(this, ex.getMessage() );
        } catch (NotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage() );
        }
    }//GEN-LAST:event_btnSalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbConsultaUsuarios;
    private br.univates.raiz.JIntegerField tfIDUsuario;
    private br.univates.raiz.JTextFieldCustomized tfNomeUsuario;
    private br.univates.raiz.JTextFieldCustomized tfSenhaUsuario;
    private br.univates.raiz.JTextFieldCustomized tfUserUsuario;
    // End of variables declaration//GEN-END:variables
}
