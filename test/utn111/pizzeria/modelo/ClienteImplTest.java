package utn111.pizzeria.modelo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClienteImplTest {
  @Test
  public void testClienteImplAlmacenaNombreCorrectamente() {
    ClienteImpl clienteImpl = new ClienteImpl(createDao());
    assertEquals("pepe",clienteImpl.getNombre());
  }

  @Test
  public void testClienteImplAlmacenaNroClienteCorrectamente() {
    ClienteImpl clienteImpl = new ClienteImpl(createDao());
    assertEquals(11,clienteImpl.getNroCliente());
  }

  private ClienteDao createDao() {
    ClienteDao clienteDao = new ClienteDao();
    clienteDao.setNroCliente(11);
    clienteDao.setNombre("pepe");
    return clienteDao;
  }
}