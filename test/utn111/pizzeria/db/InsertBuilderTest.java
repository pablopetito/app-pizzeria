package utn111.pizzeria.db;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class InsertBuilderTest {

  @Test public void testInsertConColumnas() {
    final String expSql = "insert into persona(nombre, id) values (?, ?)";
    final String sql = Query.insert("persona")
        .columnas("nombre", "id")
        .build()
        .getSql();

    assertEquals(expSql, sql);
  }

  @Test public void testInsertValuesPrepared() {
    final String expSql = "insert into una.tabla values (?, ?, ?, ?)";
    final Query query = Query.insert("una.tabla")
        .recordSize(4)
        .build();

    final String sql = query.getSql();
    assertEquals(expSql, sql);
  }

  @Test public void testInsertValueUnico() {
    final String expSql = "insert into persona value (?, ?)";
    final Object[] expParams = new Object[] { "pepe", 25, };
    final Query query = Query.insert("persona")
        .record("pepe", 25)
        .build();

    final String sql = query.getSql();
    final Object[] params = query.getParams();

    assertEquals(expSql, sql);
    assertArrayEquals(expParams, params);
  }

  @Test public void testInsertValuesMultiples() {
    final String expSql = "insert into persona values (?, ?), (?, ?), (?, ?)";
    final Object[] expParams = new Object[] {
      "pepe", 25,
      "carlos", 35,
      "augusto", 45,
    };
    final Query query = Query.insert("persona")
        .record("pepe", 25)
        .record("carlos", 35)
        .record("augusto", 45)
        .build();

    final String sql = query.getSql();
    final Object[] params = query.getParams();

    assertEquals(expSql, sql);
    assertArrayEquals(expParams, params);
  }

}
