package utn111.pizzeria.cajero;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class NuevoClienteView extends JFrame {
    public NuevoClienteView(){
        this.setBounds(300, 50, 1000, 700);

        final JPanel panel = new JPanel();

        JButton botonCancelar = new JButton("Cancelar pedido");
        botonCancelar.setBounds(800, 600, 150, 30);
        panel.add(botonCancelar);

        panel.setLayout(null);

        add(panel);
    }
}
