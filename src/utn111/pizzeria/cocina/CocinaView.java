package utn111.pizzeria.cocina;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
public class CocinaView extends JFrame {

  public CocinaView() {

    this.setBounds(300, 50, 1000, 700);

    final JPanel panel = new JPanel();

    JButton botonActualizar = new JButton("Actualizar");
    botonActualizar.setBounds(800, 600, 100, 30);
    panel.add(botonActualizar);
           
    JScrollPane scrollLista = new JScrollPane();
    scrollLista.setBounds(20, 120,400, 300);
    
    String titulos[] = { "Cant.", "Detalle" };
    String[][] pedidos = new String[3][2];
    
    JTable tablaPedidos = new JTable(pedidos, titulos);
    tablaPedidos.setEnabled(false);
    TableColumnModel modeloColumnas = tablaPedidos.getColumnModel();

    tablaPedidos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    modeloColumnas.getColumn(0).setPreferredWidth(50);
    modeloColumnas.getColumn(1).setPreferredWidth(347);

    scrollLista.setViewportView(tablaPedidos);
    
    panel.add(scrollLista);    
    
    panel.setLayout(null);

    add(panel);

  }
}
