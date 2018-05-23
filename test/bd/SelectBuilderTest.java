package bd;

import static org.junit.Assert.*;
import org.junit.Test;

public class SelectBuilderTest {

  @Test public void testQuerySelect() {
    String sql = "select * from tabla";
    Query query = Query.select("tabla").build();
    assertEquals(sql, query.getSql());
  }
  
  @Test public void testQuerySelectConColumna() {
    String sql = "select a, b from tabla";
    Query query = Query.select("tabla", "a", "b").build();
    assertEquals(sql, query.getSql());
  }

  @Test public void testQuerySelectWehereIsNull() {
    final String sql = "select * from tabla where (campo is null)";
    final Object[] params = new Object[] {};
    Query query = Query.select("tabla")
        .where("campo is null")
        .build();
    assertEquals(sql, query.getSql());
    assertArrayEquals(params, query.getParams());
  }

  @Test public void testQuerySelectWehereIsNullmasAnd() {
    final String sql = "select * from tabla where (campo is null) and (campo = ?)";
    final Object[] params = new Object[] { 123 };
    Query query = Query.select("tabla")
        .where("campo is null")
        .where("campo = ?", 123)
        .build();
    assertEquals(sql, query.getSql());
    assertArrayEquals(params, query.getParams());
  }

  @Test public void testQuerySelectWehereIsNullmasAndAnd() {
    final String sql = "select * from tabla where (campo is null) and (campo = ?) and (campo = ? or campo = ?)";
    final Object[] params = new Object[] { 123, "567", true };
    Query query = Query.select("tabla")
        .where("campo is null")
        .where("campo = ?", 123)
        .where("campo = ? or campo = ?", "567", true)
        .build();
    assertEquals(sql, query.getSql());
    assertArrayEquals(params, query.getParams());
  }
  
  @Test public void testQuerySelectConOrden() {
    String sql = "select * from tabla order by 1 asc, 2 desc";
    Query query = Query.select("tabla")
        .orderBy(1, "asc", 2, "desc")
        .build();
    assertEquals(sql, query.getSql());
  }
  
  @Test public void testQuerySelectConWhereConOrden() {
    String sql = "select * from tabla where (campo = ?) order by 1 asc, 2 desc";
    final Object[] params = new Object[] { 456 };
    Query query = Query.select("tabla")
        .where("campo = ?", 456)
        .orderBy(1, "asc", 2, "desc")
        .build();
    assertEquals(sql, query.getSql());
    assertArrayEquals(params, query.getParams());
  }
}
