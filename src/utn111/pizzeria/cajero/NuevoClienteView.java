package utn111.pizzeria.cajero;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class NuevoClienteView extends JFrame {
  public NuevoClienteView() {
    final JPanel allPanelsContainer = createAllElementsContainer();

    // UPPER CONTAINER
    final JPanel upperContainer = createUpperContainer();

    // MIDDLE CONTAINER
    final JPanel middleContainer = createMiddleContainer();

    // LOWER CONTAINER
    final JPanel lowerContainer = createLowerContainer();

    // Set components
    allPanelsContainer.add(upperContainer);
    allPanelsContainer.add(middleContainer);
    allPanelsContainer.add(lowerContainer);
    add(allPanelsContainer);
  }

  /**
   * Crea el contenedor principal, le setea el tamaño y el LM y lo devuelve.
   *
   * @return el contenedor principal de la ventana Cajero
   */
  private JPanel createAllElementsContainer() {
    final JPanel allPanelsContainer = new JPanel();
    allPanelsContainer.setSize(500, 400);
    setSize(allPanelsContainer.getSize());
    allPanelsContainer.setLayout(new GridLayout(3, 1));// set LayoutManager
    return allPanelsContainer;
  }

  private JPanel createMainContainers() {
    final JPanel container = new JPanel();
    container.setBorder(
        BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder()));
    return container;
  }

  /**
   * Crea el contenedor superior y los elementos del mismo.
   *
   * @return el contenedor. Que posee ya los componentes y los paneles hijos.
   */
  private JPanel createUpperContainer() {
    final JPanel upperContainer = createMainContainers();
    upperContainer.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.WEST;
    gbc.ipady = 40;
    JButton botonCancelar = new JButton("Cancelar");
    botonCancelar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        dispose();
      }
    });
    upperContainer.add(botonCancelar);
    return upperContainer;
  }

  /**
   * Crea el contenedor central y los elementos del mismo.
   *
   * @return el contenedor, con los elementos y los panales hijos.
   */
  private JPanel createMiddleContainer() {
    final JPanel middleContainer = createMainContainers();
    // Estructura base para agregar proximas funcionalidades.
    return middleContainer;
  }

  /**
   * Crea el contenedor inferior y los elementos del mismo.
   *
   * @return el contenedor, con los elementos y los panales hijos.
   */
  private JPanel createLowerContainer() {
    final JPanel lowerContainer = createMainContainers();
    // Estructura base para agregar proximas funcionalidades.
    return lowerContainer;
  }
}
