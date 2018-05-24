package utn111.pizzeria.modelo;

public class PizzaImpl implements Pizza {
  private final PizzaDao pizzaDao;

  public PizzaImpl(PizzaDao pizzaDao) {
    this.pizzaDao = pizzaDao;
  }

  @Override
  public String getNombre() {
    return pizzaDao.getNombre();
  }
}
