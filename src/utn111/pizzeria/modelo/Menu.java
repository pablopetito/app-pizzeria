package utn111.pizzeria.modelo;

import java.time.Duration;

/**
 * Representa una entrada en la lista del menu de la pizzeria.
 *
 * Los {@link Cliente clientes} solo podran comprar
 * {@link Pizza pizzas} solo si estas poseen menues asociados.
 */
public interface Menu {

  /**
   * La {@link Pizza pizza} asociada a este {@link Menu menu}
   */
  public Pizza getPizza();

  /**
   * Nombre de la {@link Pizza pizza} en el {@link Menu menu}
   */
  public String getNombrePizza();

  /**
   * Cantidad de porciones que posee la {@link Pizza pizza} de este {@link Menu menu}
   */
  public int getTamaño();

  /**
   * Valor de este {@link Menu menu}
   */
  public float getPrecio();

  /**
   * Tiempo individual de preparacion de cada {@link Pizza pizza} de este {@link Menu menu}
   */
  public Duration getTiempoPreparacion();
}
