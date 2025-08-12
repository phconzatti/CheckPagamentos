package com.example;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Main extends JFrame{
    private Tela tela;
    public Main () {
        super();
        tela = new Tela();
        JPanel painel = tela.getPainel();
        add(painel);
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        Tela tela = new Tela();
        JPanel painel = tela.getPainel();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setTitle("Lista de pagementos");
        window.add(painel);
        window.setVisible(true);
    }
}