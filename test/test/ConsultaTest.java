package test;

import static org.junit.Assert.assertEquals;
import java.sql.Connection;
import java.sql.DriverManager;
import org.junit.Test;
import utn111.pizzeria.db.Consulta;

public class ConsultaTest {
  // Pruebo consultas con sentencias sql correctas
  @Test public void testConsultaInsert() throws Exception {
    Consulta c = consulta("INSERT INTO Tipos VALUES ('d', 4, 44), ('e', 5, 55)");
    assertEquals(2, c.execute());
  }

  private Consulta consulta(String sql) throws Exception {
    return new Consulta(bd(), sql);
  }
  
  @Test public void testConsultaDelete() throws Exception {
    Consulta c = consulta("DELETE FROM Tipos WHERE numero=1");
    assertEquals(1, c.execute());
  }
  
  @Test public void testConsultaUpdate() throws Exception {
    Consulta c = consulta("UPDATE Tipos SET texto = 'a' WHERE numero=2");
    assertEquals(1, c.execute());
  }
  
  @Test public void testConsultaSelect() throws Exception {
    Consulta c = consulta("SELECT * FROM Tipos");
    c.select();
  }
  
  // Pruebo consultas con excepciones
  @Test (expected = RuntimeException.class)
  public void testExecute() throws Exception {
    Consulta c = consulta("SELECT * FROM Tipos");
    c.execute();
  }
  
  @Test (expected = RuntimeException.class)
  public void testSelect() throws Exception {
    Consulta c = consulta("UPDATE Tipos SET texto = 'a' WHERE numero = 2");
    c.select();
  }
  
  @Test (expected = RuntimeException.class)
  public void testParam() throws Exception {
    Consulta c = consulta("UPDATE Tipos SET texto = a WHERE numero = ?");
    c.param(1, 2);
    c.execute();
  }
  
  // Pruebo consultas con parametros usando posicion
  @Test public void testConsultaParam() throws Exception {
    Consulta c = consulta("DELETE FROM Tipos WHERE texto = ?");
    c.param(1, "o");
    assertEquals(0, c.execute());
  }
  
  @Test public void testConsultaParamExcepcion() throws Exception {
    Consulta c = consulta("DELETE FROM Tipos WHERE texto = ?");
    c.param(1, "a");
    assertEquals(1, c.execute());
  }
  
  @Test public void testConsultaParamExcepcion3() throws Exception {
    Consulta c = consulta("DELETE FROM Tipos WHERE texto = ?");
    c.param(1, "o");
    assertEquals(0, c.execute());
  }
  
  @Test public void testConsultaVariosParam() throws Exception {
    Consulta c = consulta("DELETE FROM Tipos WHERE texto = ? OR numero = ?");
    c.param(1, "c");
    c.param(2, 2);
    assertEquals(2, c.execute());
  }
  
  @Test public void testConsultaParamExcepcion1() throws Exception {
    Consulta c = consulta("DELETE FROM Tipos WHERE texto = ?");
    c.param("a");
    assertEquals(1, c.execute());
  }
  
  @Test public void testConsultaParamExcepcion2() throws Exception {
    Consulta c = consulta("DELETE FROM Tipos WHERE texto = ?");
    c.param("o");
    assertEquals(0, c.execute());
  }
  
  @Test public void testConsultaVariosParam2() throws Exception {
    Consulta c = consulta("DELETE FROM Tipos WHERE texto = ? OR numero = ?");
    c.param("c");
    c.param(2);
    assertEquals(2, c.execute());
  }
  
  /**
   * Creo una BD en memoria
   *
   * @return Conexion con la BD preparada.
   */
  public Connection bd() throws Exception {
    final String host = "jdbc:sqlite::memory:";
    Connection cnn = DriverManager.getConnection(host);
    cnn.prepareStatement("CREATE TABLE Tipos(texto varchar(40), numero int, flotante float);").execute();
    cnn.prepareStatement("INSERT INTO Tipos VALUES ('a', 1, 11), ('b', 2, 22), ('c', 3, 33)").execute();
    return cnn;
  }
}