package utn111.pizzeria.db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectBuilder {

  private final String tabla;
  private final List<Object> column = new ArrayList<>();
  private final List<Object> params = new ArrayList<>();
  private final List<String> condicionesWhere = new ArrayList<>();
  private final List<Object> orden = new ArrayList<>();
  private final List<Object> groups = new ArrayList<>();
  private int valorLimit1;
  private int valorLimit2;

  public SelectBuilder(String from, Object... columnas) {
    tabla = from;
    Collections.addAll(column, columnas);
    }

  public SelectBuilder where(String condicion, Object... valores) {
    condicionesWhere.add(condicion);
    Collections.addAll(params, valores);
    return this;
  }

  public SelectBuilder orderBy(Object... valoresOrden) {
    Collections.addAll(orden, valoresOrden);
    return this;
  }

  public SelectBuilder groupBy(Object... valoresGrupo) {
    Collections.addAll(groups, valoresGrupo);
    return this;
  }

  public SelectBuilder limit(int valor1, int valor2 ) {
    this.valorLimit1 = valor1;
    this.valorLimit2 = valor2;
    return this;
  }

  public Query build() {
    String sql = String.format("select %s from %s%s%s%s%s", buildColumnas(), tabla,
        buildWhere(), buildGroup(), buildLimit(), buildOrden());
    return new Query(sql, params.toArray());
  }

  private String buildGroup() {
    return buildGroupOrdenBy(" group by", groups, "", " %s", " ,");
  }

  private String buildOrden() {
    return buildGroupOrdenBy(" order by", orden, "", " %s", ",");
  }

  private String buildColumnas() {
    return buildGroupOrdenBy("", column, "*", "%s", ", ");
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

  private String buildGroupOrdenBy(String opcion, List<Object> valores, String sqlInicial, String tplItems, String coma) {
    String sql = sqlInicial;
    boolean primero = true;
    for (Object valor : valores) {
      if (primero) {
        sql = opcion;
        primero = false;
      } else {
        sql = sql + coma;
      }
      sql = sql + String.format(tplItems, valor);
    }
    return sql;
  }

  private String buildLimit() {
    String sql = "";
    if (valorLimit1 == 0) return sql;
    sql = String.format(" limit %s", valorLimit1);
    if (valorLimit2 == 0) return sql;
    sql = sql + String.format(", %s", valorLimit2);
    return sql; 
  }
}
