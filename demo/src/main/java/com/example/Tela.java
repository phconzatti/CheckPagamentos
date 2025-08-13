package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Tela {
    
    private JPanel Painel;
    private JButton adicionarPagamentoButton;
    private JButton removerPagamentoButton;
    private JButton pagamentoEfetuadoButton;
    private JTextField nomePagamento;
    private int indexPagamento;
    private int indexPagos;
    private JList <String> listaPagamento; 
    private JList <String> listaPagos;
    private JScrollPane scrollPagamento;
    private JScrollPane scrollPagos;
    private JLabel pagosLabel;
    private JLabel aPagarLabel;
    private JLabel adicionarLabel;

    DefaultListModel<String> model;
    DefaultListModel<String> modelPago;
    
    public Tela(){
        Painel = new JPanel();
        Painel.setLayout(null);
        model = new DefaultListModel<>();
        modelPago = new DefaultListModel<>();
        nomePagamento = new JTextField();
        adicionarPagamentoButton = new JButton("Adicionar");
        removerPagamentoButton = new JButton("Excluir");
        pagamentoEfetuadoButton = new JButton("Pago");
        listaPagamento = new JList<>(model);
        listaPagos = new JList<>(modelPago);
        scrollPagamento = new JScrollPane(listaPagamento);
        scrollPagos = new JScrollPane(listaPagos);
        pagosLabel = new JLabel("Pagos:");
        aPagarLabel = new JLabel("A pagar:");
        adicionarLabel = new JLabel("Novo pagamento:");
        indexPagamento = -1;
        indexPagos = -1;

        adicionarPagamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String _nomePagamento = nomePagamento.getText();
                model.addElement(_nomePagamento);
                nomePagamento.setText("");
            }
        });

        removerPagamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removePagamentoMetodo();
            }
        });
        
        pagamentoEfetuadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indexPagamento = listaPagamento.getSelectedIndex();
                modelPago.addElement(model.getElementAt(indexPagamento));
                model.removeElementAt(indexPagamento);
            }
        });

        Painel.add(aPagarLabel);
        Painel.add(scrollPagamento);
        Painel.add(adicionarPagamentoButton);
        Painel.add(adicionarLabel);
        Painel.add(nomePagamento);
        Painel.add(removerPagamentoButton);
        Painel.add(pagamentoEfetuadoButton);
        Painel.add(pagosLabel);
        Painel.add(scrollPagos);

        aPagarLabel.setBounds(10,0,50,50);   
        scrollPagamento.setBounds(10, 51, 400, 200);  
        adicionarLabel.setBounds(425, 0, 120, 50);
        nomePagamento.setBounds(425, 51, 250, 26);
        adicionarPagamentoButton.setBounds(675, 51, 100, 26);
        removerPagamentoButton.setBounds(425, 180, 100, 26);
        pagamentoEfetuadoButton.setBounds(425, 150, 100, 26);
        pagosLabel.setBounds(10, 260, 50, 50);
        scrollPagos.setBounds(10, 311, 400, 200);
    }

    public JPanel getPainel() {
        return Painel;
    }

    public void removePagamentoMetodo() {
        indexPagamento = listaPagamento.getSelectedIndex();
        indexPagos = listaPagos.getSelectedIndex();
        if (indexPagamento == -1 && indexPagos == -1) {
            return;
        }
        if (indexPagamento == -1 && indexPagos != -1) {
            modelPago.removeElementAt(indexPagos);
        } else {
            model.removeElementAt(indexPagamento);
        }
    }
}
