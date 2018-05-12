package utn111.pizzeria.test;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

import org.junit.Test;
import utn111.pizzeria.Config;

public class TestConfig {

//Archivo No Existe
  @Test(expected = FileNotFoundException.class) 
  public void testArchNoExiste()
    throws Exception {
  new Config("saraza");
}
  //clave no existe
  @Test(expected=NoSuchElementException.class)
  public void testClaveNoExiste() {
    getString("string-con-valor");
  }

//un-string-con-valor=String
  @Test
    public void testStringConValor() {
    String esperado = "esteEsElValor";
    String resultado = getString("un-string-con-valor");
    assertEquals(esperado, resultado);
  }

//un-string-con-Vacio
  @Test
    public void testStringVacio() {
    String esperado = "";
    String resultado = getString("un-string-vacio");
    assertEquals(esperado, resultado);
  }

//un-string-con-Numero
  @Test 
    public void testStringConNumero() {
    String esperado ="123";
    String resultado = getString("un-string-con-numero");
    assertEquals(esperado, resultado);
  }

//un-int-con-valor
  @Test 
    public void testIntConValor() {
    int esperado = 456;
    int resultado = getInt("un-int-con-valor");
    assertEquals(esperado, resultado);
  }

//un-int-con-float
  @Test(expected=NumberFormatException.class)
    public void testIntConFloat() {
    getInt("un-int-con-float");
  }

//un-int-con-string
  @Test(expected=NumberFormatException.class)
    public void testIntConString() {
    getInt("un-int-con-string");
  }

  private static Config crearConfig() {
    try {
      return new Config("Pizzeria_ejemplo.properties");
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
