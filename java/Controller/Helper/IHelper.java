/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

/**
 *
 * @author Usuario
 */
public interface IHelper {
    //o método não pode ser do tipo Agendamento porque em LoginHelper o obj é do tipo Login
    //por isso deve ser abstraido como "Object"
    public abstract Object obterModelo();
    
    public abstract void limparTela();
}
