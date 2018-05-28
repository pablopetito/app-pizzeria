package utn111.pizzeria.db;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;
import utn111.pizzeria.db.Conexion;

public class ConexionTest {

  private Conexion database() {
    final Connection cnn = Conexion.withSqlite();

    try {
      cnn.prepareStatement("create table personas(id int, nombre varchar(200));")
         .execute();

      try (final PreparedStatement ps = cnn.prepareStatement("insert into personas values (?, ?)")) {

        ps.setInt(1, 1);
        ps.setString(2, "pepe");
        ps.execute();

        ps.setInt(1, 2);
        ps.setString(2, "carlos");
        ps.execute();

        ps.setInt(1, 3);
        ps.setString(2, "augusto");
        ps.execute();
      }
    }
    catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return new Conexion(cnn);
  }

  @Test public void testExecuteString() {
    final Conexion db = database();
    final int deleted = db.execute("delete from personas");
    assertEquals(3, deleted);
  }

  @Test public void testExecuteSimple() {
    final Conexion db = database();
    final int deleted = db.execute(
      Query.delete("personas")
    );
    assertEquals(3, deleted);
  }

  @Test public void testExecuteUnString() {
    final Conexion db = database();
    final int deleted = db.execute(
      Query.delete("personas")
           .where("nombre = ?", "pepe")
    );
    assertEquals(1, deleted);
  }

  @Test public void testExecuteUnStringUnInt() {
    final Conexion db = database();
    final int deleted = db.execute(
      Query.delete("personas")
           .where("id = ? or nombre = ?", 2, "pepe")
    );
    assertEquals(2, deleted);
  }

  @Test public void testSelectString() {
    final Conexion db = database();
    final int selected = db.select("select count(*) from personas").getInteger(1);
    assertEquals(3, selected);
  }

  @Test public void testSelectSimple() {
    final Conexion db = database();
    final int selected = db.select(
      Query.select("personas")
           .columnas("count(*)")
    ).getInteger(1);
    assertEquals(3, selected);
  }

  @Test public void testSelectUnString() {
    final Conexion db = database();
    final int selected = db.select(
      Query.select("personas")
           .columnas("count(*)")
           .where("nombre = ?", "pepe")
    ).getInteger(1);
    assertEquals(1, selected);
  }

  @Test public void testSelectUnStringUnInt() {
    final Conexion db = database();
    final int selected = db.select(
      Query.select("personas")
           .columnas("count(*)")
           .where("id = ? or nombre = ?", 2, "pepe")
    ).getInteger(1);
    assertEquals(2, selected);
  }

}