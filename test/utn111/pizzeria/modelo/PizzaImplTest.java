package utn111.pizzeria.modelo;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PizzaImplTest {
  @Test
  public void testClienteImplAlmacenaNombreCorrectamente() {
    PizzaImpl pizzaImpl = new PizzaImpl(createDao());
    assertEquals("muzzarella",pizzaImpl.getNombre());
  }

  private PizzaDao createDao() {
    PizzaDao pizzaDao = new PizzaDao();
    pizzaDao.setNombre("muzzarella");
    return pizzaDao;
  }
}