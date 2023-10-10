package org.dao;
import Formulario.interfaz;


import javax.swing.*;

public class Main
{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tu Aplicación");
        frame.setContentPane(new interfaz().getPanelPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}