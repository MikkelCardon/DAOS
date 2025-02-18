SELECT medarbejder.navn, medarbejder.medarbejderNr, SUM(DATEDIFF(MINUTE, starttid, sluttid))
FROM Tidsregistrering
JOIN Medarbejder ON Medarbejder.medarbejderNr = Tidsregistrering.medarbejderNr
GROUP BY medarbejder.navn, medarbejder.medarbejderNr
