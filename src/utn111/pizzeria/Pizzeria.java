package utn111.pizzeria;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import utn111.pizzeria.admin.AdminView;
import utn111.pizzeria.cajero.CajeroView;
import utn111.pizzeria.cocina.CocinaView;

public class Pizzeria {

  public static void main(String[] args) throws Exception {

    if (args == null || args.length != 1) {
      throw new IllegalArgumentException();
    }

    lanzarVentana(args[0]);
  }

  private static void lanzarVentana (final String tipo) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override public void run() {
        final JFrame ventana = getVentana(tipo);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
      }
    });
  }

  public static JFrame getVentana (final String tipo) {
    switch (tipo) {
    case "admin" : return new AdminView();
    case "cajero": return new CajeroView();
    case "cocina": return new CocinaView();
    default:
      throw new IllegalArgumentException();
    }
  }

}
