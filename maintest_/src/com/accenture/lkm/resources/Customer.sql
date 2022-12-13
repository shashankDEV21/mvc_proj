drop database if exists springmvctest;
 create database springmvctest;
 use springmvctest;
 
 drop table if exists complianttype;
 create table complianttype(
 compliantTypeId int(10),
 compliantTypeName varchar(50) not null,
 primary key(complianttypeid)
 );
 
 drop table if exists compliant;
 create table compliant(
 compliantId int(10) auto_increment,
 customerName varchar(50) not null,
 description varchar(100),
 dateOfIncidence date,
 amount double,
 compliantTypeId int(10),
 primary key(compliantid),
 foreign key(compliantTypeId) references complianttype(compliantTypeId)
 );
 
 
 insert into complianttype values
 (1001,'Quality-related'),
 (1002,'Cost-related'),
 (1003,'Delivery-related'),
 (1004,'Wait time-related');
 commit;
 
 insert into compliant values
 (1,'Vikram Seth','Quality is not as expected','2018-01-22',30000,1001),
 (2,'Adira','Overcharged on bill than actual price','2019-01-12',50000,1002),
 (3,'Adidev','Wrong Product delivered','2020-01-24',70000,1003);
 
 commit;
 