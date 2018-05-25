package utn111.pizzeria.modelo;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PizzaImplTest {

  @Test
  public void testClienteImplAlmacenaNombreCorrectamente() {
    final String nombre = createPizza().getNombre();
    assertEquals("muzzarella", nombre);
  }

  private PizzaImpl createPizza() {
    PizzaDao pizzaDao = new PizzaDao();
    pizzaDao.setNombre("muzzarella");
    return new PizzaImpl(pizzaDao);
  }
}