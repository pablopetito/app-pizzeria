package utn111.pizzeria.modelo;

import java.time.Duration;
import java.util.Date;

/**
 * Un pedido es un {@link Item conjunto} de ..
 * <pre>
 *  - {@link Pizza Pizzas}, sus respectivos tamaños, y cantidades de cada tipo
 *  - {@link Cliente} al que debe ser entregado dicho pedido
 * </pre>
 */
public interface Pedido {

  /**
   * El {@link Cliente dueño} del {@link Pedido pedido}
   */
  public Cliente getCliente();

  /**
   * Los distintos {@link Pedido.Item items} que componen este {@link Pedido pedido}
   */
  public Pedido.Item[] getItems();

  /**
   * Fecha y horario en que este {@link Pedido pedido} fue encargado en caja
   */
  public Date getPedidoALas();

  /**
   * @return Fecha y horario en que este {@link Pedido pedido} fue {@link Factura facturado},
   *         o `null` si aun el {@link Pedido pedido} esta en preparacion.
   */
  public Date getEntregadoALas();

  /**
   * Tiempo estimado de espera, mientras el {@link Pedido pedido} se prepara
   */
  public Duration getTiempoEstimadoEspera();

  /**
   * Tiempo real que el {@link Cliente cliente} espero el {@link Pedido pedido}
   *
   * @throws IllegalStateException Si el {@link Pedido pedido} aun no fue terminado
   */
  public Duration getTiempoTotalEspera();

  /**
   * {@link Estado} actual del {@link Pedido pedido}
   */
  public Pedido.Estado getEstado();

  /**
   * Los distintos {@link Pedido.Item items} que componen un {@link Pedido pedido}
   */
  public static interface Item {

    /**
     * {@link Pedido} al que pertenece este {@link Pedido.Item item}
     */
    public Pedido getPedido();

    /**
     * Tipo de {@link Pizza pizza} de este {@link Pedido.Item item}
     */
    public Pizza getPizza();

    /**
     * Nombre de la {@link Pizza pizza} de este {@link Pedido.Item item}
     */
    public String getNombrePizza();

    /**
     * Cantidad de porciones de cada {@link Pizza pizza} de este {@link Pedido.Item item}
     */
    public String getTamaño();

    /**
     *
     * Cantidad de {@link Pizza pizzas} que componen este {@link Pedido.Item item}
     */
    public int getCantidad();
  }

  /**
   * Los posibles estados de los {@link Pedido pedidos}
   */
  public static enum Estado {
    // FIXME: faltan estados
  }
}
