package utn111.pizzeria;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

import org.junit.Test;
import utn111.pizzeria.Config;

public class ConfigTest {

  @Test(expected = FileNotFoundException.class) 
  public void testArchNoExiste() throws FileNotFoundException {
    new Config("EsteArchivoNoExiste.properties");
}
  @Test(expected=NoSuchElementException.class)
  public void testClaveNoExiste() {
    getString("clave-no-existente");
  }

  @Test
  public void testStringConValor() {
    String esperado = "esteEsElValor";
    String resultado = getString("un-string-con-valor");
    assertEquals(esperado, resultado);
  }

  @Test
  public void testStringVacio() {
    String esperado = "";
    String resultado = getString("un-string-vacio");
    assertEquals(esperado, resultado);
  }

  @Test 
  public void testStringConNumero() {
    String esperado ="123";
    String resultado = getString("un-string-con-numero");
    assertEquals(esperado, resultado);
  }

  @Test 
  public void testIntConValor() {
    int esperado = 456;
    int resultado = getInt("un-int-con-valor");
    assertEquals(esperado, resultado);
  }

  @Test(expected=NumberFormatException.class)
  public void testIntConFloat() {
    getInt("un-int-con-float");
  }

  @Test(expected=NumberFormatException.class)
  public void testIntConString() {
    getInt("un-int-con-string");
  }

  private static Config crearConfig() {
    try {
      return new Config("test/utn111/pizzeria/TestConfig.properties");
    }
    catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  private static int getInt(String key) {
    return crearConfig().getInt(key);
  }

  private static String getString(String key) {
    return crearConfig().getString(key);
  }
}
