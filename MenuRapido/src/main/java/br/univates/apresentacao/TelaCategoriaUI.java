/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.univates.apresentacao;

import br.univates.menurapido.Sys;
import br.univates.negocio.CategoriaProduto;
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
public class TelaCategoriaUI extends javax.swing.JFrame {

    private CategoriaProduto categoriaCurrent;
    private CategoriaProduto categoriaOld;
    private boolean novo;
    private TelaMenuUI telaMenu;

    /**
     * Creates new form TelaUsuarioUI
     */
    public TelaCategoriaUI(TelaMenuUI tela) {
        initComponents();

        this.setTitle("Categoria de Produtos");
        
        ArrayList<CategoriaProduto> categoria = DaoFactory.criarCategoriaProdutoDao().readAll();

        this.tbConsulta.setModel(new TableModelCategoria(categoria));
        this.novo = false;

        this.btnSalvar.setEnabled(false);
        this.btnCancelar.setEnabled(false);

        this.btnVoltar.setEnabled(true);

        this.tfID.setEditable(false);
        this.tfNome.setEditable(false);

        this.telaMenu = tela;

        this.setLocationRelativeTo(null);
    }

    private void setCategoria(CategoriaProduto categoria) {

        this.categoriaCurrent = categoria;

        if (categoria.getIdCategoria() == 0) {
            this.tfID.setText("");
        } else {
            this.tfID.setInteger(categoria.getIdCategoria());
        }

        this.tfNome.setText(categoria.getNome());
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
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        tfID = new br.univates.raiz.JIntegerField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfNome = new br.univates.raiz.JTextFieldCustomized();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

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
        tbConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbConsultaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbConsulta);

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar))
                .addGap(80, 80, 80))
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnExcluir)
                        .addComponent(btnEditar)
                        .addComponent(btnNovo))
                    .addComponent(btnVoltar))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbConsultaMouseClicked
        int linhaSelecionada = this.tbConsulta.getSelectedRow();

        TableModelCategoria model = (TableModelCategoria) this.tbConsulta.getModel();
        CategoriaProduto categoria = model.getCategorias().get(linhaSelecionada);

        this.setCategoria(categoria);
    }//GEN-LAST:event_tbConsultaMouseClicked

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed

        this.btnSalvar.setEnabled(true);
        this.btnCancelar.setEnabled(true);
        this.btnVoltar.setEnabled(true);

        this.tfID.setEditable(true);
        this.tfNome.setEditable(true);

        this.novo = true;

        if (categoriaCurrent != null) {
            this.categoriaOld = categoriaCurrent.clone();
        }

        this.setCategoria(new CategoriaProduto());
        this.tfID.requestFocus();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        if (categoriaCurrent != null) {
            this.categoriaOld = categoriaCurrent.clone();
            this.btnSalvar.setEnabled(true);
            this.btnCancelar.setEnabled(true);
            this.btnVoltar.setEnabled(true);

            this.novo = false;
            this.tfID.setEditable(false);
            this.tfNome.setEditable(true);
            this.tfNome.requestFocus();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma categoria na tabela", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (categoriaCurrent != null) {
            try {
                int x = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir?",
                        "Confirmação",
                        JOptionPane.YES_NO_OPTION);

                if (x == 0) {
                    DaoFactory.criarCategoriaProdutoDao().delete(categoriaCurrent.getIdCategoria());

                    TableModelCategoria model = (TableModelCategoria) this.tbConsulta.getModel();
                    model.getCategorias().remove(categoriaCurrent);

                    this.tbConsulta.revalidate();
                    this.tbConsulta.repaint();
                    this.tfID.setText("");
                    this.tfNome.setText("");

                    this.categoriaCurrent = null;
                }
            } catch (NotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Esta categoria não pode ser deletada", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma categoria na tabela", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        telaMenu.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void tfIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfIDFocusLost
        this.categoriaCurrent.setIdCategoria(this.tfID.getInteger());
    }//GEN-LAST:event_tfIDFocusLost

    private void tfNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNomeFocusLost
        this.categoriaCurrent.setNome(this.tfNome.getText());
    }//GEN-LAST:event_tfNomeFocusLost

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (categoriaOld != null) {
            this.categoriaCurrent.setIdCategoria(this.categoriaOld.getIdCategoria());
            this.categoriaCurrent.setNome(this.categoriaOld.getNome());
            this.tfID.setInteger(this.categoriaOld.getIdCategoria());
            this.tfNome.setText(this.categoriaOld.getNome());
        }

        this.tbConsulta.revalidate();
        this.tbConsulta.repaint();

        this.tfID.setEditable(false);
        this.tfNome.setEditable(false);

        this.btnSalvar.setEnabled(false);
        this.btnCancelar.setEnabled(false);
        this.btnVoltar.setEnabled(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        IDao<CategoriaProduto, Integer> dao = DaoFactory.criarCategoriaProdutoDao();

        try {
            if (novo) {
                dao.create(categoriaCurrent);

                TableModelCategoria model = (TableModelCategoria) this.tbConsulta.getModel();
                model.getCategorias().add(categoriaCurrent);
            } else {
                dao.update(categoriaCurrent);
            }

            this.tbConsulta.revalidate();
            this.tbConsulta.repaint();

            this.tfID.setEditable(false);
            this.tfNome.setEditable(false);

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbConsulta;
    private br.univates.raiz.JIntegerField tfID;
    private br.univates.raiz.JTextFieldCustomized tfNome;
    // End of variables declaration//GEN-END:variables
}
