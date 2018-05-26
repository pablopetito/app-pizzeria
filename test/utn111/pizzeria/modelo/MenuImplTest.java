package utn111.pizzeria.modelo;

import org.junit.Test;

import java.time.Duration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class MenuImplTest {
  @Test
  public void menuImplPuedeAlmacenarPizzaCorrectamente() {
    MenuImpl menu = new MenuImpl(createMenuDao(),createPizzaImpl());
    assertNotNull(menu.getPizza());
  }

  @Test
  public void menuImplDevuelveNombrePizzaConValCorrecto() {
    MenuImpl menu = new MenuImpl(createMenuDao(),createPizzaImpl());
    assertEquals("muzzarella",menu.getNombrePizza());
  }

  @Test
  public void menuImplDevuelveTamañoPizzaConValCorrecto() {
    MenuImpl menu = new MenuImpl(createMenuDao(),createPizzaImpl());
    assertEquals(12,menu.getTamaño());
  }

  @Test
  public void menuImplDevuelveTiempoEsperaConValCorrecto() {
    MenuImpl menu = new MenuImpl(createMenuDao(),createPizzaImpl());
    assertEquals(Duration.ofMinutes(100),menu.getTiempoPreparacion());
  }

  @Test
  public void menuImplDevuelvePrecioConValCorrecto() {
    MenuImpl menu = new MenuImpl(createMenuDao(),createPizzaImpl());
    final float expected = 200;
    assertEquals(expected,menu.getPrecio());
  }

  private MenuDao createMenuDao() {
    MenuDao menuDao = new MenuDao();
    menuDao.setPrecio(200);
    menuDao.setTiempoPreparacion(Duration.ofMinutes(100));
    menuDao.setTamaño(12);
    return menuDao;
  }

  private PizzaImpl createPizzaImpl() {
    PizzaDao pizzaDao = new PizzaDao();
    PizzaImpl pizzaImple = new PizzaImpl(pizzaDao);
    pizzaDao.setNombre("muzzarella");
    return pizzaImple;
  }
}
