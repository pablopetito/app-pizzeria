package utn111.pizzeria;

public class Pizzeria {

  public static void main(String[] args) throws Exception {

    if (args.length != 1 || args == null) {
      throw new IllegalArgumentException();
    }

    switch (args[0]) {

    case "cajero":
      cajero();
      break;

    case "admin":
      admin();
      break;

    case "cocina":
      cocina();
      break;

    default:
      throw new IllegalArgumentException();
    }

  }

  private static void cocina() {

    // agregar codigo
  }

  private static void admin() {

    // agregar codigo

  }

  private static void cajero() {

    // agregar codigo

  }
}
