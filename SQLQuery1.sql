DROP TABLE DataEks;

CREATE TABLE DataEks(
id INT PRIMARY KEY,
kommatal DECIMAL(6,2),
navn VARCHAR(20),
dato DATE DEFAULT getDate(),
kort char(8) CHECK(KORT IN('klør', 'spar', 'ruder', 'hjerter'))
)


INSERT INTO DataEks(id, kommatal, navn, kort) VALUES
(4, 4000.5, 'Ole', 'spar')

SELECT * FROM DataEks





