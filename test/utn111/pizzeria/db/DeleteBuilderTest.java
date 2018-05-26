package utn111.pizzeria.db;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DeleteBuilderTest {

  @Test public void testSoloTabla() {
    final String expected = "delete from tabla";
    final String sql = Query.delete("tabla")
        .build()
        .getSql()
    ;
    assertEquals(expected, sql);
  }

  @Test public void testWhereSimple() {
    final String expected = "delete from tabla where (id = ?)";
    final String sql = Query
        .delete("tabla")
        .where("id = ?", 123)
        .build()
        .getSql()
    ;
    assertEquals(expected, sql);
  }

  @Test public void testOrderBy() {
    final String expected = "delete from tabla order by fecha desc";
    final String sql = Query
        .delete("tabla")
        .orderBy("fecha desc")
        .build()
        .getSql()
    ;
    assertEquals(expected, sql);
  }

  @Test public void testWhereOrderBy() {
    final String expected = "delete from tabla where (id = ?) order by fecha desc";
    final String sql = Query
        .delete("tabla")
        .where("id = ?", 123)
        .orderBy("fecha desc")
        .build()
        .getSql()
    ;
    assertEquals(expected, sql);
  }

  @Test public void testLimitSolo() {
    final String expected = "delete from tabla limit 25";
    final String sql = Query
        .delete("tabla")
        .limit(25)
        .build()
        .getSql()
    ;
    assertEquals(expected, sql);
  }

  @Test public void testLimitOffset() {
    final String expected = "delete from tabla limit 25, 10";
    final String sql = Query
        .delete("tabla")
        .limit(25, 10)
        .build()
        .getSql()
    ;
    assertEquals(expected, sql);
  }

  @Test public void testLimitDespOffset() {
    final String expected = "delete from tabla limit 25, 10";
    final String sql = Query
        .delete("tabla")
        .limit(25)
        .offset(10)
        .build()
        .getSql()
    ;
    assertEquals(expected, sql);
  }

  @Test public void testOffsetDespLimit() {
    final String expected = "delete from tabla limit 25, 10";
    final String sql = Query
        .delete("tabla")
        .offset(10)
        .limit(25)
        .build()
        .getSql()
    ;
    assertEquals(expected, sql);
  }

  @Test public void testWhereLimit() {
    final String expected = "delete from tabla where (a is null) limit 123";
    final String sql = Query
        .delete("tabla")
        .where("a is null")
        .limit(123)
        .build()
        .getSql()
    ;
    assertEquals(expected, sql);
  }

  @Test public void testOrderByLimit() {
    final String expected = "delete from tabla order by 2 limit 123";
    final String sql = Query
        .delete("tabla")
        .orderBy("2")
        .limit(123)
        .build()
        .getSql()
    ;
    assertEquals(expected, sql);
  }

}
