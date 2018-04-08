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
  ,	cliente int 
  , fue_pedido_a_las datetime not null
  , sera_entregado_a_las datetime not null
  , estado varchar(30) not null
  , foreign key (id) 
	references clientes(nro_cliente)
	on update cascade
	on delete restrict
);

create table pedidos_pizzas (
	pedido int
  , pizza int
  , cantidad int not null
  , tamaño varchar[10] not null
  , primary key (pedido, pizza)
  , foreign key (pedido)
	references pedidos(id)
	on update cascade
	on delete restrict
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
