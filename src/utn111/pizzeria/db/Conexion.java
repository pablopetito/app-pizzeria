package utn111.pizzeria.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
  private final Connection cnn;
  
  public Conexion(String host, String user, String pass) {
    try {
      cnn = DriverManager.getConnection(host, user, pass);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
  
  public Consulta preparar(String sql) {
    return new Consulta(cnn, sql);
  }
}