package utn111.pizzeria.modelo;

import org.junit.Test;

import java.time.Duration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class MenuImplTest {
  @Test
  public void menuImplPuedeAlmacenarPizzaCorrectamente() {
    MenuImpl menu = createMenuImpl();
    assertNotNull(menu.getPizza());
  }

  @Test
  public void menuImplDevuelveNombrePizzaConValCorrecto() {
    MenuImpl menu = createMenuImpl();
    assertEquals("muzzarella", menu.getNombrePizza());
  }

  @Test
  public void menuImplDevuelveTamañoPizzaConValCorrecto() {
    MenuImpl menu = createMenuImpl();
    assertEquals(12, menu.getTamaño());
  }

  @Test
  public void menuImplDevuelveTiempoEsperaConValCorrecto() {
    MenuImpl menu = createMenuImpl();
    assertEquals(Duration.ofMinutes(100), menu.getTiempoPreparacion());
  }

  @Test
  public void menuImplDevuelvePrecioConValCorrecto() {
    MenuImpl menu = createMenuImpl();
    final float expected = 200;
    assertEquals(expected, menu.getPrecio());
  }

  private MenuImpl createMenuImpl(){
    return new MenuImpl(createMenuDao(), createPizzaImpl());
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
