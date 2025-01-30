/*   OPGAVE A  */
CREATE TABLE BeboelseA(
beboelses_id INT PRIMARY KEY,
kvm INT NOT NULL,
adresse VARCHAR(30),
sal INT,
antalVærelser INT,
grundKVM INT,
carport BIT,
type_beboelse VARCHAR(30)
)

/*   OPGAVE B  */
CREATE TABLE BeboelseB_Lejlighed(
beboelses_id INT PRIMARY KEY,
kvm INT NOT NULL,
adresse VARCHAR(30),
sal INT,
antalVærelser INT
)

CREATE TABLE BeboelseB_Hus(
adresse VARCHAR(30) PRIMARY KEY,
kvm INT NOT NULL,
grundKVM INT,
carport BIT
)


/*   OPGAVE C  */
CREATE TABLE beboelse_Super(
beboelses_id INT PRIMARY KEY,
kvm INT NOT NULL,
adresse VARCHAR(30),
)

CREATE TABLE beboelse_C_Lejlighed(
sal INT,
antalVærelser INT,
beboelses_id INT FOREIGN KEY REFERENCES beboelse_Super(beboelses_id),
PRIMARY KEY(beboelses_id)
)

CREATE TABLE beboelse_C_Hus(
grundKVM INT,
carport BIT,
beboelses_id INT FOREIGN KEY REFERENCES beboelse_Super(beboelses_id),
PRIMARY KEY(beboelses_id)
)

/* INSERT DATA */
INSERT INTO BeboelseA VALUES
--Lejligheder
(1, 54, 'vej1', 2, 2,0,0, 'lejlighed'),
(2, 72, 'vej2', 1, 2,0,0, 'lejlighed'),
(3, 45, 'vej3', 3, 2,0,0, 'lejlighed'),
--Huse
(4, 54, 'vej1', 0, 0,30,1, 'Hus'),
(5, 72, 'vej2', 0, 0,70,0, 'Hus'),
(6, 45, 'vej3', 0, 0,110,1, 'Hus')

INSERT INTO BeboelseB_Lejlighed VALUES
(1, 45, 'lejlighedsvej 1', 1, 2),
(2, 55, 'lejlighedsvej 2', 2, 3),
(3, 65, 'lejlighedsvej 3', 1, 2)

INSERT INTO BeboelseB_Hus VALUES
('husvej 1', 55, 45, 0),
('husvej 2', 55, 45, 1),
('husvej 3', 55, 45, 0)

INSERT INTO beboelse_Super VALUES
(1, 25, 'vej1'),
(2, 45, 'vej2')

INSERT INTO beboelse_C_Lejlighed VALUES
(1, 2, 1)

INSERT INTO beboelse_C_Hus VALUES
(1, 2, 2)
/*
CREATE TABLE beboelse_Super(
beboelses_id INT PRIMARY KEY,
kvm INT NOT NULL,
adresse VARCHAR(30),
)

CREATE TABLE beboelse_C_Lejlighed(
sal INT,
antalVærelser INT,
beboelses_id INT FOREIGN KEY REFERENCES beboelse_Super(beboelses_id),
PRIMARY KEY(beboelses_id)
)

CREATE TABLE beboelse_C_Hus(
grundKVM INT,
carport BIT,
beboelses_id INT FOREIGN KEY REFERENCES beboelse_Super(beboelses_id),
PRIMARY KEY(beboelses_id)
)
*/