--EKSTRA OPGAVE

--Løst med JOINS og GROUP BY
SELECT hold.holdNavn, MIN(medlem.alder) AS minAlder
FROM hold
JOIN HoldMedlem ON HoldMedlem.holdId = hold.holdId
JOIN Medlem ON HoldMedlem.medlemsId = Medlem.medlemsId
GROUP BY hold.holdNavn;


--Løst med subquery
SELECT hold.holdnavn,
(SELECT MIN(alder) FROM HoldMedlem
JOIN medlem ON medlem.medlemsId = HoldMedlem.medlemsId
WHERE hold.holdId = HoldMedlem.holdId)
FROM hold

CREATE VIEW AlleMedlemMedHold 
AS
SELECT medlem.navn, medlem.alder, hold.holdNavn FROM HoldMedlem
JOIN medlem ON medlem.medlemsId = HoldMedlem.medlemsId
JOIN hold ON hold.holdId = HoldMedlem.holdId


CREATE PROC yngsteMedlemPaaHold
AS 
@holdNavn VARCHAR(30)
BEGIN 
SELECT holdnavn,
(SELECT MIN(alder) FROM HoldMedlem
JOIN medlem ON medlem.medlemsId = HoldMedlem.medlemsId
WHERE (SELECT holdId FROM hold WHERE holdNavn = @holdNavn) = HoldMedlem.holdId) 
FROM holdmedlem

CREATE PROC yngsteMedlemPaaHold
@holdId VARCHAR(30)
AS 
BEGIN 
SELECT TOP 1 @holdId AS holdId,
(SELECT MIN(alder) FROM HoldMedlem
JOIN medlem ON medlem.medlemsId = HoldMedlem.medlemsId
WHERE @holdId = HoldMedlem.holdId) AS yngste 
FROM holdmedlem
END

CREATE PROC yngsteMedlemPaaHold2
@holdId VARCHAR(30)
@samlet int output
AS 
BEGIN 
SELECT TOP 1 @holdId AS holdId,
(SELECT MIN(alder) FROM HoldMedlem
JOIN medlem ON medlem.medlemsId = HoldMedlem.medlemsId
WHERE @holdId = HoldMedlem.holdId) AS yngste 
FROM holdmedlem
END
GO 
DECLARE @samlet int
execute yngsteMedlemPaaHold2 @samlet output
SELECT @samlet as samlet

DROP PROC yngsteMedlemPaaHold

EXEC yngsteMedlemPaaHold '2'

 