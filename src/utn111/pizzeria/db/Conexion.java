package utn111.pizzeria.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

  private final Connection cnn;

  private Conexion(Connection cnn) {
    this.cnn = cnn;
  }

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

  public int execute(String sql) {
    return preparar(sql).execute();
  }

  /**
   * Crea una conexion sqlite en memoria
   *
   * Necesita el jar del conector de sqlite para funcionar correctamente
   *
   * @link https://bitbucket.org/xerial/sqlite-jdbc/downloads/
   */
  public static Conexion sqlite() {
    return new Conexion(withSqlite());
  }

  static Connection withSqlite() {
    try {
      return DriverManager.getConnection("jdbc:sqlite::memory:");
    }
    catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

}