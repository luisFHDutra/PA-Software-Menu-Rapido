/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.univates.apresentacao;

import br.univates.negocio.CategoriaProduto;
import br.univates.negocio.Produto;
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
public class TelaProdutoUI extends javax.swing.JFrame {

    private Produto produtoCurrent;
    private Produto produtoOld;
    private boolean novo;
    private TelaMenuUI telaMenu;
    
    /**
     * Creates new form TelaUsuarioUI
     */
    public TelaProdutoUI( TelaMenuUI tela) {
        initComponents();
        
        ArrayList<Produto> produtos = DaoFactory.criarProdutoDao().readAll();
        
        this.tbConsulta.setModel( new TableModelProduto(produtos));
        this.novo = false;
        
        this.btnSalvar.setEnabled(false);
        this.btnCancelar.setEnabled(false);
        
        this.btnVoltar.setEnabled(true);
        
        this.tfID.setEditable(false);
        this.tfNome.setEditable(false);
        this.tfDescricao.setEditable(false);
        this.tfValor.setEditable(false);
        this.cbCategoria.setEnabled(false);
        
        ArrayList<CategoriaProduto> categorias = DaoFactory.criarCategoriaProdutoDao().readAll();
        
        if (categorias == null) {
            this.initCombos( new ArrayList<>() );
        } else {
            this.initCombos(categorias);
        }
        
        this.telaMenu = tela;
        
        this.setLocationRelativeTo(null);
    }
    
    private void setProduto(Produto produto) {
    
        this.produtoCurrent = produto;
        
        if (produto.getIdProduto()== 0) {
            this.tfID.setText("" );
        } else {
            this.tfID.setInteger(produto.getIdProduto());
        }
        
        this.tfNome.setText(produto.getNome());
        this.tfDescricao.setText(produto.getDescricao());
        
//        if (produto.getValorProduto()== 0) {
//            this.tfValor.setText("");
//        } else {
//            this.tfValor.setDouble(produto.getValorProduto());
//        }
        
        this.tfValor.setDouble(produto.getValorProduto());
        
        if (produto.getCategoria() != null) {
            this.cbCategoria.setSelectedItem(produto.getCategoria());
        }
    }

