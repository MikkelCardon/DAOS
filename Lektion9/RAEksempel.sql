drop table Reserves
drop table Sailors
drop table Boats

create table Sailors(
said int primary key,
sname varchar(20),
rating int,
age int
)

create table Boats(
bid int primary key,
bname varchar(20),
color varchar(10)
)

create table Reserves(
said int FOREIGN KEY REFERENCES sailors(said),
bid int FOREIGN KEY REFERENCES boats(bid),
dag date
)

insert into Sailors values
(22,'Dustin', 7, 45),
(29,'Brutus', 1, 33),
(31,'Lubber', 8, 55),
(32,'Andy', 8, 25),
(58,'Rysty', 10, 35),
(64,'Horatio', 7, 35),
(71,'Zorba', 10, 16),
(74,'Horatio', 9, 35),
(85,'Art', 3, 25),
(95,'Bob', 3, 63)


insert into Boats values
(101,'Interlake', 'blue'),
(102,'Interlake', 'red'),
(103,'Clipper', 'green'),
(104,'Marine', 'red')


insert into Reserves values
(22, 101, '2023-10-10'),
(22, 102, '2023-10-10'),
(22, 103, '2023-08-10'),
(22, 104, '2023-07-10'),
(31, 102, '2023-10-11'),
(31, 103, '2023-06-11'),
(31, 104, '2023-12-11'),
(64, 101, '2023-05-09'),
(64, 102, '2023-08-10'),
(74, 103, '2023-08-09')


