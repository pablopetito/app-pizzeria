package utn111.pizzeria.modelo;

import java.time.Duration;

public class MenuImpl implements Menu {
  private MenuDao menuDao;
  private PizzaImpl pizza;

  public MenuImpl(MenuDao menuDao,PizzaImpl pizza) {
    this.menuDao = menuDao;
    this.pizza = pizza;
  }

  @Override
  public Pizza getPizza() {
    return pizza;
  }

  @Override
  public String getNombrePizza() {
    return pizza.getNombre();
  }

  @Override
  public int getTamaño() {
    return menuDao.getTamaño();
  }

  @Override
  public float getPrecio() {
    return menuDao.getPrecio();
  }

  @Override
  public Duration getTiempoPreparacion() {
    return menuDao.getTiempoPreparacion();
  }
}
