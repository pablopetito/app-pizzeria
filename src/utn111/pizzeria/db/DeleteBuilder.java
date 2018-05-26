package utn111.pizzeria.db;

public class DeleteBuilder extends QueryBuilder {

  public DeleteBuilder(String from) {
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

  @Override
  protected String buildSql() {
    final StringBuilder sb = new StringBuilder();
    sb.append("delete ");
    sb.append(buildFrom());
    sb.append(buildWhere());
    sb.append(buildOrderBy());
    return sb.toString();
  }

}
