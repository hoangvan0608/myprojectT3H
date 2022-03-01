drop database if exists myshop;
create database if not exists myshop;
use myshop;

drop table if exists category;
create table if not exists category (
	id int primary key auto_increment,
    `name` varchar(50)
    );

drop table if exists product;
create table if not exists product (
	id int primary key auto_increment,
    img varchar(500),
    price double,
    des varchar(100),
    `name` varchar(100),
	category int not null);


alter table product add foreign key (category) references category(id);

drop table if exists `account`;
create table if not exists `account` (
	id int primary key auto_increment,
    username varchar(100) not null unique,
    `password` varchar(200) not null,
    phone varchar(20),
    `email` varchar(100) not null,
    `role` enum('MANAGER', 'ADMIN', 'USER') not null,
    des varchar(200)
    );


drop table if exists `role`;
create table if not exists `role` (
	id int primary key auto_increment,
    `name` varchar(20) --  enum('MANAGER', 'ADMIN', 'USER') not null 
    );