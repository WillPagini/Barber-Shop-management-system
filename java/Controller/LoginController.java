/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Usuario;
import View.Login;
import Controller.Helper.LoginHelper;
import Model.DAO.UsuarioDAO;
import View.MenuPrincipal;

/**
 *
 * @author Usuario
 */
public class LoginController {

    private final Login view;
    private  LoginHelper helper;
    
    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    
    public void entrarNoSistema(){
        //pegar usuario e senha da View
        Usuario usuario = helper.obterModelo();
        
        //pesquisar o Usuario no Banco (o BD eh simulado e os dados estao em um arrayList)
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioAutenticado = usuarioDAO.selectPorNomeESenha(usuario);
        
        if(usuarioAutenticado != null){
            //navegar para menu principal
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
            //fecha tela login
            this.view.dispose();
        }else{
            view.exibeMensagem("Usuário ou senha inválidos");
        }        
        //Se o usuário da View existir no Banco, redirecionar para o Menu
        //Se não, mostrar aviso "Usuario ou senha invalidos"
        

    }
    
    public void fizTarefa(){
        System.out.println("Busquei algo do banco de dados");
        
        this.view.exibeMensagem("executei o FizTarefa");
    }
    
}
