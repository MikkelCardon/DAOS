CREATE TABLE Team(
team_id INT PRIMARY KEY,
navn VARCHAR(30)
)

CREATE TABLE Medarbejder(
medarbejder_id INT PRIMARY KEY,
navn VARCHAR(30),
stillingsbetegnelse VARCHAR(30),
mobil CHAR(8)
)

CREATE TABLE Projekt(
projekt_id INT PRIMARY KEY,
navn VARCHAR(30),
estimeretTimer INT,
deadline DATE,
team_id INT FOREIGN KEY REFERENCES Team(team_id)
)


CREATE TABLE OpgaveType(
opgaveType_id INT PRIMARY KEY,
navn VARCHAR(30),
beskrivelse VARCHAR(50)
)

CREATE TABLE Opgave(
opgave_id INT PRIMARY KEY,
beskrivelse VARCHAR(50),
prioritet INT,
forventet_start DATE,
deadline DATE,
opgave_status BIT,
projekt_id INT FOREIGN KEY REFERENCES Projekt(projekt_id) NOT NULL,
opgaveType_id INT FOREIGN KEY REFERENCES OpgaveType(opgaveType_id) NOT NULL
)

CREATE TABLE Tidsregistrering(
tidsregistrering_id INT PRIMARY KEY,
startTid DATE,
slutTid DATE,
beskrivelseAfArbejdet VARCHAR(30),
datoRegistrering VARCHAR(30),
medarbejder_id INT FOREIGN KEY REFERENCES Medarbejder(medarbejder_id) NOT NULL,
opgave_id INT FOREIGN KEY REFERENCES Opgave(opgave_id) NOT NULL
)

CREATE TABLE TeamMedarbejder(
team_id INT FOREIGN KEY REFERENCES Team(team_id) NOT NULL,
medarbejder_id INT FOREIGN KEY REFERENCES medarbejder(medarbejder_id),
PRIMARY KEY(team_id, medarbejder_id)
)

CREATE TABLE MedarbejderOpgavetype(
medarbejder_id INT FOREIGN KEY REFERENCES medarbejder(medarbejder_id) NOT NULL,
opgavetype_id INT FOREIGN KEY REFERENCES opgaveType(opgaveType_id),
Primary Key(medarbejder_id, opgavetype_id)
)
