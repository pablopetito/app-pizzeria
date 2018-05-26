package utn111.pizzeria.modelo;

class ClienteImpl implements Cliente {
  private final ClienteDao clienteDao;

  public ClienteImpl(ClienteDao clienteDao) {
    this.clienteDao = clienteDao;
  }
  @Override
  public int getNroCliente() {
    return clienteDao.getNroCliente();
  }

  @Override
  public String getNombre() {
    return clienteDao.getNombre();
  }
}