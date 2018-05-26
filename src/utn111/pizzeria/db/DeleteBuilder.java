package utn111.pizzeria.db;

public class DeleteBuilder extends QueryBuilder {

  public DeleteBuilder(String from) {
    super(from);
  }

  public DeleteBuilder where(String condicion, Object... valores) {
    addWhere(condicion, valores);
    return this;
  }

  @Override
  protected String buildSql() {
    final StringBuilder sb = new StringBuilder();
    sb.append(buildQueryType());
    sb.append('*');
    sb.append(buildFrom());
    sb.append(buildWhere());
    return sb.toString();
  }

  @Override
  protected String buildQueryType () {
    return "delete ";
  }
}
