package utn111.pizzeria.db;

public class DeleteBuilder extends QueryBuilder {

  DeleteBuilder(String from) {
    super(from);
  }

  public DeleteBuilder where(String condicion, Object... valores) {
    addWhere(condicion, valores);
    return this;
  }

  public DeleteBuilder orderBy(String... columnas) {
    addOrderBy(columnas);
    return this;
  }

  public DeleteBuilder limit(int limit, int offset) {
    this.limit = limit;
    this.offset = offset;
    return this;
  }

  public DeleteBuilder limit(int limit) {
    this.limit = limit;
    return this;
  }

  public DeleteBuilder offset(int offset) {
    this.offset = offset;
    return this;
  }

  @Override
  protected String buildSql() {
    final StringBuilder sb = new StringBuilder();
    sb.append("delete ");
    sb.append(buildFrom());
    sb.append(buildWhere());
    sb.append(buildOrderBy());
    sb.append(buildLimit());
    return sb.toString();
  }

}
