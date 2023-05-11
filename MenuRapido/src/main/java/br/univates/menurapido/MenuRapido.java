/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package br.univates.menurapido;

import br.univates.apresentacao.Tela;
import br.univates.negocio.Usuario;
import br.univates.persistencia.DaoFactory;
import br.univates.raiz.auth.Authenticator;
import java.util.ArrayList;

/**
 *
 * @author luis.dutra
 */
public class MenuRapido {

    public static void main(String[] args) {
        Sys sys = Sys.getInstance();
        
        ArrayList<Usuario> users = DaoFactory.criarUsuarioDao().readAll();
        
        for(Usuario user: users) {
            System.out.println(user.getIdUser() + "" + user.getHashCode());
        }
        
        Authenticator auth = new Authenticator( users );

        if (auth.showDialog(true))
        {
            sys.setUser( auth.getLoggedUser() );
            
            Tela t = new Tela();
            t.setVisible(true);
        }  
    }
}
