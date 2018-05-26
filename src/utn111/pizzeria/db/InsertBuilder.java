package utn111.pizzeria.db;

public class InsertBuilder extends QueryBuilder {

  private int recordSize;
  private int recordCount;

  public InsertBuilder(String into) {
    super(into);
  }

  public InsertBuilder columnas(String...columnas) {
    addColumns(columnas);
    return this;
  }

  public InsertBuilder record(Object... record) {
    if (recordSize == 0) {
      recordSize = record.length;
    }
    else if (recordSize != record.length) {
      throw new IllegalArgumentException();
    }
    addParams(record);
    recordCount += 1;
    return this;
  }

  @Override
  protected String buildSql() {
    final StringBuilder sb = new StringBuilder();
    sb.append(buildInsert());
    sb.append(' ');
    sb.append(buildValues());
    return sb.toString();
  }

  private String buildInsert () {
    return String.format("insert into %s", table);
  }

  private String buildValues() {

    final StringBuilder sb = new StringBuilder();

    sb.append(
      recordCount == 1 
        ? "value "
        : "values "
    );

    for (int c = 0; c < recordCount; c += 1) {

      if (c != 0) {
        sb.append(", ");
      }

      sb.append('(');

      for (int s = 0; s < recordSize; s += 1) {
        sb.append(s == 0 ? "?" : ", ?");
      }

      sb.append(')');
    }
    return sb.toString();
  }
}
