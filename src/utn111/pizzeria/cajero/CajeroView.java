package utn111.pizzeria.cajero;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

@SuppressWarnings("serial")
public class CajeroView extends JFrame {
  public CajeroView() {
    final JPanel allPanelsContainer = new JPanel();
    allPanelsContainer.setSize(500, 400);
    setSize(allPanelsContainer.getSize());
    allPanelsContainer.setLayout(new GridLayout(3, 1));// set LayoutManager
    GridBagConstraints gbc = new GridBagConstraints();
    Border eBorder = BorderFactory.createEtchedBorder();
    
    //UPPER CONTAINER
    final JPanel upperContainer = new JPanel();
    upperContainer.setBorder(BorderFactory.createTitledBorder(eBorder));
    upperContainer.setLayout(new GridBagLayout());
    //components
    String comboBoxItems[] = {};
    JComboBox dropClientes = new JComboBox<Object>(comboBoxItems);
    dropClientes.setBorder(BorderFactory.createTitledBorder(eBorder));
    gbc.fill = GridBagConstraints.WEST;
    gbc.ipady = 40;
    JButton boton = new JButton();
    upperContainer.add(dropClientes,gbc);
    upperContainer.add(boton);

    //MIDDLE CONTAINER
    final JPanel middleContainer = new JPanel();
    middleContainer.setBorder(BorderFactory.createTitledBorder(eBorder));

    //LOWER CONTAINER
    final JPanel lowerContainer = new JPanel();
    lowerContainer.setBorder(BorderFactory.createTitledBorder(eBorder));
    
    allPanelsContainer.add(upperContainer);
    allPanelsContainer.add(middleContainer);
    allPanelsContainer.add(lowerContainer);
    add(allPanelsContainer);
  }
}
