package utn111.pizzeria.db;

import java.util.ArrayList;
import java.util.List;

public class SelectBuilder {

  private final String tabla;
  private final List<Object> column = new ArrayList<>();
  private final List<Object> params = new ArrayList<>();
  private final List<String> condicionesWhere = new ArrayList<>();
  private final List<Object> orden = new ArrayList<>();
  private final List<Object> groups = new ArrayList<>();
  private String valorLimit= "";

  public SelectBuilder(String from, Object... columnas) {
    tabla = from;
    for (Object col : columnas) {
      column.add(col);
    }
  }

  public SelectBuilder where(String condicion, Object... valores) {
    condicionesWhere.add(condicion);
    for (Object valor : valores) {
      params.add(valor);
    }
    return this;
  }

  public SelectBuilder orderBy(Object... valoresOrden) {
    for (Object valor : valoresOrden) {
      orden.add(valor);
    }
    return this;
  }

  public SelectBuilder groupBy(Object... valoresGrupo) {
    for (Object valor : valoresGrupo) {
      groups.add(valor);
    }
    return this;
  }

  public SelectBuilder limit(String valorLimit) {
    this.valorLimit = valorLimit;
    return this;
  }

  public Query build() {
    String sql = String.format("select %s from %s%s%s%s%s", buildColumnas(), tabla,
        buildWhere(), buildGroupBy(), buildLimit(), buildOrderBy());
    return new Query(sql, params.toArray());
  }

  private String buildColumnas() {
    String sql = "*";
    boolean primero = true;
    for (Object col : column) {
      if (primero) {
        primero = false;
        sql = "";
      } else {
        sql = sql + ", ";
      }
      sql = sql + String.format("%s", col);
    }
    return sql;
  }
  
  private String buildWhere() {
    String sql = "";
    String andWhere = "where";
    for (String cond : condicionesWhere) {
      sql = sql+ String.format(" %s (%s)", andWhere, cond);
      andWhere = "and";
    }
    return sql;
  }

  private String buildOrderBy() {
    String sql = "";
    boolean primero = true;
    for (Object ord : orden) {
      if (primero) {
        sql = " order by";
        primero = false;
      } else {
        sql = sql + ",";
      }
      sql = sql + String.format(" %s", ord);
    }
    return sql;
  }

  private String buildGroupBy() {
    String sql = "";
    boolean primero = true;
    for (Object grup : groups) {
      if (primero) {
        sql = " group by";
        primero = false;
      } else {
        sql = sql + ",";
      }
      sql = sql + String.format(" %s", grup);
    }
    return sql;
  }

  private String buildLimit() {
    String sql = "";
    if (valorLimit == "") return sql; 
    sql = " limit " + valorLimit;
    return sql; 
  }
}
