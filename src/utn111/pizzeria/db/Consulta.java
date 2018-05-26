package utn111.pizzeria.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consulta {
  
  private final PreparedStatement ps;
  private int p = 1;
  
  public Consulta(Connection cnn, String sql) {
    try {
      ps = cnn.prepareStatement(sql);
    }
    catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
  
  // Agregando parametros uno atras del otro
  public Consulta param(String valor) {
    try {
      ps.setString(p, valor);
    }
    catch (SQLException e) {
      throw new RuntimeException(e);
    }
    p += 1;
    return this;
  }
  
  public Consulta param(int valor) {
    try {
      ps.setInt(p, valor);
    }
    catch (SQLException e) {
      throw new RuntimeException(e);
    }
    p += 1;
    return this;
  }
  
  public Consulta param(float valor) {
    try {
      ps.setFloat(p, valor);
    }
    catch (SQLException e) {
      throw new RuntimeException(e);
    }
    p += 1;
    return this;
  }
  
  // Agregando parametros usando posicion
  public Consulta param(int index, String valor) {
    try {
      ps.setString(index, valor);
    }
    catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return this;
  }
  
  public Consulta param(int index, int valor) {
    try {
      ps.setInt(index, valor);
    }
    catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return this;
  }
  
  public Consulta param(int index, float valor) {
    try {
      ps.setFloat(index, valor);
    }
    catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return this;
  }
  
  /**
   * Ejecutar una consulta que modifica la base de datos
   *
   * @return Cantidad de registros afectados
   */
  public int execute(){
    try {
      return ps.executeUpdate();
    }
    catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
  
  /**
   * Ejecutar una consulta que lee resultados
   *
   * @return {@link Resultados} Datos obtenidos por la consulta
   */
  public Resultados select(){
    final ResultSet rs;
    try {
      rs = ps.executeQuery();
    }
    catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return new Resultados(rs);
  }
}