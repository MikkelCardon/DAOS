--Opgave 01
SELECT projektnavn, estimeretTimer FROM Projekt
WHERE estimeretTimer = (SELECT MIN(estimeretTimer) FROM projekt)

--Opgave 02.1
SELECT navn 
FROM Medarbejder
WHERE medarbejderNr IN (SELECT  medarbejderNr FROM Tidsregistrering)

--Opgave 02.2
SELECT navn 
FROM Medarbejder
WHERE NOT medarbejderNr IN (SELECT  medarbejderNr FROM Tidsregistrering)

--Opgave 02.3
SELECT navn FROM medarbejder
EXCEPT 
SELECT navn 
FROM Medarbejder
WHERE medarbejderNr IN (SELECT  medarbejderNr FROM Tidsregistrering)


--Opgave 03
SELECT DISTINCT navn FROM Medarbejder
JOIN Tidsregistrering ON medarbejder.medarbejderNr = Tidsregistrering.medarbejderNr

--Opgave 04
SELECT * FROM Tidsregistrering

SELECT projekt.projektnavn, opgave.opgaveNr, opgave.statusPaaOpgave, navn 
FROM Tidsregistrering
JOIN Medarbejder ON Tidsregistrering.medarbejderNr = medarbejder.medarbejderNr
JOIN Opgave ON opgave.opgaveNr = Tidsregistrering.opgaveNr
JOIN Projekt ON projekt.projektnr = opgave.projektNr

--Opgave 05
SELECT DISTINCT navn FROM Medarbejder
JOIN Tidsregistrering ON Tidsregistrering.medarbejderNr = medarbejder.medarbejderNr
JOIN opgave ON opgave.opgaveNr = Tidsregistrering.opgaveNr
WHERE opgave.statusPaaOpgave = 'To do'

--Opgave 06
SELECT statusPaaOpgave, COUNT(statusPaaOpgave) FROM opgave
GROUP BY statusPaaOpgave

--Opgave 07 A
SELECT projekt.projektnavn, COUNT(opgave.projektNr)
FROM projekt
LEFT JOIN opgave ON opgave.projektNr = projekt.projektNr
GROUP By projekt.projektnavn


--Opgave 07 B
SELECT projekt.projektnavn, (SELECT COUNT(opgave.opgaveNr) FROM opgave
WHERE projekt.projektNr = opgave.projektNr)	 
FROM Projekt

--Opgave 08
SELECT projekt.projektnavn, COUNT(opgave.projektNr)
FROM projekt
LEFT JOIN opgave ON opgave.projektNr = projekt.projektNr
GROUP By projekt.projektnavn
HAVING COUNT(opgave.projektNr) > 6


