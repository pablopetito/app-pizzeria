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
  private int limit;
  private int offset;

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

  public SelectBuilder limit(int limit, int offset ) {
    this.limit = limit;
    this.offset = offset;
    return this;
  }

  public Query build() {
    final String sql = buildSql();
    return new Query(sql, params.toArray());
  }

  private String buildSql() {
    final StringBuilder sb = new StringBuilder();
    sb.append(buildQuery());
    sb.append(buildColumnas());
    sb.append(buildFrom());
    sb.append(buildWhere());
    sb.append(buildGroup());
    sb.append(buildOrden());
    sb.append(buildLimit());
    return sb.toString();
  }

  private String buildQuery () {
    return "select ";
  }

  private StringBuilder buildFrom () {
    return new StringBuilder().append(" from ").append(tabla);
  }

  private String buildGroup() {
    return buildGroupOrdenBy(" group by ", groups, "");
  }

  private String buildOrden() {
    return buildGroupOrdenBy(" order by ", orden, "");
  }

  private String buildColumnas() {
    return buildGroupOrdenBy("", column, "*");
  }

  private String buildWhere() {
    String sql = "";
    String andWhere = "where";
    for (String cond : condicionesWhere) {
      sql = sql + (new StringBuilder().append(" ").append(andWhere).append(" (").append(cond).append(")"));
      andWhere = "and";
    }
    return sql;
  }

  private String buildGroupOrdenBy(String opcion, List<Object> valores, String sqlInicial) {
    String sql = sqlInicial;
    boolean primero = true;
    for (Object valor : valores) {
      if (primero) {
        sql = opcion;
        primero = false;
      } else {
        sql = sql + ", ";
      }
      sql = sql + (new StringBuilder().append(valor));
    }
    return sql;
  }

  private String buildLimit() {
    String template;
    if (limit <= 0) {
      template = "";
    } else if (offset <=0) {
      template = " limit %d";
      } else {
        template = " limit %d, %d";
        }
    return String.format(template, limit, offset);
  }
}
