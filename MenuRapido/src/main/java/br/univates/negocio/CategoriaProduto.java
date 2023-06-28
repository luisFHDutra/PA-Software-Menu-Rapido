/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.negocio;

/**
 *
 * @author luis.dutra
 */
public class CategoriaProduto implements Comparable<CategoriaProduto> {
    
    private Integer idCategoria;
    private String nome;

    public CategoriaProduto(Integer idCategoria, String nome) {
        this.idCategoria = idCategoria;
        this.nome = nome;
    }

    public CategoriaProduto() {
        this.idCategoria = null;
        this.nome = "";
    }
    
    public Integer getIdCategoria() {
        return idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public int compareTo(CategoriaProduto categoria) {
        
        return (toString().compareTo(categoria.getNome()));
    }
    
    @Override
    public String toString()
    {
        return this.nome+"";
    }
    
    @Override
    public boolean equals(Object objeto)
    {
        if (this == objeto) {
            return true;
        }
        if (objeto == null || getClass() != objeto.getClass()) {
            return false;
        }
        CategoriaProduto outraCategoria = (CategoriaProduto) objeto;
        if (idCategoria == null) {
            return outraCategoria.getIdCategoria() == null;
        }
        return idCategoria.equals(outraCategoria.getIdCategoria());
    }
    
    @Override
    public CategoriaProduto clone()
    {
        return new CategoriaProduto(this.idCategoria,this.nome);
    }
}
