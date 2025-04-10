drop table if exists patients;
drop table if exists addresses;

create table addresses (
id int auto_increment primary key,
street varchar(50) not null,
number int not null,
neighborhood varchar(50) not null);


create table patients (
id int auto_increment primary key,
name varchar(50) not null,
lastname varchar(50) not null,
dni varchar(50) not null,
inDate date not null,
id_address int);

insert into addresses values(default, 'rue morge',165,'Le Marais');
insert into patients values(default, 'peter', 'Bernard','151413','2024-12-14',1);