package com.example;

import java.awt.Dimension;
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
    private JButton removerPagamento;
    private JTextField nomePagamento;
    private int indexPagamento;
    private JList <String> listaPagamento; 
    private JScrollPane scrollPagamento;
    private JTextField aPagar;
    private JTextField pago;
    JList<String> list;

    DefaultListModel<String> model;
    
    public Tela(){
        Painel = new JPanel();
        model = new DefaultListModel<>();
        nomePagamento = new JTextField();
        nomePagamento.setPreferredSize(new Dimension(100, 26));
        adicionarPagamento = new JButton("Criar Pagamento");
        removerPagamento = new JButton("Excluir");
        model.addElement("Teste");
        model.addElement("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        list = new JList<>(model);
        scrollPagamento = new JScrollPane(list);

        adicionarPagamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String _nomePagamento = nomePagamento.getText();
                model.addElement(_nomePagamento);
                nomePagamento.setText("");
            }
        });

        removerPagamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indexPagamento = list.getSelectedIndex();
                model.removeElementAt(indexPagamento);
            }
        });
        
        
        Painel.add(scrollPagamento);
        Painel.add(adicionarPagamento);
        Painel.add(nomePagamento);
        Painel.add(removerPagamento);
    }

    public JPanel getPainel() {
        return Painel;
    }
}
