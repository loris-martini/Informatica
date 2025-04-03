DROP DATABASE IF EXISTS ConcertiDB;

CREATE DATABASE ConcertiDB;
USE ConcertiDB;

CREATE TABLE GRUPPO (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(100) NOT NULL UNIQUE,
    AnnoFondazione INT NOT NULL
);

CREATE TABLE ESECUTORE (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Nominativo VARCHAR(100) NOT NULL,
    Nazionalità VARCHAR(50) NOT NULL,
    Compenso DECIMAL(10,2) NOT NULL CHECK (Compenso >= 0)
);

CREATE TABLE LUOGO (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(100) NOT NULL,
    Citta VARCHAR(100) NOT NULL,
    Nazione VARCHAR(100) NOT NULL
);

CREATE TABLE ESIBIZIONE (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Data DATE NOT NULL,
    Luogo INT NOT NULL,
    NumSpettatori INT NOT NULL CHECK (NumSpettatori >= 0),
    FOREIGN KEY (Luogo) REFERENCES LUOGO(ID)
    ON UPDATE CASCADE 
    ON DELETE RESTRICT
);

CREATE TABLE GRUPPO_ESECUTORE (
    IDGruppo INT NOT NULL,
    IDEsecutore INT NOT NULL,
    PRIMARY KEY (IDGruppo, IDEsecutore),
    FOREIGN KEY (IDGruppo) REFERENCES GRUPPO(ID)
    ON UPDATE CASCADE 
    ON DELETE CASCADE,
    FOREIGN KEY (IDEsecutore) REFERENCES ESECUTORE(ID) 
    ON UPDATE CASCADE 
    ON DELETE CASCADE
);

CREATE TABLE GRUPPO_ESIBIZIONE (
    IDGruppo INT NOT NULL,
    IDEsibizione INT NOT NULL,
    PRIMARY KEY (IDGruppo, IDEsibizione),
    FOREIGN KEY (IDGruppo) REFERENCES GRUPPO(ID)
    ON UPDATE CASCADE 
    ON DELETE CASCADE,
    FOREIGN KEY (IDEsibizione) REFERENCES ESIBIZIONE(ID) 
    ON UPDATE CASCADE 
    ON DELETE CASCADE
);


/*1 DDL aggirnato con 2 DDL
INSERT INTO GRUPPO (Nome, AnnoFondazione) VALUES ('Queen', 1970), ('The Beatles', 1960);
INSERT INTO ESECUTORE (Nominativo, Nazionalità, Compenso, AnnoNascita) VALUES ('Freddie Mercury', 'UK', 50000, 1960), ('John Lennon', 'UK', 60000, 1950);
INSERT INTO LUOGO (Nome, Citta, Nazione) VALUES ('Wembley Stadium', 'Londra', 'Regno Unito'), ('Madison Square Garden', 'New York', 'USA');
INSERT INTO ESIBIZIONE (Data, Luogo, Spettatori, Nome) VALUES ('1985-07-13', 1, 72000, 'Sagra dei Negri'), ('1969-08-15', 2, 50000, 'Sagra della Salsiccia');

INSERT INTO GRUPPO_ESECUTORE (IDGruppo, IDEsecutore) VALUES (1, 1), (2, 2);
INSERT INTO GRUPPO_ESIBIZIONE (IDGruppo, IDEsibizione) VALUES (1, 1), (2, 2);

*/
/*2 DDL*/
ALTER TABLE ESIBIZIONE DROP FOREIGN KEY esibizione_ibfk_1;
ALTER TABLE ESIBIZIONE DROP COLUMN Luogo;

/*1*/
SHOW CREATE TABLE ESIBIZIONE;
ALTER TABLE ESIBIZIONE ADD COLUMN Luogo INT NOT NULL;
ALTER TABLE ESIBIZIONE ADD CONSTRAINT esibizione_ibfk_1
FOREIGN KEY (Luogo) REFERENCES LUOGO(ID)
ON UPDATE CASCADE
ON DELETE RESTRICT;

/*2*/
ALTER TABLE ESIBIZIONE 
ADD COLUMN Nome VARCHAR(50) NOT NULL;

/*3*/
ALTER TABLE ESECUTORE 
ADD COLUMN AnnoNascita INT NOT NULL;

/*4*/
ALTER TABLE ESIBIZIONE
CHANGE COLUMN NumSpettatori Spettatori INT NOT NULL CHECK (Spettatori >= 0);

/*5*/
ALTER TABLE ESIBIZIONE 
ADD CONSTRAINT Nome_Unique UNIQUE (Nome, Data);

/*6*/
ALTER TABLE GRUPPO
ADD CONSTRAINT NomeGruppo_Unique UNIQUE (Nome);

