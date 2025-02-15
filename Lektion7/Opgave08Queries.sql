--Opgave 08

CREATE TABLE TESTTYPE(
type_char CHAR(10),
type_varchar VARCHAR(30),
type_int INT,
type_decimal DECIMAL(8,2),
type_date DATE,
type_bit BIT
)

INSERT INTO TESTTYPE VALUES
('11223344', 'VARCHAR TYPE', 1, 12.34, '2025-02-14', 0)

SELECT * FROM TESTTYPE