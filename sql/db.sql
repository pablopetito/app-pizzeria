create database if not exists pizzeria;

use pizzeria;

drop table if exists facturas;
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
   id int auto_increment primary key
 , nombre varchar(50) not null
 , unique key (nombre) 
);

insert into pizzas (id, nombre)
  values (1, "Napolitana")
       , (2, "Muzzarella")
       , (3, "Fugazzeta")
;

create table menues (
   pizza int
 , tamaño int not null
 , precio float
 , tiempo_preparacion time
 , primary key (pizza, tamaño)
 , foreign key (pizza) references pizzas(id)
);

insert into menues(pizza, tamaño, precio, tiempo)
  values (1, 8, 10.00, "00:07:10")
       , (1, 10, 13.50, "00:08:10")
       , (1, 12, 15.00, "00:09:10")
       , (2, 8, 12.50, "00:07:10")
       , (2, 10, 15.50, "00:08:10")
       , (2, 12, 17.00, "00:09:10")
       , (3, 8, 15.00, "00:07:10")
       , (3, 10, 18.50, "00:08:10")
       , (3, 12, 20.00, "00:09:10")
;

create table facturas (
  total int
 ,pedido int
 ,cliente int
 ,foreign key (cliente) references clientes(nro_cliente)
 ,foreign key (pedido) references pedidos(id)
);
