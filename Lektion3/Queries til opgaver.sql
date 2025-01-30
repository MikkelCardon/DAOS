-- OPGAVE TIL TIDSREGISTRERING
--Opgave 01

SELECT navn, medarbejder.medarbejderNr
FROM Medarbejder
JOIN MedarbejderITeam ON Medarbejder.medarbejderNr = MedarbejderITeam.medarbejderNr
WHERE MedarbejderITeam.teamId = 3

--Opgave 02
SELECT * FROM Tidsregistrering

SELECT DISTINCT navn 
FROM Medarbejder
JOIN Tidsregistrering ON Medarbejder.medarbejderNr = Tidsregistrering.medarbejderNr

--Opgave 03
SELECT navn, Tidsregistrering.datoRegistering 
FROM Medarbejder
LEFT JOIN Tidsregistrering ON Medarbejder.medarbejderNr = Tidsregistrering.medarbejderNr

--Opgave 04
SELECT projekt.projektNr, projekt.projektNavn, Opgave.opgaveNr, Opgavetype.navn
FROM projekt 
JOIN Opgave ON projekt.projektNr = opgave.projektNr
JOIN Opgavetype ON opgave.opgavetypeId = opgaveType.opgavetypeId

--Opgave 05
SELECT team.teamId, team.navn, Opgave.opgaveNr 
FROM Team
JOIN projekt ON team.teamId = projekt.teamId
JOIN Opgave ON projekt.projektNr = opgave.projektNr
WHERE opgave.statusPaaOpgave = 'Færdig'