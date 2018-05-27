package utn111.pizzeria.db;

import static org.junit.Assert.assertEquals;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;
import utn111.pizzeria.db.Consulta;

public class ConsultaTest {
  // Pruebo consultas con sentencias sql correctas
  @Test public void testConsultaInsert() {
    Consulta c = consulta("INSERT INTO Tipos VALUES ('d', 4, 44), ('e', 5, 55)");
    assertEquals(2, c.execute());
  }

  private Consulta consulta(String sql) {
    return new Consulta(connection(), sql);
  }
  
  @Test public void testConsultaDelete() {
    Consulta c = consulta("DELETE FROM Tipos WHERE numero=1");
    assertEquals(1, c.execute());
  }
  
  @Test public void testConsultaUpdate() {
    Consulta c = consulta("UPDATE Tipos SET texto = 'a' WHERE numero=2");
    assertEquals(1, c.execute());
  }
  
  @Test public void testConsultaSelect() {
    Consulta c = consulta("SELECT * FROM Tipos");
    c.select();
  }
  
  // Pruebo consultas con excepciones
  @Test (expected = RuntimeException.class)
  public void testExecute() {
    Consulta c = consulta("SELECT * FROM Tipos");
    c.execute();
  }
  
  @Test (expected = RuntimeException.class)
  public void testSelect() {
    Consulta c = consulta("UPDATE Tipos SET texto = 'a' WHERE numero = 2");
    c.select();
  }
  
  @Test (expected = RuntimeException.class)
  public void testParam() {
    Consulta c = consulta("UPDATE Tipos SET texto = a WHERE numero = ?");
    c.param(1, 2);
    c.execute();
  }
  
  // Pruebo consultas con parametros usando posicion
  @Test public void testConsultaParam() {
    Consulta c = consulta("DELETE FROM Tipos WHERE texto = ?");
    c.param(1, "o");
    assertEquals(0, c.execute());
  }
  
  @Test public void testConsultaParamExcepcion() {
    Consulta c = consulta("DELETE FROM Tipos WHERE texto = ?");
    c.param(1, "a");
    assertEquals(1, c.execute());
  }
  
  @Test public void testConsultaParamExcepcion3() {
    Consulta c = consulta("DELETE FROM Tipos WHERE texto = ?");
    c.param(1, "o");
    assertEquals(0, c.execute());
  }
  
  @Test public void testConsultaVariosParam() {
    Consulta c = consulta("DELETE FROM Tipos WHERE texto = ? OR numero = ?");
    c.param(1, "c");
    c.param(2, 2);
    assertEquals(2, c.execute());
  }
  
  @Test public void testConsultaParamExcepcion1() {
    Consulta c = consulta("DELETE FROM Tipos WHERE texto = ?");
    c.param("a");
    assertEquals(1, c.execute());
  }
  
  @Test public void testConsultaParamExcepcion2() {
    Consulta c = consulta("DELETE FROM Tipos WHERE texto = ?");
    c.param("o");
    assertEquals(0, c.execute());
  }
  
  @Test public void testConsultaVariosParam2() {
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
  public Connection connection() {
    Connection cnn = Conexion.withSqlite();
    try {
      cnn.prepareStatement("CREATE TABLE Tipos(texto varchar(40), numero int, flotante float);").execute();
      cnn.prepareStatement("INSERT INTO Tipos VALUES ('a', 1, 11), ('b', 2, 22), ('c', 3, 33)").execute();
    }
    catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return cnn;
  }
}