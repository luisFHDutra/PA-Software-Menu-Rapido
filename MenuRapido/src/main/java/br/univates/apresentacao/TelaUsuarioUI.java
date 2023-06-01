/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.univates.apresentacao;

import br.univates.menurapido.Sys;
import br.univates.negocio.UserPermissao;
import br.univates.negocio.Usuario;
import br.univates.persistencia.DaoFactory;
import br.univates.raiz.db.DataBaseException;
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
    private TelaMenuUI telaMenu;

    /**
     * Creates new form TelaUsuarioUI
     */
    public TelaUsuarioUI(TelaMenuUI tela) {
        initComponents();

        this.setTitle("Usuários");
        
        ArrayList<Usuario> usuarios = DaoFactory.criarUsuarioDao().readAll();

        this.tbConsulta.setModel(new TableModelUsuario(usuarios));
        this.novo = false;

        this.btnSalvar.setEnabled(false);
        this.btnCancelar.setEnabled(false);

        this.btnVoltar.setEnabled(true);

        this.tfID.setEditable(false);
        this.tfNome.setEditable(false);
        this.tfUser.setEditable(false);
        this.tfSenha.setEditable(false);
        this.cbUserPermissao.setEnabled(false);
        
        ArrayList<UserPermissao> permissoes = DaoFactory.criarUserPermissaoDao().readAll();

        if (permissoes == null) {
            this.initCombos(new ArrayList<>());
        } else {
            this.initCombos(permissoes);
        }
        
        this.telaMenu = tela;

        this.setLocationRelativeTo(null);
    }

    private void setUsuario(Usuario usuario) {

        this.usuarioCurrent = usuario;

        if (usuario.getIdUser() == 0) {
            this.tfID.setText("");
        } else {
            this.tfID.setInteger(usuario.getIdUser());
        }

        if (usuario.getPermissao() != null) {
            this.cbUserPermissao.setSelectedItem(usuario.getPermissao());
        }
        
        this.tfNome.setText(usuario.getName());
        this.tfSenha.setText("");
        this.tfUser.setText(usuario.getLogName());
    }

    private void initCombos(ArrayList<UserPermissao> permissoes) {
        this.cbUserPermissao.removeAllItems();
        for (UserPermissao permissao : permissoes) {
            cbUserPermissao.addItem(permissao);
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
        tfID = new br.univates.raiz.JIntegerField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfNome = new br.univates.raiz.JTextFieldCustomized();
        jLabel4 = new javax.swing.JLabel();
        tfUser = new br.univates.raiz.JTextFieldCustomized();
        jLabel5 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        tfSenha = new javax.swing.JPasswordField();
        cbUserPermissao = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 474));
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

        tfID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfIDFocusLost(evt);
            }
        });

        jLabel2.setText("ID: ");

        jLabel3.setText("Nome: ");

        tfNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfNomeFocusLost(evt);
            }
        });

        jLabel4.setText("User: ");

        tfUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfUserFocusLost(evt);
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

        tfSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfSenhaFocusLost(evt);
            }
        });

        cbUserPermissao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbUserPermissaoFocusLost(evt);
            }
        });

        jLabel1.setText("Nível de permissão:");

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(75, 75, 75)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                            .addComponent(tfUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbUserPermissao, 0, 345, Short.MAX_VALUE)
                            .addComponent(tfID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar)))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbUserPermissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnExcluir)
                    .addComponent(btnEditar)
                    .addComponent(btnNovo))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbConsultaMouseClicked
        int linhaSelecionada = this.tbConsulta.getSelectedRow();

        TableModelUsuario model = (TableModelUsuario) this.tbConsulta.getModel();
        Usuario usuario = model.getUsuarios().get(linhaSelecionada);

        this.setUsuario(usuario);
    }//GEN-LAST:event_tbConsultaMouseClicked

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed

        this.btnSalvar.setEnabled(true);
        this.btnCancelar.setEnabled(true);
        this.btnVoltar.setEnabled(true);

        this.tfID.setEditable(true);
        this.tfNome.setEditable(true);
        this.tfUser.setEditable(true);
        this.tfSenha.setEditable(true);
        this.cbUserPermissao.setEnabled(true);
        
        this.novo = true;

        if (usuarioCurrent != null) {
            this.usuarioOld = usuarioCurrent.clone();
        }

        this.setUsuario(new Usuario());
        this.tfID.requestFocus();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        if (usuarioCurrent != null) {
            this.usuarioOld = usuarioCurrent.clone();
            this.btnSalvar.setEnabled(true);
            this.btnCancelar.setEnabled(true);
            this.btnVoltar.setEnabled(true);

            this.novo = false;
            this.tfID.setEditable(false);
            this.tfUser.setEditable(false);
            this.tfSenha.setEditable(false);
            this.tfNome.setEditable(true);
            this.cbUserPermissao.setEnabled(false);
            this.tfNome.requestFocus();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um usuário na tabela", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (usuarioCurrent != null && usuarioCurrent.getIdUser() != Sys.getInstance().getUser().getIdUser()) {
            try {
                int x = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir?",
                        "Confirmação",
                        JOptionPane.YES_NO_OPTION);

                if (x == 0) {
                    DaoFactory.criarUsuarioDao().delete(usuarioCurrent.getIdUser());

                    TableModelUsuario model = (TableModelUsuario) this.tbConsulta.getModel();
                    model.getUsuarios().remove(usuarioCurrent);

                    this.tbConsulta.revalidate();
                    this.tbConsulta.repaint();
                    this.tfID.setText("");
                    this.tfNome.setText("");
                    this.tfSenha.setText("");
                    this.tfUser.setText("");

                    this.tfSenha.setText("");
                    this.tfSenha.setVisible(false);

                    this.usuarioCurrent = null;
                }
            } catch (NotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Este usuário não pode ser deletado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um usuário válido na tabela", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        telaMenu.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void tfIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfIDFocusLost
        this.usuarioCurrent.setIdUser(this.tfID.getInteger());
    }//GEN-LAST:event_tfIDFocusLost

    private void tfNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNomeFocusLost
        this.usuarioCurrent.setNome(this.tfNome.getText());
    }//GEN-LAST:event_tfNomeFocusLost

    private void tfUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfUserFocusLost
        this.usuarioCurrent.setUser(this.tfUser.getText());
    }//GEN-LAST:event_tfUserFocusLost

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (usuarioOld != null) {
            this.usuarioCurrent.setIdUser(this.usuarioOld.getIdUser());
            this.usuarioCurrent.setNome(this.usuarioOld.getName());
            this.usuarioCurrent.setUser(this.usuarioOld.getLogName());
            this.usuarioCurrent.setHashCode(this.usuarioOld.getHashCode());
            this.usuarioCurrent.setPermissao(this.usuarioOld.getPermissao());
            this.tfID.setInteger(this.usuarioOld.getIdUser());
            this.tfNome.setText(this.usuarioOld.getName());
            this.tfUser.setText(this.usuarioOld.getLogName());
            this.tfSenha.setText("");
            this.cbUserPermissao.setSelectedItem(this.usuarioOld.getPermissao());
        }

        this.tbConsulta.revalidate();
        this.tbConsulta.repaint();

        this.tfID.setEditable(false);
        this.tfNome.setEditable(false);
        this.tfUser.setEditable(false);
        this.tfSenha.setEditable(false);
        this.cbUserPermissao.setEnabled(false);
        
        this.btnSalvar.setEnabled(false);
        this.btnCancelar.setEnabled(false);
        this.btnVoltar.setEnabled(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        IDao<Usuario, Integer> dao = DaoFactory.criarUsuarioDao();

        try {
            if (novo) {
                dao.create(usuarioCurrent);

                ArrayList<Usuario> usuarios = DaoFactory.criarUsuarioDao().readAll();
                this.tbConsulta.setModel(new TableModelUsuario(usuarios));
            } else {
                dao.update(usuarioCurrent);
            }

            this.tbConsulta.revalidate();
            this.tbConsulta.repaint();

            this.tfID.setEditable(false);
            this.tfNome.setEditable(false);
            this.tfUser.setEditable(false);
            this.tfSenha.setEditable(false);
            this.cbUserPermissao.setEnabled(false);
            
            this.btnSalvar.setEnabled(false);
            this.btnCancelar.setEnabled(false);
            this.btnVoltar.setEnabled(true);
        } catch (KeyViolationException | InvalidKeyException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (NotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

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

    private void tfSenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfSenhaFocusLost
        this.usuarioCurrent.setHashCode(new String(this.tfSenha.getPassword()));
    }//GEN-LAST:event_tfSenhaFocusLost

    private void cbUserPermissaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbUserPermissaoFocusLost
        this.usuarioCurrent.setPermissao((UserPermissao) this.cbUserPermissao.getSelectedItem());
    }//GEN-LAST:event_cbUserPermissaoFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<UserPermissao> cbUserPermissao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbConsulta;
    private br.univates.raiz.JIntegerField tfID;
    private br.univates.raiz.JTextFieldCustomized tfNome;
    private javax.swing.JPasswordField tfSenha;
    private br.univates.raiz.JTextFieldCustomized tfUser;
    // End of variables declaration//GEN-END:variables
}
