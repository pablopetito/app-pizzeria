package bd;

import java.util.ArrayList;
import java.util.List;

public class SelectBuilder {

  private final String tabla;
  private final List<Object> params = new ArrayList<>();
  private String sql;

  public SelectBuilder(String from) {
    tabla = from;
  }

  public SelectBuilder where(String campo, Object valor) {
    params.add("where");
    params.add(campo);
    params.add(valor);
    return this;
  }

  public SelectBuilder groupBy(Object columna) {
    params.add("group");
    params.add(columna);
    return this;
  }

  public Query build() {
    sql = String.format("select * from %s", tabla);
    int indice = buscarParamsWhere();

    if (indice >= 0) {
      sql = sql + String.format(" where %s = %s", params.get(indice + 1),
          params.get(indice + 2));
    }

    indice = buscarParamsGroup();
    if (indice >= 0) {
      sql = sql + String.format(" group by %s", params.get(indice + 1));
    }

    return new Query(sql, params.toArray());
  }

  public int buscarParamsWhere() {
    int indice = -1;
    if (params.size() == 0) return indice;

    for (int indx = 0; indx < params.size(); indx++) {
      if (params.get(indx).equals("where")) return indice = indx;
    }

    return indice;
  }

  public int buscarParamsGroup() {
    int indice = -1;
    if (params.size() == 0) return indice;
    for (int indx = 0; indx < params.size(); indx++) {

      if (params.get(indx).equals("group")) return indice = indx;

    }
    return indice;
  }
}
// referencia propia - provisoria
// WHERE CON a = ? and b = ?
// WHERE CON a = ? or b = ?
// VER SELECT a,b from tabla
// VER SELECT COUNT(*) from tabla
