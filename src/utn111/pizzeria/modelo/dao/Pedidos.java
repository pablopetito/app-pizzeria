package utn111.pizzeria.modelo.dao;

import java.util.Date;

public class Pedidos {

  private int id;
  private int cliente;
  private Date pedido_a_las;
  private Date entregado_a_las;
  private String estado;

  public Pedidos () {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getCliente() {
    return cliente;
  }

  public void setCliente(int cliente) {
    this.cliente = cliente;
  }

  public Date getPedido_a_las() {
    return pedido_a_las;
  }

  public void setPedido_a_las(Date pedido_a_las) {
    this.pedido_a_las = pedido_a_las;
  }

  public Date getEntregado_a_las() {
    return entregado_a_las;
  }

  public void setEntregado_a_las(Date entregado_a_las) {
    this.entregado_a_las = entregado_a_las;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }
}
