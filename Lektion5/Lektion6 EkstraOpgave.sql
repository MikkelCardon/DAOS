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