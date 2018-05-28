package utn111.pizzeria.db;

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

  public static SelectBuilder select(String from) {
    return new SelectBuilder(from);
  }

  public static DeleteBuilder delete(String from) {
    return new DeleteBuilder(from);
  }

  public static InsertBuilder insert(String into) {
    return new InsertBuilder(into);
  }
}
