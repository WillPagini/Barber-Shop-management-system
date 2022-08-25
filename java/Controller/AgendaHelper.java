/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helper.IHelper;
import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import View.Agenda;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class AgendaHelper implements IHelper{
    
    private final Agenda view;

    public AgendaHelper(Agenda view) {
        this.view = view;
    }

    void preencherTabela(ArrayList<Agendamento> agendamentos) {
        
        DefaultTableModel tableModel = (DefaultTableModel) view.getjTable1().getModel();
        tableModel.setNumRows(0);
        
        //Percorrer a lsita preenchendo o table model
        for (Agendamento agendamento : agendamentos) {
            
            tableModel.addRow(new Object[]{
                
                agendamento.getId(),
                agendamento.getCliente().getNome(),
                agendamento.getServico().getDescricao(),
                agendamento.getValor(),
                agendamento.getDataS(),
                agendamento.getHoraS(),
                agendamento.getObservacao()
            });
        }
    }

    void preencherClientes(ArrayList<Cliente> clientes) {
        
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getjComboBoxCliente().getModel();
        
        for (Cliente cliente : clientes) {
            
            comboBoxModel.addElement(cliente); //preenche o combobox da view com a lista de clientes retonada pelo helper
        }
    }

    void preecherServicos(ArrayList<Servico> servicos) {
        
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getjComboBoxServico().getModel();

        for (Servico servico : servicos) {
            comboBoxModel.addElement(servico);
        }
    }

    public Cliente obterCliente() {
       return (Cliente) view.getjComboBoxCliente().getSelectedItem();
    }    
    
    public Servico obterServico() {
       return (Servico) view.getjComboBoxServico().getSelectedItem();
    }

    void setarValor(float valor) {
        view.getjTextValor().setText(valor+"");
    }

    // Polimorfismo é o conceito pelo qual uma superclasse implementa um método de um tipo (Object)
    // porém a classe implementa um tipo proprio para o mesmo método
    @Override
    public Agendamento obterModelo() {
        
        String idString = view.getjTextFieldId().getText();
        int id = Integer.parseInt(idString);
        Cliente cliente = obterCliente();
        Servico servico = obterServico();
        String valorString = view.getjTextValor().getText();
        float valor = Float.parseFloat(valorString);
        String data= view.getjTextFieldData().getText();
        String hora = view.getjTextFieldHora().getText();
        String dataHora = data + " " + hora;
        String observacao = view.getjTextAreaObservacao().getText();
        
        Agendamento agendamento = new Agendamento(id, cliente, servico, valor, dataHora, observacao);
        return agendamento;
    }

    @Override
    public void limparTela() {
        
        view.getjTextFieldId().setText("0");
        view.getjTextFieldData().setText("");
        view.getjTextFieldHora().setText("");
        view.getjTextAreaObservacao().setText("");
        
    }
    
   

}
