package test;

import org.junit.Test;
import utn111.pizzeria.db.Conexion;

public class ConexionTest {
  
  /**
   * Pruebo una conexion con una BD en memoria.
   */
  @Test public void testUnaConexion() {
    final String host = "jdbc:sqlite::memory:";
    Conexion c = new Conexion(host);
    c.preparar("CREATE TABLE Tipos(texto varchar(40), numero int, flotante float)");
  }
}