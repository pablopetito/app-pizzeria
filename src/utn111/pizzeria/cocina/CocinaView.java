package utn111.pizzeria.cocina;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

@SuppressWarnings("serial")
public class CocinaView extends JFrame {

  public CocinaView() {
    initVentana();
    initPanelListadoPedidos();
  }

  private void initVentana() {
    this.setBounds(300, 50, 1000, 700);
  }

  /**
   * Es la clase que crea toda la interfaz grafica.
    */
  private void initPanelListadoPedidos() {
    final JPanel panel = new JPanel();
    panel.setLayout(new GridBagLayout());
    panel.add(crearTablaPedidos(), configGbcTablaPedidos());
    panel.add(crearBotonActualizar(), configGbcBotonActualizar());
    add(panel);
  }

  /**
   * Clase configuradora del GridBagConstraints de tablaPedidos
   * @return un GridBagConstraints configurado para la tabla
   */
  private GridBagConstraints configGbcTablaPedidos() {
    GridBagConstraints gbcTablaPedidos = new GridBagConstraints();
    gbcTablaPedidos.gridx = 0;
    gbcTablaPedidos.gridy = 0;
    gbcTablaPedidos.weightx = 10.0;
    gbcTablaPedidos.weighty = 10.0;
    gbcTablaPedidos.fill = GridBagConstraints.BOTH;
    gbcTablaPedidos.insets = new Insets(10, 10, 10, 10);
    return gbcTablaPedidos;
  }

  /**
   * Clase configuradora del GridBagConstraints de botonActualizar
   * @return un GridBagConstraints configurado para el boton
   */
  private GridBagConstraints configGbcBotonActualizar() {
    GridBagConstraints gbcBotonActualizar = new GridBagConstraints();
    gbcBotonActualizar.gridx = 0;
    gbcBotonActualizar.gridy = 1;
    gbcBotonActualizar.fill = GridBagConstraints.HORIZONTAL;
    gbcBotonActualizar.insets = new Insets(0, 10, 10, 10);
    return gbcBotonActualizar;
  }

  private static JButton crearBotonActualizar() {
    JButton botonActualizar = new JButton("Actualizar");
    return botonActualizar;
  }

  private static JScrollPane crearTablaPedidos() {
    JScrollPane scrollLista = new JScrollPane();
    String[] titulos = { "Cant.", "Detalle" };
    String[][] pedidos = new String[3][2];
    JTable tablaPedidos = new JTable(pedidos, titulos);
    tablaPedidos.setEnabled(false);
    TableColumnModel modeloColumnas = tablaPedidos.getColumnModel();
    modeloColumnas.getColumn(0).setPreferredWidth(50);
    modeloColumnas.getColumn(1).setPreferredWidth(347);
    scrollLista.setViewportView(tablaPedidos);
    return scrollLista;
  }
}