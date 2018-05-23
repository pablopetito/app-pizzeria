package bd;

import java.util.ArrayList;
import java.util.List;

public class SelectBuilder {

  private final String tabla;
  private final List<Object> column = new ArrayList<>();
  private final List<Object> params = new ArrayList<>();
  private final List<String> condis = new ArrayList<>();
  private final List<Object> orden = new ArrayList<>();

  public SelectBuilder(String from, Object... columnas) {
    tabla = from;
    for (Object col : columnas) {
      column.add(col);
    }
  }

  public SelectBuilder where(String condicion, Object... valores) {
    condis.add(condicion);
    for (Object val : valores) {
      params.add(val);
    }
    return this;
  }

  public SelectBuilder orderBy(Object... valoresOrden) {
    for (Object val : valoresOrden) {
      orden.add(val);
    }
    return this;
  }

  public Query build() {
    String sqlWhere = "";
    String andWhere = "where";
    for (String cond : condis) {
      sqlWhere = sqlWhere + String.format(" %s (%s)", andWhere, cond);
      andWhere = "and";
    }
    String sql = String.format("select %s from %s%s", buildColumnas(), tabla,
        sqlWhere);
    sql = sql + buildOrderBy();
    return new Query(sql, params.toArray());
  }

  private String buildColumnas() {
    String sql = "*";
    boolean primero = true;
    for (Object col : column) {
      if (primero) {
        primero = false;
        sql = "";
      }
      else {
        sql = sql + ", ";
      }
      sql = sql + String.format("%s", col);
    }
    return sql;
  }

  private String buildOrderBy() {
    String sql = "";
    boolean primero = true;
    for (Object ord : orden) {
      if (hayAscDesc(ord)) {
        sql = sql + String.format(" %s", ord, ", ");
        continue;
      }
      else {
        sql = sql + ",";
      }
      if (primero) {
        sql = " order by";
        primero = false;
      }
      sql = sql + String.format(" %s", ord);
    }
    return sql;
  }

  private boolean hayAscDesc(Object ord) {
    return (ord.equals("asc") || ord.equals("ASC") || ord.equals("desc")
        || ord.equals("DESC"));
  }
}
// FALTAN limit, Having
// VER SELECT COUNT(*) from tabla
// VER as "ALIAS" tabla, columnas
