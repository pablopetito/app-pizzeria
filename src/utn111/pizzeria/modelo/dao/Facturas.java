package utn111.pizzeria.modelo.dao;

public class Facturas {
  private int cliente;
  private int pedido;
  private float total;

  public Facturas() {
    }

  public int getCliente() {
    return cliente;
  }

  public void setCliente(int cliente) {
    this.cliente = cliente;
  }

  public int getPedido() {
    return pedido;
  }

  public void setPedido(int pedido) {
    this.pedido = pedido;
  }

  public float getTotal() {
    return total;
  }

  public void setTotal(float total) {
    this.total = total;
  }
}
