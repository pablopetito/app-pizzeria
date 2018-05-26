package utn111.pizzeria.db;

import static org.junit.Assert.*;
import org.junit.Test;

public class SelectBuilderTest {

  @Test public void testQuerySelect() {
    String sql = "select * from tabla as t1";
    Query query = Query.select("tabla as t1").build();
    assertEquals(sql, query.getSql());
  }

  @Test public void testQuerySelectConColumna() {
    String sql = "select a as c1, b as c2 from tabla as t1";
    Query query = Query.select("tabla as t1")
        .columnas("a as c1", "b as c2")
        .build();
    assertEquals(sql, query.getSql());
  }

  @Test public void testQuerySelectWehereIsNull() {
    final String sql = "select * from tabla as t1 where (campo is null)";
    final Object[] params = new Object[] {};
    Query query = Query.select("tabla as t1")
        .where("campo is null")
        .build();
    assertEquals(sql, query.getSql());
    assertArrayEquals(params, query.getParams());
  }

  @Test public void testQuerySelectWehereIsNullmasAnd() {
    final String sql = "select * from tabla as t1 where (campo is null) and (campo = ?)";
    final Object[] params = new Object[] { 123 };
    Query query = Query.select("tabla as t1")
        .where("campo is null")
        .where("campo = ?", 123)
        .build();
    assertEquals(sql, query.getSql());
    assertArrayEquals(params, query.getParams());
  }

  @Test public void testQuerySelectWehereIsNullmasAndAnd() {
    final String sql = "select * from tabla as t1 where (campo is null) and (campo = ?) and (campo = ? or campo = ?)";
    final Object[] params = new Object[] { 123, "567", true };
    Query query = Query.select("tabla as t1")
        .where("campo is null")
        .where("campo = ?", 123)
        .where("campo = ? or campo = ?", "567", true)
        .build();
    assertEquals(sql, query.getSql());
    assertArrayEquals(params, query.getParams());
  }

  @Test public void testQuerySelectConOrden() {
    String sql = "select * from tabla as t1 order by 1 asc, columna desc";
    Query query = Query.select("tabla as t1")
        .orderBy("1 asc", "columna desc")
        .build();
    assertEquals(sql, query.getSql());
  }

  @Test public void testQuerySelectConWhereConOrden() {
    String sql = "select * from tabla as t1 where (campo = ?) order by colum1 desc, colum2 desc";
    final Object[] params = new Object[] { 456 };
    Query query = Query.select("tabla as t1")
        .where("campo = ?", 456)
        .orderBy("colum1 desc", "colum2 desc")
        .build();
    assertEquals(sql, query.getSql());
    assertArrayEquals(params, query.getParams());
  }

  @Test public void testQuerySelectConLimit() {
    String sql = "select * from tabla as t1 limit 5";
    Query query = Query.select("tabla as t1")
        .limit(5)
        .build();
    assertEquals(sql, query.getSql());
  }

  @Test public void testQuerySelectConLimitDesde() {
    String sql = "select * from tabla as t1 limit 3, 30";
    Query query = Query.select("tabla as t1")
        .limit(3,30)
        .build();
    assertEquals(sql, query.getSql());
  }

  @Test public void testQuerySelectConGroup() {
    String sql = "select * from tabla as t1 group by column";
    Query query = Query.select("tabla as t1")
        .groupBy("column")
        .build();
    assertEquals(sql, query.getSql());
  }

  @Test public void testQuerySelectConGroupPorDosColum() {
    String sql = "select * from tabla as t1 group by column, column2";
    Query query = Query.select("tabla as t1")
        .groupBy("column", "column2")
        .build();
    assertEquals(sql, query.getSql());
  }
}
