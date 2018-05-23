package bd;

public class Query {

  private final String sql;
  private final Object[] params;

  Query(String sql, Object[] params) {
    this.sql = sql;
    this.params = params;
  }

  public String getSql() {
    return sql;
  }

  public Object[] getParams() {
    return params;
  }

  public static SelectBuilder select(String from, Object... columnas ) {
    return new SelectBuilder(from, columnas);
  }
}