    private void initCombos(ArrayList<CategoriaProduto> categoriaValidadas)
    {
        this.cbCategoria.removeAllItems();
        for (CategoriaProduto categoria: categoriaValidadas)
        {
            cbCategoria.addItem(categoria);
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
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        tfID = new br.univates.raiz.JIntegerField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfNome = new br.univates.raiz.JTextFieldCustomized();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfDescricao = new br.univates.raiz.JTextFieldCustomized();
        cbCategoria = new javax.swing.JComboBox<>();
        tfValor = new br.univates.raiz.JCurrencyField();

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

        jLabel4.setText("Descrição:");

        jLabel5.setText("Valor:");

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

        jLabel1.setText("Categoria:");

        tfDescricao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfDescricaoFocusLost(evt);
            }
        });

        cbCategoria.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbCategoriaFocusLost(evt);
            }
        });

        tfValor.setText("jCurrencyField1");
        tfValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfValorFocusLost(evt);
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
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(12, 12, 12)
                                .addComponent(tfDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 170, Short.MAX_VALUE)
                                        .addComponent(btnCancelar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSalvar))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addGap(40, 40, 40)
                        .addComponent(tfValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
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
                    .addComponent(jLabel1)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar))
                .addContainerGap(12, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
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

    private void tbConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbConsultaMouseClicked
        int linhaSelecionada  = this.tbConsulta.getSelectedRow();
        
        TableModelProduto model = (TableModelProduto)this.tbConsulta.getModel();
        Produto produto = model.getProdutos().get( linhaSelecionada );
        
        this.setProduto(produto);
    }//GEN-LAST:event_tbConsultaMouseClicked

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        
        this.btnSalvar.setEnabled(true);
        this.btnCancelar.setEnabled(true);
        this.btnVoltar.setEnabled(true);
        
        this.tfID.setEditable(true);
        this.tfNome.setEditable(true);
        this.tfDescricao.setEditable(true);
        this.tfValor.setEditable(true);
        this.cbCategoria.setEnabled(true);
        
        this.novo = true;
        
        if (produtoCurrent != null) {
            this.produtoOld = produtoCurrent.clone();
        }
        
        this.setProduto(new Produto());
        this.tfID.requestFocus();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        
        if (produtoCurrent != null) {
            this.produtoOld = produtoCurrent.clone();
            this.btnSalvar.setEnabled(true);
            this.btnCancelar.setEnabled(true);
            this.btnVoltar.setEnabled(true);
            
            this.novo = false;
            this.tfID.setEditable(false);
            this.tfDescricao.setEditable(false);
            this.tfValor.setEditable(true);
            this.tfNome.setEditable(false);
            this.cbCategoria.setEnabled(false);
            this.tfNome.requestFocus();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um produto na tabela", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (produtoCurrent != null)
        {
            try
            {
                int x = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir?", 
                                                            "Confirmação", 
                                                            JOptionPane.YES_NO_OPTION);
                
                if (x == 0)
                {
                    DaoFactory.criarProdutoDao().delete( produtoCurrent.getIdProduto());

                    TableModelProduto model = (TableModelProduto)this.tbConsulta.getModel();
                    model.getProdutos().remove(produtoCurrent);

                    this.tbConsulta.revalidate();
                    this.tbConsulta.repaint();
                    this.tfID.setText( "" );
                    this.tfNome.setText( "" );
                    this.tfDescricao.setText( "" );
                    this.tfValor.setText( "" );
                    
                    this.produtoCurrent = null;
                }
            } 
            catch (NotFoundException ex)
            {
                JOptionPane.showMessageDialog(this, "Este produto não pode ser deletado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Selecione um produto na tabela", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        telaMenu.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void tfIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfIDFocusLost
        this.produtoCurrent.setIdProduto(this.tfID.getInteger());
    }//GEN-LAST:event_tfIDFocusLost

    private void tfNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNomeFocusLost
        this.produtoCurrent.setNome(this.tfNome.getText());
    }//GEN-LAST:event_tfNomeFocusLost

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (produtoOld != null)
        {
            this.produtoCurrent.setIdProduto(this.produtoOld.getIdProduto());
            this.produtoCurrent.setNome( this.produtoOld.getNome());
            this.produtoCurrent.setCategoria(this.produtoOld.getCategoria());
            this.produtoCurrent.setDescricao(this.produtoOld.getDescricao());
            this.produtoCurrent.setValorProduto(this.produtoOld.getValorProduto());
            this.tfID.setInteger(this.produtoOld.getIdProduto() );
            this.tfNome.setText( this.produtoOld.getNome());
            this.tfDescricao.setText( this.produtoOld.getDescricao());
            this.tfValor.setDouble( this.produtoOld.getValorProduto() );
            this.cbCategoria.setSelectedItem(this.produtoOld.getCategoria());
        }
        
        this.tbConsulta.revalidate();
        this.tbConsulta.repaint();
        
        this.tfID.setEditable(false);
        this.tfNome.setEditable(false);
        this.tfDescricao.setEditable(false);
        this.tfValor.setEditable(false);
        this.cbCategoria.setEnabled(false);

        this.btnSalvar.setEnabled(false);
        this.btnCancelar.setEnabled(false);
        this.btnVoltar.setEnabled(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        this.produtoCurrent.setValorProduto(this.tfValor.getDouble());
        IDao<Produto,Integer> dao = DaoFactory.criarProdutoDao();
        
        try
        {
            if (novo)
            {
                dao.create(produtoCurrent);

                TableModelProduto model = (TableModelProduto)this.tbConsulta.getModel();
                model.getProdutos().add(produtoCurrent);
            } else {
                dao.update(produtoCurrent);
            }

            this.tbConsulta.revalidate();
            this.tbConsulta.repaint();

            this.tfID.setEditable(false);
            this.tfNome.setEditable(false);
            this.tfDescricao.setEditable(false);
            this.tfValor.setEditable(false);
            this.cbCategoria.setEnabled(false);

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

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    private void tfDescricaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDescricaoFocusLost
        this.produtoCurrent.setDescricao(this.tfDescricao.getText());
    }//GEN-LAST:event_tfDescricaoFocusLost

    private void cbCategoriaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbCategoriaFocusLost
        this.produtoCurrent.setCategoria((CategoriaProduto)this.cbCategoria.getSelectedItem());
    }//GEN-LAST:event_cbCategoriaFocusLost

    private void tfValorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfValorFocusLost
        this.produtoCurrent.setValorProduto(this.tfValor.getDouble());
    }//GEN-LAST:event_tfValorFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<CategoriaProduto> cbCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbConsulta;
    private br.univates.raiz.JTextFieldCustomized tfDescricao;
    private br.univates.raiz.JIntegerField tfID;
    private br.univates.raiz.JTextFieldCustomized tfNome;
    private br.univates.raiz.JCurrencyField tfValor;
    // End of variables declaration//GEN-END:variables
}
