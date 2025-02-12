--Opgave 01
SELECT medarbejder.navn, medarbejder.mobil 
FROM MedarbejderITeam
JOIN medarbejder ON Medarbejder.medarbejderNr = MedarbejderITeam.medarbejderNr
JOIN team ON team.teamId = MedarbejderITeam.teamId
WHERE team.navn = 'Team Alfa'

--Opgave 02
CREATE VIEW GetAllMembers
AS
SELECT team.navn AS Team, medarbejder.navn AS navn , medarbejder.mobil AS mobil
FROM MedarbejderITeam
JOIN medarbejder ON Medarbejder.medarbejderNr = MedarbejderITeam.medarbejderNr
JOIN team ON team.teamId = MedarbejderITeam.teamId

SELECT * FROM GetAllMembers

--Opgave 03
SELECT * 
FROM GetAllMembers
WHERE GetAllMembers.Team = 'Team Alfa'

--Opgave 04
CREATE PROC medarbejderByTeamNavn
@TeamNavn VARCHAR(30)
AS
BEGIN
SELECT * FROM GetAllMembers
WHERE GetAllMembers.Team = @TeamNavn
END

EXECUTE medarbejderByTeamNavn 'Team Alfa'

--Opgave 05
CREATE PROC medarbejderByForbogstav
@bogstav CHAR(1)
AS 
BEGIN
SELECT * FROM Medarbejder
WHERE navn LIKE @bogstav + '%'
END

EXECUTE medarbejderByForbogstav 'C'

--Opgave 06
EXEC sp_columns medarbejder
CREATE TABLE SlettedeMedarbejder(
medarbejderNr INT PRIMARY KEY,
navn VARCHAR(30),
stillingsbetegnelse VARCHAR(30),
mobil CHAR(10)
)

CREATE TRIGGER sletMedarbejder ON Medarbejder
INSTEAD OF DELETE
AS
BEGIN
INSERT INTO SlettedeMedarbejder (medarbejderNr, navn, stillingsbetegnelse, mobil)
SELECT MedarbejderNr, navn, stillingsbetegnelse, mobil FROM deleted
END

DELETE FROM Medarbejder
WHERE medarbejderNr IN(30, 31, 32, 33)

SELECT * FROM SlettedeMedarbejder
SELECT * FROM Medarbejder

--Opgave 07
SELECT * FROM Medarbejder
EXCEPT 
SELECT * FROM SlettedeMedarbejder

--Opgave 08
CREATE VIEW opgaveMedTidsregistrering
AS
SELECT opgave.opgaveNr, opgave.deadline, projekt.projektnavn, Medarbejder.navn, Tidsregistrering.datoRegistering
FROM Opgave
JOIN Tidsregistrering ON Tidsregistrering.opgaveNr = opgave.opgaveNr
JOIN Medarbejder ON medarbejder.medarbejderNr = Tidsregistrering.medarbejderNr
JOIN projekt ON projekt.projektNr = opgave.projektNr

SELECT * FROM opgaveMedTidsregistrering
WHERE navn LIKE 'Jennifer' + '%'

--Opgave 09
CREATE PROC tidsregistreringByMedarbejderNavn
@medarbejderNavn VARCHAR(30)
AS
BEGIN
SELECT * 
FROM opgaveMedTidsregistrering
WHERE navn LIKE @medarbejderNavn + '%'
END

EXEC tidsregistreringByMedarbejderNavn 'Jennifer'

--Opgave 10
CREATE VIEW tid
AS
SELECT tidsId, medarbejderNr, opgaveNr, DATEDIFF(MINUTE, starttid, sluttid) AS Minutter
FROM Tidsregistrering

CREATE PROC samletTimerForMedarbejder
@medarbejderNavn VARCHAR(30)
AS
BEGIN
SELECT @medarbejderNavn, (SELECT SUM(minutter) FROM tid 
JOIN medarbejder ON medarbejder.medarbejderNr = tid.medarbejderNr
WHERE medarbejder.navn LIKE @medarbejderNavn + '%')
END

DROP PROC samletTimerForMedarbejder
EXEC samletTimerForMedarbejder 'Jennifer'

--Opgave 11
CREATE TRIGGER udskrivTimer ON tidsregistrering
AFTER INSERT
AS
DECLARE @antalMinut AS VARCHAR(30)
SET @antalMinut = (SELECT DATEDIFF(MINUTE, starttid, sluttid) FROM INSERTED)
BEGIN
PRINT 'Antal minutter; ' + @antalMinut
END

DROP TRIGGER udskrivTimer
INSERT INTO Tidsregistrering VALUES
('8:30:00', '16:00:00', 'Godt arbejde', '2019-08-05', 1, 1)

SELECT * FROM Tidsregistrering

