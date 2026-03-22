create database demoJavadven;

use demoJavadven;

create table Customer (
	customer_id int primary key auto_increment,
	customer_name varchar(100) not null,
	phone varchar(20) unique not null,
	address varchar(255)
)