drop database if exists springmvcmocks;
create database springmvcmocks;
use springmvcmocks;

drop table if exists complianttype;
create table complianttype(
complianttypeid int ,
complianttypename varchar(50) not null,
primary key(complianttypeid)
);

drop table if exists compliant;
create table compliant(
compliantid int(10) auto_increment,
customername varchar(50) not null,
description varchar(100) default null,
dateofincidence datetime default null,
amount double default null,
complianttypeid int(10),
primary key(compliantid),
foreign key(complianttypeid) references complianttype(complianttypeid)
);
insert into complianttype values (1001,'Quality-related');
insert into complianttype values (1002,'Cost-related');
insert into complianttype values (1003,'Delivery-related');
insert into complianttype values (1004,'Wait Time-related');

commit;

insert into compliant values (1,'Vikram Seth','Quality is not as expected','2018-01-22',30000,1001);
insert into compliant values (2,'Adira','Overcharged on bill than actual price','2019-01-12',50000,1002);
insert into compliant values (3,'Adidev','Wrong Product Delivered','2020-01-24',70000,1003);

commit;