/*7*/
ALTER TABLE ESECUTORE
MODIFY COLUMN Nominativo VARCHAR(70) NOT NULL;

/*INSERT A CASO*/
-- Inserimento dati nella tabella GRUPPO
INSERT INTO GRUPPO (Nome, AnnoFondazione) VALUES
('Queen', 1970),
('The Beatles', 1960),
('Pink Floyd', 1965),
('Led Zeppelin', 1968),
('U2', 1976),
('Coldplay', 1996),
('The Rolling Stones', 1962),
('Nirvana', 1987),
('Måneskin', 2016),
('Negramaro', 2000),
('Subsonica', 1996);

-- Inserimento dati nella tabella ESECUTORE
INSERT INTO ESECUTORE (Nominativo, Nazionalità, Compenso, AnnoNascita) VALUES
('Freddie Mercury', 'UK', 50000, 1946),
('John Lennon', 'UK', 60000, 1940),
('David Gilmour', 'UK', 55000, 1946),
('Robert Plant', 'UK', 58000, 1948),
('Bono', 'Ireland', 62000, 1960),
('Chris Martin', 'UK', 65000, 1977),
('Mick Jagger', 'UK', 70000, 1943),
('Kurt Cobain', 'USA', 75000, 1967),
('Damiano David', 'Italia', 70000, 1999),
('Victoria De Angelis', 'Italia', 70000, 2000),
('Thomas Raggi', 'Italia', 70000, 2001),
('Ethan Torchio', 'Italia', 70000, 2000),
('Giuliano Sangiorgi', 'Italia', 60000, 1979),
('Emanuele Spedicato', 'Italia', 60000, 1980),
('Andrea Mariano', 'Italia', 60000, 1978),
('Samuel Umberto Romano', 'Italia', 65000, 1972),
('Massimiliano Casacci', 'Italia', 65000, 1969),
('Enrico Matta', 'Italia', 65000, 1971);

-- Inserimento dati nella tabella LUOGO
INSERT INTO LUOGO (Nome, Citta, Nazione) VALUES
('Wembley Stadium', 'Londra', 'Regno Unito'),
('Madison Square Garden', 'New York', 'USA'),
('San Siro', 'Milano', 'Italia'),
('Tokyo Dome', 'Tokyo', 'Giappone'),
('Stade de France', 'Parigi', 'Francia'),
('O2 Arena', 'Londra', 'Regno Unito'),
('Hollywood Bowl', 'Los Angeles', 'USA'),
('Sydney Opera House', 'Sydney', 'Australia'),
('Arena di Verona', 'Verona', 'Italia'),
('Stadio Olimpico', 'Roma', 'Italia'),
('Mediolanum Forum', 'Milano', 'Italia');

-- Inserimento dati nella tabella ESIBIZIONE
INSERT INTO ESIBIZIONE (Data, Luogo, Spettatori, Nome) VALUES
('1985-07-13', 1, 72000, 'Live Aid'),
('1969-08-15', 2, 50000, 'Woodstock'),
('1994-10-29', 3, 80000, 'Division Bell Tour'),
('1975-05-25', 4, 55000, 'Physical Graffiti Tour'),
('2001-07-21', 5, 90000, 'Elevation Tour'),
('2012-06-10', 6, 20000, 'Mylo Xyloto Tour'),
('1981-10-18', 7, 18000, 'Tattoo You Tour'),
('1992-08-30', 8, 40000, 'Nevermind Tour'),
('2021-07-01', 9, 12000, 'Måneskin Live Verona'),
('2022-06-15', 10, 50000, 'Måneskin Rock in Roma'),
('2018-03-05', 11, 15000, 'Negramaro Amore Che Torni Tour'),
('2019-07-10', 9, 13000, 'Negramaro Live in Verona'),
('2019-02-09', 11, 11000, 'Subsonica 8 Tour Milano'),
('2020-01-25', 10, 45000, 'Subsonica Rock in Roma');

-- Inserimento dati nella tabella GRUPPO_ESECUTORE
INSERT INTO GRUPPO_ESECUTORE (IDGruppo, IDEsecutore) VALUES
(1, 1), (2, 2), (3, 3), (4, 4), (5, 5), (6, 6), (7, 7), (8, 8),
(9, 9), (9, 10), (9, 11), (9, 12),
(10, 13), (10, 14), (10, 15),
(11, 16), (11, 17), (11, 18);

-- Inserimento dati nella tabella GRUPPO_ESIBIZIONE
INSERT INTO GRUPPO_ESIBIZIONE (IDGruppo, IDEsibizione) VALUES
(1, 1), (2, 2), (3, 3), (4, 4), (5, 5), (6, 6), (7, 7), (8, 8),
(9, 9), (9, 10), (10, 11), (10, 12), (11, 13), (11, 14);

