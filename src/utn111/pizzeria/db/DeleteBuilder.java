package utn111.pizzeria.db;

public class DeleteBuilder extends QueryBuilder {

  public DeleteBuilder(String from) {
    super(from);
  }

  @Override
  protected String buildSql() {
    final StringBuilder sb = new StringBuilder();
    sb.append(buildQueryType());
    sb.append('*');
    sb.append(buildFrom());
    return sb.toString();
  }

  @Override
  protected String buildQueryType () {
    return "delete ";
  }
}
