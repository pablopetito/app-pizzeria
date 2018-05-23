package utn111.pizzeria.modelo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClienteImplTest {
  @Test
  public void clienteImplAlmacenaValoresCorrectos() {
    ClienteDao clienteDao = new ClienteDao();
    clienteDao.setNombre("pepe");
    clienteDao.setNroCliente(11);
    ClienteImpl clienteImpl = new ClienteImpl(clienteDao);
    assertEquals(clienteDao.getNombre(),clienteImpl.getNombre());
    assertEquals(clienteDao.getNroCliente(),clienteImpl.getNroCliente());
  }
}