package utn111.pizzeria.cajero;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class CajeroView extends JFrame {
  public CajeroView() {
    final JPanel allPanelsContainer = createAllElementsContainer();

    //UPPER CONTAINER
    final JPanel upperContainer = initUpperContainer();

    //MIDDLE CONTAINER
    final JPanel middleContainer = initMiddleContainer();

    //LOWER CONTAINER
    final JPanel lowerContainer = initLowerContainer();

    //Set components
    allPanelsContainer.add(upperContainer);
    allPanelsContainer.add(middleContainer);
    allPanelsContainer.add(lowerContainer);
    add(allPanelsContainer);
  }

  private JPanel createAllElementsContainer(){
    final JPanel allPanelsContainer = new JPanel();
    allPanelsContainer.setSize(500, 400);
    setSize(allPanelsContainer.getSize());
    allPanelsContainer.setLayout(new GridLayout(3, 1));// set LayoutManager
    return allPanelsContainer;
  }

  private JPanel createMainContainers() {
    final JPanel container = new JPanel();
    container.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder()));
    return container;
  }

  private JPanel initUpperContainer() {
    final JPanel upperContainer = createMainContainers();
    upperContainer.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    String[] listaClientes = {}; //contiene los clientes de dropClientes.
    JComboBox<String> dropClientes = new JComboBox<>(listaClientes);
    gbc.fill = GridBagConstraints.WEST;
    gbc.ipady = 40;
    JButton boton = new JButton();
    upperContainer.add(dropClientes,gbc);
    upperContainer.add(boton);
    return  upperContainer;
  }

  private JPanel initMiddleContainer() {
    final JPanel middleContainer = createMainContainers();
    //Estructura base para agregar proximas funcionalidades.
    return middleContainer;
  }

  private JPanel initLowerContainer() {
    final JPanel lowerContainer = createMainContainers();
    //Estructura base para agregar proximas funcionalidades.
    return lowerContainer;
  }
}
