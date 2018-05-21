package utn111.pizzeria.modelo.dao;

import java.util.Date;

public class Pedido {

  private int id;
  private int cliente;
  private Date pedidoALas;
  private Date entregadoALas;
  private String estado;

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

  public Date getPedidoALas() {
    return pedidoALas;
  }

  public void setPedidoALas(Date pedidoALas) {
    this.pedidoALas = pedidoALas;
  }

  public Date getEntregadoALas() {
    return entregadoALas;
  }

  public void setEntregadoALas(Date entregadoALas) {
    this.entregadoALas = entregadoALas;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }
}
