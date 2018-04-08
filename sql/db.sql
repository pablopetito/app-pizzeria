create database if not exists pizzeria;

use pizzeria;

drop table if exsits facturas;
drop table if exists menues;
drop table if exists pizzas;
drop table if exists pedidos_pizzas;
drop table if exists pedidos;
drop table if exists clientes;

create table clientes (
    nro_cliente int auto_increment primary key
  , nombre varchar(50) not null
  , unique key (nombre)
);

create table pedidos (
    id int auto_increment primary key
  , cliente int 
  , pedido_a_las datetime not null
  , entregado_a_las datetime not null
  , estado varchar(30) not null
  , foreign key (cliente) 
      references clientes(nro_cliente)
);

create table pedidos_pizzas (
    pedido int
  , pizza int
  , tamaño varchar(10) not null
  , cantidad int not null
  , primary key (pedido, pizza)
  , foreign key (pedido)
      references pedidos(id)
  , foreign key (pizza)
      references pizzas(id) 
);

create table pizzas (
  -- cris
);

create table menues (
  -- cris
);


create table facturas (
  -- andres
);
