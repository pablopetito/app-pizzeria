package utn111.pizzeria.db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class QueryBuilder {

  protected final String table;
  protected final List<Object> params = new ArrayList<>();
  protected final List<Object> columns = new ArrayList<>();
  protected final List<String> where = new ArrayList<>();

  public QueryBuilder(final String table) {
    this.table = table;
  }

  protected void addWhere(String filter, Object... params) {
    where.add(filter);
    Collections.addAll(this.params, params);
  }

  public Query build() {
    final String sql = buildSql();
    return new Query(sql, params.toArray());
  }

  protected abstract String buildSql();

  protected String buildQueryType() {
    throw new UnsupportedOperationException();
  }

  protected String buildFrom () {
    return String.format(" from %s", table);
  }

  protected String buildColumnas() {
    return buildLista(columns, "", "*");
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

  protected String buildLista(final List<Object> values,
                              final String init,
                              final String whenEmpty) {
    StringBuilder sql = null;

    for (Object item : values) {
      if (sql == null) {
        sql = new StringBuilder(init);
      } else {
        sql.append(", ");
      }
      sql.append(item);
    }

    return sql == null ? whenEmpty : sql.toString()
    ;
  }

}
