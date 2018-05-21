package utn111.pizzeria.modelo;

import java.util.Date;

/**
 * Representa una compra de un {@link Cliente}
 */
public interface Factura {

  /**
   * {@link Cliente} al que se le facturo este pedido
   */
  public Cliente getCliente();

  /**
   * {@link Pedido Pizzas} que le fueron entregadas
   */
  public Pedido getPedido();

  /**
   * Fecha en que esta {@link Factura} fue emitida
   */
  public Date getFechaDeCompra();

  /**
   * Monto total abonado por el {@link Cliente cliente}
   */
  public float getTotal();
}
