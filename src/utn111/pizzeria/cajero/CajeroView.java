package utn111.pizzeria.cajero;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CajeroView extends JFrame {
  public CajeroView () {
    final JPanel panel = new JPanel();
    panel.setSize(500, 400);
    setSize(panel.getSize());
    panel.setLayout(null);
    
    JComboBox<?> dropClientes = new JComboBox<Object>();
    dropClientes.setBounds(50, 30, 112, 20);
    
    panel.add(dropClientes);
    
    add(panel);
  }
}