package utn111.pizzeria.db;

public class InsertBuilder extends QueryBuilder {

  private int recordSize;
  private int recordCount;

  public InsertBuilder(String into) {
    super(into);
  }

  public InsertBuilder columnas(String...columnas) {
    setOrCheckRecordSize(columnas.length);
    addColumns(columnas);
    return this;
  }

  public InsertBuilder recordSize(int size) {
    recordSize = size;
    return this;
  }

  private void setOrCheckRecordSize (int size) {
    if (recordSize == 0) {
      recordSize = size;
    }
    else if (recordSize != size) {
      throw new IllegalArgumentException();
    }
  }

  public InsertBuilder record(Object... columns) {
    setOrCheckRecordSize(columns.length);
    addParams(columns);
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

    final String columnas;

    if (columns.size() > 0) {
      columnas = String.format("(%s)", buildColumnas());
    } else {
      columnas = "";
    }

    return String.format("insert into %s%s", table, columnas);
  }

  private String buildValues() {

    final StringBuilder sb = new StringBuilder();

    sb.append("values ");

    final int count;

    if (recordCount == 0) count = 1;
    else count = recordCount;

    for (int c = 0; c < count; c += 1) {

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
