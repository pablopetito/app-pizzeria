package utn111.pizzeria.db;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UpdateBuilderTest {

  @Test public void testUpdateSimple() {
    final String expSql = "update persona set edad = ?";
    final Object[] expParams = new Object[] { 12 };

    final Query query = Query
        .update("persona")
        .set("edad", 12)
        .build();

    final String sql = query.getSql();
    final Object[] params = query.getParams();

    assertEquals(expSql, sql);
    assertArrayEquals(expParams, params);
  }

  @Test public void testUpdateMultiple() {
    final String expSql = "update persona set edad = ?, dinero = ?, nombre = ?";
    final Object[] expParams = new Object[] { 12, 2.50f, "carlos" };

    final Query query = Query
        .update("persona")
        .set("edad", 12)
        .set("dinero", 2.50f)
        .set("nombre", "carlos")
        .build();

    final String sql = query.getSql();
    final Object[] params = query.getParams();

    assertEquals(expSql, sql);
    assertArrayEquals(expParams, params);
  }

  @Test public void testUpdateSimpleUnWhere() {
    final String expSql = "update persona set edad = ? where (nombre = ?)";
    final Object[] expParams = new Object[] { 12, "carlos" };

    final Query query = Query
        .update("persona")
        .set("edad", 12)
        .where("nombre = ?", "carlos")
        .build();

    final String sql = query.getSql();
    final Object[] params = query.getParams();

    assertEquals(expSql, sql);
    assertArrayEquals(expParams, params);
  }

  @Test public void testUpdateDobleUnWhere() {
    final String expSql = "update persona set edad = ?, nombre = ? where (id > ?)";
    final Object[] expParams = new Object[] { 12, "carlos", 123 };

    final Query query = Query
        .update("persona")
        .set("edad", 12)
        .set("nombre", "carlos")
        .where("id > ?", 123)
        .build();

    final String sql = query.getSql();
    final Object[] params = query.getParams();

    assertEquals(expSql, sql);
    assertArrayEquals(expParams, params);
  }

  @Test public void testUpdateSimpleOrder() {
    final String expSql = "update persona set edad = ? order by 1";
    final Object[] expParams = new Object[] { 12 };

    final Query query = Query
        .update("persona")
        .set("edad", 12)
        .orderBy("1")
        .build();

    final String sql = query.getSql();
    final Object[] params = query.getParams();

    assertEquals(expSql, sql);
    assertArrayEquals(expParams, params);
  }

  @Test public void testUpdateDobleOrder() {
    final String expSql = "update persona set edad = ?, nombre = ? order by nombre";
    final Object[] expParams = new Object[] { 12, "carlos" };

    final Query query = Query
        .update("persona")
        .orderBy("nombre")
        .set("edad", 12)
        .set("nombre", "carlos")
        .build();

    final String sql = query.getSql();
    final Object[] params = query.getParams();

    assertEquals(expSql, sql);
    assertArrayEquals(expParams, params);
  }

  @Test public void testUpdateSimpleUnWhereOrder() {
    final String expSql = "update persona set edad = ? where (nombre = ?) order by 1, 2";
    final Object[] expParams = new Object[] { 12, "carlos" };

    final Query query = Query
        .update("persona")
        .set("edad", 12)
        .orderBy("1", "2")
        .where("nombre = ?", "carlos")
        .build();

    final String sql = query.getSql();
    final Object[] params = query.getParams();

    assertEquals(expSql, sql);
    assertArrayEquals(expParams, params);
  }

  @Test public void testUpdateDobleUnWhereOrder() {
    final String expSql = "update persona set edad = ?, nombre = ? where (id > ?) order by nombre, 2";
    final Object[] expParams = new Object[] { 12, "carlos", 123 };

    final Query query = Query
        .update("persona")
        .set("edad", 12)
        .set("nombre", "carlos")
        .where("id > ?", 123)
        .orderBy("nombre", "2")
        .build();

    final String sql = query.getSql();
    final Object[] params = query.getParams();

    assertEquals(expSql, sql);
    assertArrayEquals(expParams, params);
  }

  @Test public void testUpdateSimpleLimit() {
    final String expSql = "update persona set edad = ?";
    final Object[] expParams = new Object[] { 12 };

    final Query query = Query
        .update("persona")
        .set("edad", 12)
        .build();

    final String sql = query.getSql();
    final Object[] params = query.getParams();

    assertEquals(expSql, sql);
    assertArrayEquals(expParams, params);
  }

  @Test public void testUpdateDobleLimit() {
    final String expSql = "update persona set edad = ?, nombre = ?";
    final Object[] expParams = new Object[] { 12, "carlos" };

    final Query query = Query
        .update("persona")
        .set("edad", 12)
        .set("nombre", "carlos")
        .build();

    final String sql = query.getSql();
    final Object[] params = query.getParams();

    assertEquals(expSql, sql);
    assertArrayEquals(expParams, params);
  }

  @Test public void testUpdateSimpleUnWhereLimit() {
    final String expSql = "update persona set edad = ? where (nombre = ?)";
    final Object[] expParams = new Object[] { 12, "carlos" };

    final Query query = Query
        .update("persona")
        .set("edad", 12)
        .where("nombre = ?", "carlos")
        .build();

    final String sql = query.getSql();
    final Object[] params = query.getParams();

    assertEquals(expSql, sql);
    assertArrayEquals(expParams, params);
  }

  @Test public void testUpdateDobleUnWhereLimit() {
    final String expSql = "update persona set edad = ?, nombre = ? where (id > ?) limit 15";
    final Object[] expParams = new Object[] { 12, "carlos", 123 };

    final Query query = Query
        .update("persona")
        .set("edad", 12)
        .set("nombre", "carlos")
        .where("id > ?", 123)
        .limit(15)
        .build();

    final String sql = query.getSql();
    final Object[] params = query.getParams();

    assertEquals(expSql, sql);
    assertArrayEquals(expParams, params);
  }

  @Test public void testUpdateSimpleOrderLimit() {
    final String expSql = "update persona set edad = ? order by 1 limit 12";
    final Object[] expParams = new Object[] { 12 };

    final Query query = Query
        .update("persona")
        .set("edad", 12)
        .orderBy("1")
        .limit(12)
        .build();

    final String sql = query.getSql();
    final Object[] params = query.getParams();

    assertEquals(expSql, sql);
    assertArrayEquals(expParams, params);
  }

  @Test public void testUpdateDobleOrderLimit() {
    final String expSql = "update persona set edad = ?, nombre = ? order by nombre limit 10";
    final Object[] expParams = new Object[] { 12, "carlos" };

    final Query query = Query
        .update("persona")
        .orderBy("nombre")
        .set("edad", 12)
        .set("nombre", "carlos")
        .limit(10)
        .build();

    final String sql = query.getSql();
    final Object[] params = query.getParams();

    assertEquals(expSql, sql);
    assertArrayEquals(expParams, params);
  }

  @Test public void testUpdateSimpleUnWhereOrderLimit() {
    final String expSql = "update persona set edad = ? where (dinero = ?) order by 1, 2 limit 6";
    final Object[] expParams = new Object[] { 12, 12.50f };

    final Query query = Query
        .update("persona")
        .limit(6)
        .set("edad", 12)
        .orderBy("1", "2")
        .where("dinero = ?", 12.50f)
        .build();

    final String sql = query.getSql();
    final Object[] params = query.getParams();

    assertEquals(expSql, sql);
    assertArrayEquals(expParams, params);
  }

  @Test public void testUpdateDobleUnWhereOrderLimit() {
    final String expSql = "update persona set edad = ?, nombre = ? where (id > ?) order by nombre, 2 limit 10";
    final Object[] expParams = new Object[] { 12, "carlos", 123 };

    final Query query = Query
        .update("persona")
        .set("edad", 12)
        .set("nombre", "carlos")
        .where("id > ?", 123)
        .limit(10)
        .orderBy("nombre", "2")
        .build();

    final String sql = query.getSql();
    final Object[] params = query.getParams();

    assertEquals(expSql, sql);
    assertArrayEquals(expParams, params);
  }

}
