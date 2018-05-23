package utn111.pizzeria.modelo;

import org.junit.Test;

import java.time.Duration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class MenuImplTest {
  @Test
  public void menuImplPuedeAlmacenarPizzaCorrectamente() {
    MenuDao menuDao = new MenuDao();
    PizzaDao pizzaDao = new PizzaDao();
    PizzaImpl pizzaImple = new PizzaImpl(pizzaDao);
    MenuImpl menu = new MenuImpl(menuDao,pizzaImple);
    assertNotNull(menu.getPizza());
  }

  @Test
  public void menuImplDevuelveNombrePizzaConValCorrecto() {
    MenuDao menuDao = new MenuDao();
    PizzaDao pizzaDao = new PizzaDao();
    pizzaDao.setNombre("muzzarella");
    PizzaImpl pizzaImple = new PizzaImpl(pizzaDao);
    MenuImpl menu = new MenuImpl(menuDao,pizzaImple);
    assertEquals("muzzarella",menu.getNombrePizza());
  }

  @Test
  public void menuImplDevuelveTamañoPizzaConValCorrecto() {
    MenuDao menuDao = new MenuDao();
    menuDao.setTamaño(12);
    PizzaDao pizzaDao = new PizzaDao();
    PizzaImpl pizzaImple = new PizzaImpl(pizzaDao);
    MenuImpl menu = new MenuImpl(menuDao,pizzaImple);
    assertEquals(12,menu.getTamaño());
  }

  @Test
  public void menuImplDevuelveTiempoEsperaConValCorrecto() {
    MenuDao menuDao = new MenuDao();
    menuDao.setTiempoPreparacion(Duration.ofMinutes(100));
    PizzaDao pizzaDao = new PizzaDao();
    PizzaImpl pizzaImple = new PizzaImpl(pizzaDao);
    MenuImpl menu = new MenuImpl(menuDao,pizzaImple);
    assertEquals(Duration.ofMinutes(100),menu.getTiempoPreparacion());
  }

  @Test
  public void menuImplDevuelvePrecioConValCorrecto() {
    MenuDao menuDao = new MenuDao();
    menuDao.setPrecio(200);
    PizzaDao pizzaDao = new PizzaDao();
    PizzaImpl pizzaImple = new PizzaImpl(pizzaDao);
    MenuImpl menu = new MenuImpl(menuDao,pizzaImple);
    assertEquals(200.0,menu.getPrecio());
  }
}
