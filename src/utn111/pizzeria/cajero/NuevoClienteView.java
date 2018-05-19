package utn111.pizzeria.cajero;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class NuevoClienteView extends JFrame {

  public NuevoClienteView() {

    setBounds(300, 50, 1000, 700);

    final JPanel panel = new JPanel();

    JButton botonCancelar = new JButton("Cancelar");
    botonCancelar.setBounds(800, 600, 150, 30);
    botonCancelar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        NuevoClienteView.super.dispose();
      }
    });

    panel.add(botonCancelar);

    panel.setLayout(null);

    add(panel);
  }

}
