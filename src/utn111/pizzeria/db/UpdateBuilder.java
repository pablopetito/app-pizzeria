package utn111.pizzeria.db;

public class UpdateBuilder extends QueryBuilder {

  public UpdateBuilder(String table) {
    super(table);
  }

  @Override protected String buildSql() {
    StringBuilder sql = new StringBuilder();
    sql.append(buildUpdate());
    sql.append(buildSets());
    sql.append(buildWhere());
    sql.append(buildOrderBy());
    sql.append(buildLimit());
    return sql.toString();
  }

  private String buildUpdate() {
    return String.format("update %s set ", table);
  }

  private String buildSets() {
    return buildColumnas("%s = ?");
  }

  public UpdateBuilder set(String columna, int valor) {
    return set(columna, (Object) valor);
  }

  public UpdateBuilder set(String columna, float valor) {
    return set(columna, (Object) valor);
  }

  public UpdateBuilder set(String columna, String valor) {
    return set(columna, (Object) valor);
  }

  private UpdateBuilder set(String columna, Object valor) {
    addColumns(columna);
    addParams(valor);
    return this;
  }

  public UpdateBuilder where(String filtro, int valor) {
    return where(filtro, (Object) valor);
  }

  public UpdateBuilder where(String filtro, float valor) {
    return where(filtro, (Object) valor);
  }

  public UpdateBuilder where(String filtro, String valor) {
    return where(filtro, (Object) valor);
  }

  private UpdateBuilder where(String filtro, Object valor) {
    addWhere(filtro, valor);
    return this;
  }

  public UpdateBuilder orderBy(String... columnas) {
    addOrderBy(columnas);
    return this;
  }

  public UpdateBuilder limit(int count) {
    this.limit = count;
    this.offset = 0;
    return this;
  }
}
