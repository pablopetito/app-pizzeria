package utn111.pizzeria.db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class QueryBuilder {

  protected final String table;
  protected final List<Object> params = new ArrayList<>();
  protected final List<Object> columns = new ArrayList<>();
  protected final List<String> where = new ArrayList<>();
  protected final List<Object> orderBy = new ArrayList<>();
  protected int limit;
  protected int offset;

  public QueryBuilder(final String table) {
    this.table = table;
  }

  public void addColumns(String... columnas) {
    Collections.addAll(columns,  columnas);
  }

  protected void addWhere(String filter, Object... params) {
    where.add(filter);
    addParams(params);
  }

  protected void addParams(Object... params) {
    Collections.addAll(this.params, params);
  }

  protected void addOrderBy(String... columnas) {
    Collections.addAll(orderBy, columnas);
  }

  public Query build() {
    final String sql = buildSql();
    return new Query(sql, params.toArray());
  }

  protected abstract String buildSql();

  protected String buildFrom () {
    return String.format("from %s", table);
  }

  protected String buildColumnas() {
    return buildColumnas(null);
  }

  protected String buildColumnas(String itemTemplate) {
    return buildLista(columns, "", "*", itemTemplate);
  }

  protected String buildWhere() {
    final StringBuilder sql = new StringBuilder();
    String andWhere = "where";

    for (String cond : where) {
      sql.append(
        String.format(" %s (%s)", andWhere, cond)
      );
      andWhere = "and";
    }

    return sql.toString();
  }

  protected String buildOrderBy() {
    return buildLista(orderBy, " order by ", "");
  }

  protected String buildLimit() {

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

  protected String buildLista(final List<Object> values,
      final String init,
      final String whenEmpty) {
    return buildLista(values, init, whenEmpty, null);
  }

  protected String buildLista(final List<Object> values,
                              final String init,
                              final String whenEmpty,
                              final String itemTemplate) {
    StringBuilder sql = null;

    for (Object item : values) {
      if (sql == null) {
        sql = new StringBuilder(init);
      } else {
        sql.append(", ");
      }

      if (itemTemplate != null) {
        item = String.format(itemTemplate, item);
      }

      sql.append(item);
    }

    return sql == null ? whenEmpty : sql.toString()
    ;
  }

}
