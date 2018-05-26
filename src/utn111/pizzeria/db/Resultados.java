package utn111.pizzeria.db;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;

public class Resultados {
  
  private final ResultSet rs;
  private final ResultSetMetaData data;
  
  public Resultados(ResultSet rs) {
    this.rs = rs;
    try {
      data = rs.getMetaData();
        rs.next();
    }
    catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
  
  /**
   * @return retorna `true` si quedan mas registros por leer
   */
  public boolean hashNext(){
    try {
        return !rs.isAfterLast();
    }
    catch (SQLException e) {
      return false;
    }
  }
  
  /**
   * Mueve el cursor al proximo registro
   *
   * @return retorna `true` si se encuentra en un registro valido
   */
  public boolean next() {
    try {
      return rs.next();
    }
    catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  // Metodos de Lectura de Datos
  
  public boolean getBoolean(String column) {
    try {
      return rs.getBoolean(column);
    }
    catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
  
  public boolean getBoolean(int index) {
    try {
      validarColumna(index, Types.BIT, Types.SMALLINT, Types.INTEGER, Types.BIGINT, Types.BOOLEAN);
      String nomb = data.getColumnName(index);
      return rs.getBoolean(nomb);
    }
    catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
  
  public int getInteger(String column) {
    try {
      return rs.getInt(column);
    }
    catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
  
  public int getInteger(int index) {
    try {
      validarColumna(index, Types.INTEGER, Types.SMALLINT);
      String nomb = data.getColumnName(index);
      return rs.getInt(nomb);
    }
    catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public float getFloat(String column) {
    try {
      return rs.getFloat(column);
    }
    catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
  
  public float getFloat(int index) {
    try {
      validarColumna(index, Types.FLOAT);
      String nomb = data.getColumnName(index);
      return rs.getFloat(nomb);
    }
    catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
  
  public String getString(String column) {
    try {
      return rs.getString(column);
    }
    catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
  
  public String getString(int index) {
    try {
      validarColumna(index, Types.VARCHAR);
      String nomb = data.getColumnName(index);
      return rs.getString(nomb);
    }
    catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
  
  private void validarColumna(int index, int... types) throws SQLException {
    for(int type : types) {
      if (data.getColumnType(index) == type) {
        return;
      }
    }
    throw new IllegalArgumentException();
  }
}