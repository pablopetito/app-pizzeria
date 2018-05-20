package bd;

import static org.junit.Assert.*;
import org.junit.Test;

public class SelectBuilderTest {

  @Test
  public void testQuerySelect() {
    String sql = "select * from tabla";
    Query query = Query.select("tabla").build();
    assertEquals(sql, query.getSql());
    System.out.println(sql);
  }

  @Test
  public void testQuerySelectConWehere() {
    final String sql = "select * from tabla where campo = 123";
    final Object[] params = new Object[] { "where", "campo", 123 };
    Query query = Query.select("tabla")
        .where("campo", 123)
        .build();
    assertEquals(sql, query.getSql());
    assertArrayEquals(params, query.getParams());
    System.out.println(sql);
  }

  @Test
  public void testQuerySelectConWehereGroup() {
    final String sql = "select * from tabla where campo = 123 group by 1";
    final Object[] params = new Object[] { "where", "campo", 123, "group",  1 };
    Query query = Query.select("tabla")
        .where("campo", 123)
        .groupBy(1)
        .build();
    assertEquals(sql, query.getSql());
    assertArrayEquals(params, query.getParams());
    System.out.println(sql);
  }

  @Test
  public void testQuerySelectConGroupSolo() {
    final String sql = "select * from tabla group by 1";
    final Object[] params = new Object[] {"group", 1 };
    Query query = Query.select("tabla")
        .groupBy(1)
        .build();
    assertEquals(sql, query.getSql());
    assertArrayEquals(params, query.getParams());
    System.out.println(sql);
  }
}
