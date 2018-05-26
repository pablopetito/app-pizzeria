package utn111.pizzeria.db;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DeleteBuilderTest {

  @Test public void testSoloTabla() {
    final String expected = "delete * from tabla";
    final String sql = Query.delete("tabla")
        .build()
        .getSql()
    ;
    assertEquals(expected, sql);
  }

  @Test public void testWhereSimple() {
    final String expected = "delete * from tabla where (id = ?)";
    final String sql = Query
        .delete("tabla")
        .where("id = ?", 123)
        .build()
        .getSql()
    ;
    assertEquals(expected, sql);
  }
}
