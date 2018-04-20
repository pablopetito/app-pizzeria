package utn111.pizzeria.cocina;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CocinaView extends JFrame {

  public CocinaView() {

    this.setBounds(300, 50, 1000, 700);

    final JPanel panel = new JPanel();

    JButton botonActualizar = new JButton("Actualizar");
    botonActualizar.setBounds(800, 600, 100, 30);
    panel.add(botonActualizar);

    panel.setLayout(null);

    add(panel);

  }
}
