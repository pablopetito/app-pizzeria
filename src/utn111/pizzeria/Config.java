package utn111.pizzeria;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;

public class Config {

  private final Properties ps;

  public Config (String arch) throws FileNotFoundException {

      ps = new Properties();
      final FileInputStream is = new FileInputStream(arch);

      try {
        ps.load(is);
      }
      catch (IOException e) {
       throw new RuntimeException(e);
      }
  }

  public String getString(String key) {;
    final String valor = ps.getProperty(key);
    if (valor == null) { 
      throw new NoSuchElementException();
    }
    return valor;
  }

  public int getInt(String key) {
    final String valor = getString(key);
    return Integer.parseInt(valor);
  }

}