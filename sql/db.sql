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
  -- pablo
);

create table pedidos_pizzas (
  -- pablo
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
