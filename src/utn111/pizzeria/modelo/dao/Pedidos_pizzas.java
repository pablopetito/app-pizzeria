package utn111.pizzeria.modelo.dao;

public class Pedidos_pizzas {

  private int pedido;
  private int pizza;
  private String tamaño;
  private int cantidad;

  public Pedidos_pizzas() {
  }

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
