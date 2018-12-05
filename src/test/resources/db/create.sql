drop schema if exists carbook;
create schema carbook;
use carbook;
drop table if exists test1;
drop table if exists carprofile;
drop table if exists authorities;
drop table if exists users;
drop table if exists carmodel;
drop table if exists carmanufacturer;

create table carmanufacturer(
	id int not null auto_increment,
    active varchar(255),
    code varchar(255),
    name varchar(255),
    primary key (id)
);

create table carmodel(
	id int not null auto_increment,
    active varchar(255),
    name varchar(255),
    car_manufacturer_id int,
    primary key (id),
    foreign key (car_manufacturer_id) references carmanufacturer(id)
);

create table users(
	id int(11) not null auto_increment,
	email varchar(255),
	enabled bit(1),
	first_name varchar(255),
	last_name varchar(255),
	password varchar(255),
	username varchar(255),
    primary key(id)
);

create table authorities(
	id int not null auto_increment,
    authority varchar(255),
    username varchar(255),
    user_id int,
    primary key (id),
    foreign key (user_id) references users(id)
);

create table carprofile(
	id int not null auto_increment,
    ccm bigint(20),
    hp int,
    primary_car bit(1),
    year_of_production bigint(20),
    car_model_id int,
    user_id int,
    primary key (id),
    foreign key (car_model_id) references carmodel(id),
    foreign key (user_id) references users(id)
);

create table databasechangelog(
	ID varchar(63),
    AUTHOR varchar(63),
    FILENAME varchar(200),
    DATEEXECUTED datetime,
    ORDEREXECUTED int(11),
    EXECTYPE varchar(10),
    MD5SUM varchar(35),
    DESCRIPTION varchar(255),
    COMMENTS varchar(255),
    TAG varchar(255),
    LIQUIBASE varchar(20),
    primary key(ID,AUTHOR,FILENAME)
);

create table databasechangeloglock(
	ID int(11),
	LOCKED bit(1),
	LOCKGRANTED datetime,
	LOCKEDBY varchar(255),
    primary key(ID)
);

insert into `carmanufacturer` (`id`, `active`, `code`, `name`) values (1, 'ACTIVE', 'FIAT', 'Fiat');
insert into `carmanufacturer` (`id`, `active`, `code`, `name`) values (2, 'ACTIVE', 'BMW', 'Bmw');
insert into `carmanufacturer` (`id`, `active`, `code`, `name`) values (3, 'ACTIVE', 'FORD', 'Ford');

insert into `carmodel` (`id`, `active`, `name`, `car_manufacturer_id`) values (1, 'ACTIVE', 'Punto', 1);
insert into `carmodel` (`id`, `active`, `name`, `car_manufacturer_id`) values (2, 'ACTIVE', '320d', 2);
insert into `carmodel` (`id`, `active`, `name`, `car_manufacturer_id`) values (3, 'ACTIVE', 'Focus', 3);

insert into `users` (`id`, `email`, `enabled`, `first_name`, `last_name`, `password`, `username`) VALUES (1, 'simic90@live.com', true, 'Goran', 'Simic', '$2a$06$GSTyhDMHD51o30MZHoRSDOJrLpBhU0Hecb74hF.9xzQGlyYWr7woa', 'gsimic');
insert into `users` (`id`, `email`, `enabled`, `first_name`, `last_name`, `password`, `username`) VALUES (2, 'marko.pozdnjakov@gmail.com', true, 'Marko', 'Pozdnjakov', '$2a$06$GSTyhDMHD51o30MZHoRSDOJrLpBhU0Hecb74hF.9xzQGlyYWr7woa', 'passenger');
insert into `users` (`id`, `email`, `enabled`, `first_name`, `last_name`, `password`, `username`) VALUES (3, 'denis85@gmail.com', true, 'Denis', 'Coric', '$2a$06$GSTyhDMHD51o30MZHoRSDOJrLpBhU0Hecb74hF.9xzQGlyYWr7woa', 'denis85');

insert into `authorities` (`id`, `authority`, `username`, `user_id`) values (1, 'ROLE_USER', 'gsimic', 1);
insert into `authorities` (`id`, `authority`, `username`, `user_id`) values (2, 'ROLE_ADMIN', 'passenger', 2);
insert into `authorities` (`id`, `authority`, `username`, `user_id`) values (3, 'ROLE_ADMIN', 'denis85', 3);

insert into `carprofile` (`id`, `ccm`, `hp`, `primary_car`, `year_of_production`, `car_model_id`, `user_id`) values (1, 1200, 80, true, 2002, 1, 1);
insert into `carprofile` (`id`, `ccm`, `hp`, `primary_car`, `year_of_production`, `car_model_id`, `user_id`) values (2, 2000, 150, true, 2004, 2, 2);
insert into `carprofile` (`id`, `ccm`, `hp`, `primary_car`, `year_of_production`, `car_model_id`, `user_id`) values (3, 1800, 100, true, 2004, 3, 3);
