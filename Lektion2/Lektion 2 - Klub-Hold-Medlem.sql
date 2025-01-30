create table Klub(
klubId char(8) primary key,
navn varchar(30)
)
create table Hold(
holdId int primary key,
holdNavn varChar(30) default 'Hold',
maxAntalpaaHold int check (maxAntalPaaHold < 15),
klubId char(8) foreign key references Klub(klubId) not null
)
create table Medlem(
medlemsId int,
navn varchar(30),
alder int,
primary key(medlemsId)
)
create table HoldMedlem(
holdId int foreign key references Hold(holdid) not null,
medlemsId int foreign key references Medlem(medlemsId),
primary key (holdID, medlemsID)
)
