package utn111.pizzeria.db;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.Test;
import utn111.pizzeria.db.Conexion;

public class ConexionTest {
  
  /**
   * Pruebo una conexion con una BD en memoria.
   */
  @Test public void testUnaConexion() {
    Connection cnn = Conexion.withSqlite();
    assertNotNull(cnn);
  }
}