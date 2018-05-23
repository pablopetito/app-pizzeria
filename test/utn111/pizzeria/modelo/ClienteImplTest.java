package utn111.pizzeria.modelo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClienteImplTest {
  @Test
  public void clienteImplAlmacenaNombreCorrectamente() {
    ClienteDao clienteDao = new ClienteDao();
    clienteDao.setNombre("pepe");
    ClienteImpl clienteImpl = new ClienteImpl(clienteDao);
    assertEquals("pepe",clienteImpl.getNombre());
  }

  @Test
  public void clienteImplAlmacenaNroClienteCorrectamente() {
    ClienteDao clienteDao = new ClienteDao();
    clienteDao.setNroCliente(11);
    ClienteImpl clienteImpl = new ClienteImpl(clienteDao);
    assertEquals(11,clienteImpl.getNroCliente());
  }
}