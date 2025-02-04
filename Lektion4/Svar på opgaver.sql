--Lektion 04 Opgave 01
SELECT COUNT(*) AS Antal_projekter FROM projekt

--Opgave 02
SELECT team.navn, count(*) FROM MedarbejderITeam
JOIN medarbejder ON MedarbejderITeam.medarbejderNr = Medarbejder.medarbejderNr
JOIN team ON team.teamId = MedarbejderITeam.teamId
GROUP BY team.navn
 
 --Opgave 03 A
 SELECT medarbejder.medarbejderNr, medarbejder.navn, AVG(DATEDIFF(MINUTE,Tidsregistrering.starttid,  tidsregistrering.sluttid)) FROM Medarbejder
 JOIN Tidsregistrering ON Tidsregistrering.medarbejderNr = Medarbejder.medarbejderNr
 GROUP BY medarbejder.medarbejderNr, medarbejder.navn

 --Opgave 03 B
 SELECT medarbejder.medarbejderNr,
  medarbejder.navn, 
 CONCAT(
	AVG(DATEDIFF(MINUTE,Tidsregistrering.starttid,  tidsregistrering.sluttid) / 60),
	':',
	AVG(DATEDIFF(MINUTE,Tidsregistrering.starttid,  tidsregistrering.sluttid) % 60)
 )
 FROM Medarbejder
 JOIN Tidsregistrering ON Tidsregistrering.medarbejderNr = Medarbejder.medarbejderNr
 GROUP BY medarbejder.medarbejderNr, medarbejder.navn

 --Opgave 04
 SELECT Opgavetype.navn, COUNT(opgave.beskrivelse) FROM Opgavetype
 JOIN Opgave ON opgave.opgavetypeId = opgavetype.opgavetypeId
 GROUP BY opgavetype.navn

 --opgave 05
 SELECT stillingsbetegnelse, COUNT(*) AS antal 
 FROM Medarbejder
 GROUP BY stillingsbetegnelse

 --opgave 06
 SELECT team.navn, COUNT(*) AS antalProjekter
 FROM team
 JOIN projekt ON projekt.teamId = team.teamId
 GROUP BY team.navn
 HAVING COUNT(*) > 3

 --opgave 07
 SELECT team.navn, SUM(projekt.estimeretTimer) FROM team
 JOIN Projekt ON projekt.teamId = team.teamId
 GROUP BY team.navn
 HAVING SUM(projekt.estimeretTimer) > 1000



