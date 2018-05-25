package utn111.pizzeria.modelo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClienteImplTest {

  @Test
  public void testClienteImplAlmacenaNombreCorrectamente() {
    final String nombre = createCliente().getNombre();
    assertEquals("pepe", nombre);
  }

  @Test
  public void testClienteImplAlmacenaNroClienteCorrectamente() {
    final int nroCliente = createCliente().getNroCliente();
    assertEquals(11, nroCliente);
  }

  private ClienteImpl createCliente() {
    ClienteDao clienteDao = new ClienteDao();
    clienteDao.setNroCliente(11);
    clienteDao.setNombre("pepe");
    return new ClienteImpl(clienteDao);
  }
}