package utn111.pizzeria.modelo.dao;

import java.time.Duration;

public class Menues {

  private int pizza;
  private int tamaño;
  private float precio;
  private Duration tiempoPreparacion;

  public Menues() {
  }

  public int getPizza() {
    return pizza;
  }

  public void setPizza(int pizza) {
    this.pizza = pizza;
  }

  public int getTamaño() {
    return tamaño;
  }

  public void setTamaño(int tamaño) {
    this.tamaño = tamaño;
  }

  public float getPrecio() {
    return precio;
  }

  public void setPrecio(float precio) {
    this.precio = precio;
  }

  public Duration getTiempoPreparacion() {
    return tiempoPreparacion;
  }

  public void setTiempoPreparacion(Duration tiempoPreparacion) {
    this.tiempoPreparacion = tiempoPreparacion;
  }
}
