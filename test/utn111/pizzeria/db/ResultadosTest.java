package utn111.pizzeria.db;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class ResultadosTest {

  private static final float e = (float) 1e-10;

  @Test public void testHashNext()  {
    assertEquals(true, resultados().hashNext());
  }
  
  @Test public void testNext() {
    assertEquals(false, resultados().next());
  }
  
  @Test public void testHashNextFalse() {
    Resultados r = resultados();
    r.next();
    r.next();
    assertEquals(false, r.hashNext());
  }
  
  @Test public void testNextFalse() {
    Resultados r = resultados();
    r.next();
    assertEquals(false, r.next());
  }
  
  // Pruebo Metodos de Lectura de Datos Correctos
  @Test public void testGetBooleanNombreTabla() {
    assertEquals(true, resultados().getBoolean("booleano"));
  }
  
  @Test public void testGetBooleanNumTabla() {
    assertEquals(true, resultados().getBoolean(4));
  }
  
  @Test public void testGetIntNombreTabla() {
    assertEquals(1, resultados().getInteger("numero"));
  }
  
  @Test public void testGetIntNumTabla() {
    assertEquals(1, resultados().getInteger(2));
  }
  
  @Test public void testGetFloatNombreTabla() {
    assertEquals(11, resultados().getFloat("flotante"), e);
  }
  
  @Test public void testGetFloatNumTabla() {
    assertEquals(11, resultados().getFloat(3), e);
  }
  
  @Test public void testGetStringNombreTabla() {
    Resultados r = resultados();
    assertEquals("a", r.getString("texto"));
  }
  
  @Test public void testGetStringNumTabla() {
    assertEquals("a", resultados().getString(1));
  }
  
  // Pruebo Metodos de Lectura de Datos Con Errores
  @Test
  public void testGetBooleanError() {
    Boolean resultado = resultados().getBoolean("texto");
    assertEquals(false, resultado);
  }
  
  @Test (expected = RuntimeException.class)
  public void testGetBooleanExcepcion() {
    resultados().getBoolean("boolea");
  }
  
  @Test (expected = RuntimeException.class)
  public void testGetStringError() {
    resultados().getString(2);
  }
  
  @Test (expected = RuntimeException.class)
  public void testGetStringErrorColumna() {
    resultados().getString(100);
  }
  
  @Test (expected = RuntimeException.class)
  public void testGetStringExcepcion() {
    resultados().getString("cosa");
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testGetIntegerError() {
    resultados().getInteger(1);
  }
  
  @Test (expected = RuntimeException.class)
  public void testGetIntegerErrorColumna() {
    resultados().getInteger(100);
  }
  
  @Test (expected = RuntimeException.class)
  public void testGetIntegerExcepcion() {
    resultados().getInteger("num");
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testGetFloatError() {
    resultados().getFloat(1);
  }
  
  @Test (expected = RuntimeException.class)
  public void testGetFloatErrorColumna() {
    resultados().getFloat(100);
  }
  
  @Test (expected = RuntimeException.class)
  public void testGetFloatExcepcion() {
    resultados().getFloat("flot");
  }

  /**
   * @return Resultados de una query
   */
  public Resultados resultados() {
    Connection cnn = Conexion.withSqlite();
    try {
      cnn.prepareStatement("CREATE TABLE Tipos(texto varchar(40), numero int, flotante float, booleano bit);").execute();
      cnn.prepareStatement("INSERT INTO Tipos VALUES ('a', 1, 11, 1)").execute();
      return new Resultados(cnn.prepareStatement("SELECT * FROM Tipos").executeQuery());
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}