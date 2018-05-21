package utn111.pizzeria.cocina;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

@SuppressWarnings("serial")
public class CocinaView extends JFrame {

  public CocinaView() {
    initVentana();
    initPanelListadoPedidos();
  }

  private void initVentana() {
    this.setBounds(300, 50, 1000, 700);
  }

  private void initPanelListadoPedidos() {
    final JPanel panel = new JPanel();
    panel.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 3;
    gbc.weightx = 1;
    gbc.weighty = 1;
    panel.add(crearTablaPedidos(), gbc);
    panel.add(crearBotonActualizar());
    add(panel);
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