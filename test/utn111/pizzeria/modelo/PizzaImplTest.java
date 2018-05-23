package utn111.pizzeria.modelo;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PizzaImplTest {
  @Test
  public void clienteImplAlmacenaNombreCorrectamente() {
    PizzaDao pizzaDao = new PizzaDao();
    pizzaDao.setNombre("muzzarella");
    PizzaImpl pizzaImpl = new PizzaImpl(pizzaDao);
    assertEquals("muzzarella",pizzaImpl.getNombre());
  }
}