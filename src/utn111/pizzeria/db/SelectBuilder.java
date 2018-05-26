package utn111.pizzeria.db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectBuilder extends QueryBuilder {

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
    addWhere(condicion, valores);
    return this;
  }

  public SelectBuilder orderBy(String... columnas) {
    addOrderBy(columnas);
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
    sb.append(buildSelect());
    sb.append(buildFrom());
    sb.append(buildWhere());
    sb.append(buildGroup());
    sb.append(buildOrderBy());
    sb.append(buildLimit());
    return sb.toString();
  }

  private String buildSelect() {
    return String.format("select %s ", buildColumnas());
  }

  private String buildGroup() {
    return buildLista(groups, " group by ", "");
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
