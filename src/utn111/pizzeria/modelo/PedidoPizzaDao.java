package utn111.pizzeria.modelo;

public class PedidoPizzaDao {

  private int pedido;
  private int pizza;
  private String tamaño;
  private int cantidad;

  public int getPedido() {
    return pedido;
  }

  public void setPedido(int pedido) {
    this.pedido = pedido;
  }

  public int getPizza() {
    return pizza;
  }

  public void setPizza(int pizza) {
    this.pizza = pizza;
  }

  public String getTamaño() {
    return tamaño;
  }

  public void setTamaño(String tamaño) {
    this.tamaño = tamaño;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }
}
