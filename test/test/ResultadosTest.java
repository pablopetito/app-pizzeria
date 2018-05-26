package test;

import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.DriverManager;
import org.junit.Test;
import utn111.pizzeria.db.Resultados;

public class ResultadosTest {

  private static final float e = (float) 1e-10;

  @Test public void testHashNext() throws Exception {
    assertEquals(true, resultados().hashNext());
  }
  
  @Test public void testNext() throws Exception {
    assertEquals(false, resultados().next());
  }
  
  @Test public void testHashNextFalse() throws Exception {
    Resultados r = resultados();
    r.next();
    r.next();
    assertEquals(false, r.hashNext());
  }
  
  @Test public void testNextFalse() throws Exception {
    Resultados r = resultados();
    r.next();
    assertEquals(false, r.next());
  }
  
  // Pruebo Metodos de Lectura de Datos Correctos
  @Test public void testGetBooleanNombreTabla() throws Exception {
    assertEquals(true, resultados().getBoolean("booleano"));
  }
  
  @Test public void testGetBooleanNumTabla() throws Exception {
    assertEquals(true, resultados().getBoolean(4));
  }
  
  @Test public void testGetIntNombreTabla() throws Exception {
    assertEquals(1, resultados().getInteger("numero"));
  }
  
  @Test public void testGetIntNumTabla() throws Exception {
    assertEquals(1, resultados().getInteger(2));
  }
  
  @Test public void testGetFloatNombreTabla() throws Exception {
    assertEquals(11, resultados().getFloat("flotante"), e);
  }
  
  @Test public void testGetFloatNumTabla() throws Exception {
    assertEquals(11, resultados().getFloat(3), e);
  }
  
  @Test public void testGetStringNombreTabla() throws Exception {
    Resultados r = resultados();
    assertEquals("a", r.getString("texto"));
  }
  
  @Test public void testGetStringNumTabla() throws Exception {
    assertEquals("a", resultados().getString(1));
  }
  
  // Pruebo Metodos de Lectura de Datos Con Errores
  @Test
  public void testGetBooleanError() throws Exception {
    Boolean resultado = resultados().getBoolean("texto");
    assertEquals(false, resultado);
  }
  
  @Test (expected = RuntimeException.class)
  public void testGetBooleanExcepcion() throws Exception {
    resultados().getBoolean("boolea");
  }
  
  @Test (expected = RuntimeException.class)
  public void testGetStringError() throws Exception {
    resultados().getString(2);
  }
  
  @Test (expected = RuntimeException.class)
  public void testGetStringErrorColumna() throws Exception {
    resultados().getString(100);
  }
  
  @Test (expected = RuntimeException.class)
  public void testGetStringExcepcion() throws Exception {
    resultados().getString("cosa");
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testGetIntegerError() throws Exception{
    resultados().getInteger(1);
  }
  
  @Test (expected = RuntimeException.class)
  public void testGetIntegerErrorColumna() throws Exception{
    resultados().getInteger(100);
  }
  
  @Test (expected = RuntimeException.class)
  public void testGetIntegerExcepcion() throws Exception {
    resultados().getInteger("num");
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testGetFloatError() throws Exception{
    resultados().getFloat(1);
  }
  
  @Test (expected = RuntimeException.class)
  public void testGetFloatErrorColumna() throws Exception{
    resultados().getFloat(100);
  }
  
  @Test (expected = RuntimeException.class)
  public void testGetFloatExcepcion() throws Exception {
    resultados().getFloat("flot");
  }
  /**
   * Creo una BD en memoria
   *
   * @return Resultado de una query
   */
  public Resultados resultados() throws Exception {
    final String host = "jdbc:sqlite::memory:";
    Connection cnn = DriverManager.getConnection(host);
    cnn.prepareStatement("CREATE TABLE Tipos(texto varchar(40), numero int, flotante float, booleano bit);").execute();
    cnn.prepareStatement("INSERT INTO Tipos VALUES ('a', 1, 11, 1)").execute();
    return new Resultados(cnn.prepareStatement("SELECT * FROM Tipos").executeQuery());
  }
}