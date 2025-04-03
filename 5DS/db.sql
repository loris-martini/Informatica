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
('Nirvana', 1987);

-- Inserimento dati nella tabella ESECUTORE
INSERT INTO ESECUTORE (Nominativo, Nazionalità, Compenso, AnnoNascita) VALUES
('Freddie Mercury', 'UK', 50000, 1946),
('Brian May', 'UK', 48000, 1947),
('Roger Taylor', 'UK', 46000, 1949),
('John Deacon', 'UK', 45000, 1951),
('John Lennon', 'UK', 60000, 1940),
('Paul McCartney', 'UK', 59000, 1942),
('George Harrison', 'UK', 58000, 1943),
('Ringo Starr', 'UK', 57000, 1940),
('David Gilmour', 'UK', 55000, 1946),
('Roger Waters', 'UK', 54000, 1943),
('Richard Wright', 'UK', 53000, 1943),
('Nick Mason', 'UK', 52000, 1944),
('Robert Plant', 'UK', 58000, 1948),
('Jimmy Page', 'UK', 57000, 1944),
('John Paul Jones', 'UK', 56000, 1946),
('Bono', 'Ireland', 62000, 1960),
('The Edge', 'Ireland', 61000, 1961),
('Adam Clayton', 'Ireland', 60000, 1960),
('Larry Mullen Jr.', 'Ireland', 59000, 1961),
('Chris Martin', 'UK', 65000, 1977),
('Jonny Buckland', 'UK', 64000, 1977),
('Guy Berryman', 'UK', 63000, 1978),
('Will Champion', 'UK', 62000, 1978),
('Mick Jagger', 'UK', 70000, 1943),
('Keith Richards', 'UK', 69000, 1943),
('Charlie Watts', 'UK', 68000, 1941),
('Ronnie Wood', 'UK', 67000, 1947),
('Kurt Cobain', 'USA', 75000, 1967),
('Krist Novoselic', 'USA', 74000, 1965),
('Dave Grohl', 'USA', 73000, 1969);

-- Inserimento dati nella tabella LUOGO
INSERT INTO LUOGO (Nome, Citta, Nazione) VALUES
('Wembley Stadium', 'Londra', 'Regno Unito'),
('Madison Square Garden', 'New York', 'USA'),
('San Siro', 'Milano', 'Italia'),
('Tokyo Dome', 'Tokyo', 'Giappone'),
('Stade de France', 'Parigi', 'Francia'),
('O2 Arena', 'Londra', 'Regno Unito'),
('Hollywood Bowl', 'Los Angeles', 'USA'),
('Sydney Opera House', 'Sydney', 'Australia');

-- Inserimento dati nella tabella ESIBIZIONE
INSERT INTO ESIBIZIONE (Data, Luogo, Spettatori, Nome) VALUES
('1985-07-13', 1, 72000, 'Live Aid'),
('1986-07-12', 1, 70000, 'Magic Tour'),
('1974-05-01', 1, 60000, 'Sheer Heart Attack Tour'),
('1969-08-15', 2, 50000, 'Woodstock'),
('1966-08-29', 2, 55000, 'Last Concert'),
('1965-08-15', 2, 56000, 'Shea Stadium Concert'),
('1994-10-29', 3, 80000, 'Division Bell Tour'),
('1973-03-01', 3, 75000, 'Dark Side of the Moon Tour'),
('1987-09-11', 3, 78000, 'A Momentary Lapse of Reason Tour'),
('1975-05-25', 4, 55000, 'Physical Graffiti Tour'),
('1971-03-05', 4, 50000, 'Led Zeppelin IV Tour'),
('1969-01-31', 4, 52000, 'Early Days Tour'),
('2001-07-21', 5, 90000, 'Elevation Tour'),
('1997-08-15', 5, 88000, 'PopMart Tour'),
('2017-07-22', 5, 92000, 'Joshua Tree Tour'),
('2012-06-10', 6, 20000, 'Mylo Xyloto Tour'),
('2016-07-06', 6, 25000, 'A Head Full of Dreams Tour'),
('2008-09-20', 6, 22000, 'Viva la Vida Tour');

-- Inserimento dati nella tabella GRUPPO_ESECUTORE
INSERT INTO GRUPPO_ESECUTORE (IDGruppo, IDEsecutore) VALUES
(1, 1), (1, 2), (1, 3), (1, 4),
(2, 5), (2, 6), (2, 7), (2, 8),
(3, 9), (3, 10), (3, 11), (3, 12),
(4, 13), (4, 14), (4, 15),
(5, 16), (5, 17), (5, 18), (5, 19),
(6, 20), (6, 21), (6, 22), (6, 23),
(7, 24), (7, 25), (7, 26), (7, 27),
(8, 28), (8, 29), (8, 30);

-- Inserimento dati nella tabella GRUPPO_ESIBIZIONE
INSERT INTO GRUPPO_ESIBIZIONE (IDGruppo, IDEsibizione) VALUES
(1, 1), (1, 2), (1, 3),
(2, 4), (2, 5), (2, 6),
(3, 7), (3, 8), (3, 9),
(4, 10), (4, 11), (4, 12),
(5, 13), (5, 14), (5, 15),
(6, 16), (6, 17), (6, 18);

