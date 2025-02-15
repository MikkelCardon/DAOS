--Opgave 04 CALL STORED PROC FROM JAVA PROGRAM
CREATE PROC navnOgTelefon
AS
SELECT navn, mobil FROM medarbejder

EXEC navnOgTelefon

--Opgave 05
SELECT COUNT(*) FROM Medarbejder
SELECT * FROM Medarbejder


