package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Tela {
    
    private JPanel Painel;
    private JButton adicionarPagamento;
    private JTextField nomePagemento;
    private int indexPagamento;
    private JList <String> listaPagamento; 
    private JScrollPane scrollPagamento;
    private JTextField aPagar;
    private JTextField pago;
    JList<String> list;

    DefaultListModel<String> model;
    
    public Tela(){
        Painel = new JPanel();
        adicionarPagamento = new JButton("Criar Pagamento");
        adicionarPagamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String _nomePagamento = nomePagemento.getText();
            }
        });

        model = new DefaultListModel<>();
        model.addElement("Teste");
        list = new JList<>(model);
        scrollPagamento = new JScrollPane(list);
        Painel.add(scrollPagamento);
    }

    public JPanel getPainel() {
        return Painel;
    }
}
