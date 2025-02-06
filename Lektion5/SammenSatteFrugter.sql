--drop table frugtAvler
--drop table importoerFrugt
--drop table frugtimportoer

Create table frugtavler(
idAvler int primary key,
navn varchar(30),
telefon char(8)
)

Create table frugtsaelger(
idSaelger int primary key,
navn varchar(30),
telefon char(10)
)

Create table frugtimportoer(
idImportoer int primary key,
navn varchar(30),
telefon char(10)
)

Create table frugt(
navn varchar(30) primary key
)

create table avlerfrugt(
navn varchar(30) foreign key references frugt(navn),
idAvler int foreign key references frugtAvler(idAvler)
)

create table saelgerFrugt(
navn varchar(30) foreign key references frugt(navn),
idSaelger int foreign key references frugtSaelger(idSaelger)
)

create table importoerFrugt(
navn varchar(30) foreign key references frugt(navn),
idImportoer int foreign key references frugtImportoer(idImportoer)
)

insert into frugtavler values
(1, 'Bo Hansen', '45789898'),
(2, 'Ulla Jensen', '45348767'),
(3, 'Ib Ibsen', '45908987'),
(4, 'Hans Hansen', '45123456'),
(5, 'Ben Forta', '45901256'),
(6, 'James Kurose', '45678901'),
(7, 'Keith Ross', '45987654'),
(8, 'Finn Finsen', '45876876'),
(9, 'Frede Lange', '45458765'),
(10, 'Karen Kledsen', '45897678')

insert into frugtSaelger values
(1, 'Bodil Hansen', '45908767'),
(2, 'Ulla Jensen', '45348767'),
(3, 'Ib Ibsen', '45908987'),
(4, 'Hans Jensen', '45987654'),
(5, 'Ben Forta', '45901256'),
(6, 'James Kurose', '45678901'),
(7, 'Keith Ross', '45987654'),
(8, 'Lene Poulsen', '45678567'),
(9, 'Frede Lange', '45458765'),
(10, 'Kim Glad', '45454545')


insert into frugtImportoer values
(1, 'Bodil Hansen', '45908767'),
(2, 'Ulla Jensen', '45348767'),
(3, 'Ole Ibsen', '45787878'),
(4, 'Hans Jensen', '45987654'),
(5, 'Benny Forta', '45233445'),
(6, 'James Kurose', '45678901'),
(7, 'Keith Ross', '45987654'),
(8, 'Lars Poulsen', '45876678'),
(9, 'Freddi Skov', '45909878'),
(10, 'Karen Glad', '45909090')


insert into frugt values
('æbler'),
('appelsiner'),
('pære'),
('blommer'),
('jordbær'),
('hindbær'),
('bananer')


insert into avlerfrugt values
('æbler', 1),
('appelsiner', 1),
('pære', 2),
('blommer', 2)

insert into avlerfrugt values
('æbler', 3),
('appelsiner', 3),
('pære', 3),
('blommer', 3)


insert into saelgerFrugt values
('æbler', 1),
('appelsiner', 1),
('pære', 2),
('blommer', 2)

insert into saelgerfrugt values
('æbler', 3),
('appelsiner', 3),
('pære', 3),
('blommer', 3)

insert into importoerFrugt values
('æbler', 1),
('appelsiner', 1),
('pære', 2),
('blommer', 2)




