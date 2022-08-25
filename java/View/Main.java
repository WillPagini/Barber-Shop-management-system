/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import Model.Usuario;

/**
 *
 * @author Usuario
 */
public class Main {
    
    
    public static void main(String[] arg){
        
        Servico barba = new Servico(0, "Serviço de barba", 10);
        
        Cliente cliente1 = new Cliente("Rua tito livio", "666", 2, "Will"); 
        
        System.out.println(cliente1.getNome());
        
        Usuario user1 = new Usuario(1, "BarberMan", "senha456");
        
        System.out.println(user1);
        
        Agendamento agendamento = new Agendamento(1, cliente1, barba, 30, "20/07//2022 17:00");
        System.out.println(agendamento);
    }
}
