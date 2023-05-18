/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.persistencia;

import br.univates.negocio.CategoriaProduto;
import br.univates.negocio.Mesa;
import br.univates.negocio.Pedido;
import br.univates.negocio.Produto;
import br.univates.negocio.StatusAtendimento;
import br.univates.negocio.TipoPagamento;
import br.univates.negocio.Usuario;
import br.univates.raiz.persistence.IDao;

/**
 *
 * @author luis.dutra
 */
public class DaoFactory {
    
    public static IDao<CategoriaProduto,Integer> criarCategoriaProdutoDao()
    {
        return new CategoriaProdutoDaoPostgres();
    }
    
    public static IDao<Mesa,Integer> criarMesaDao()
    {
        return new MesaDaoPostgres();
    }
    
    public static IDao<Pedido,Integer> criarPedidoDao()
    {
        return new PedidoDaoPostgres();
    }
    
    public static IDao<Produto,Integer> criarProdutoDao()
    {
        return new ProdutoDaoPostgres();
    }
    
    public static IDao<StatusAtendimento,Integer> criarStatusAtendimentoDao()
    {
        return new StatusAtendimentoDaoPostgres();
    }
    
    public static IDao<TipoPagamento,Integer> criarTipoPagamentoDao()
    {
        return new TipoPagamentoDaoPostgres();
    }
    
    public static IDao<Usuario,Integer> criarUsuarioDao()
    {
        return new UsuarioDaoPostgres();
    }
}
