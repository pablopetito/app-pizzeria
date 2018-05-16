package utn111.pizzeria.modelo.dao;

public class Clientes {

  private int nro_cliente;
  private String nombre;
  
  public Clientes () {
  }

  public int getNroCliente() {
    return nro_cliente;
  }

  public void setNroCliente(int nro_cliente) {
      this.nro_cliente = nro_cliente;
    }

  public String getNombre() {
    return nombre;
  }

    public void setNombre(String nombre) {
      this.nombre = nombre;
    }
}
