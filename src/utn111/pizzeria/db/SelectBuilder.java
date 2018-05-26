package utn111.pizzeria.db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectBuilder extends QueryBuilder {

  private final List<String> condicionesWhere = new ArrayList<>();
  private final List<Object> orden = new ArrayList<>();
  private final List<Object> groups = new ArrayList<>();
  private int limit;
  private int offset;

  public SelectBuilder(String from) {
    super(from);
  }

  public SelectBuilder columnas(Object... columnas) {
    Collections.addAll(columns,  columnas);
    return this;
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

  public SelectBuilder limit(int limit, int offset) {
    this.limit = limit;
    this.offset = offset;
    return this;
  }

  public SelectBuilder limit(int limit) {
    this.limit = limit;
    return this;
  }

  @Override
  protected String buildSql() {
    final StringBuilder sb = new StringBuilder();
    sb.append(buildQueryType());
    sb.append(buildColumnas());
    sb.append(buildFrom());
    sb.append(buildWhere());
    sb.append(buildGroup());
    sb.append(buildOrden());
    sb.append(buildLimit());
    return sb.toString();
  }

  @Override
  protected String buildQueryType () {
    return "select ";
  }

  private String buildGroup() {
    return buildLista(groups, " group by ", "");
  }

  private String buildOrden() {
    return buildLista(orden, " order by ", "");
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

  private String buildLimit() {
    final String template;
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
