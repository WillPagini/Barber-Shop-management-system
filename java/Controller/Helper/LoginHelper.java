/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Model.Usuario;
import View.Login;

/**
 *
 * @author Usuario
 */
public class LoginHelper implements IHelper{
    
    private final Login view;

    public LoginHelper(Login view) {
        this.view = view;
    }
    
    public Usuario obterModelo(){
        String nome = view.getjTextField1().getText();
        String senha = view.getjPasswordField1().getText();
        
        Usuario modelo = new Usuario(0, nome, senha);
        
        return modelo;
    }
    
    public void setarModelo(Usuario modelo){
        String nome = modelo.getNome();
        String senha = modelo.getSenha();
        
        view.getjTextField1().setText(nome);
        view.getjPasswordField1().setText(senha);
    }
    
    public void limparTela(){
        view.getjTextField1().setText("");
        view.getjPasswordField1().setText("");
    }
}
