DROP DATABASE IF EXISTS my_martini;

CREATE DATABASE my_martini DEFAULT CHARACTER SET = utf8;

USE my_martini;

CREATE TABLE tcontatti (
    id_contatti                 BIGINT              NOT NULL    AUTO_INCREMENT,
    nome                        VARCHAR(20)         NOT NULL,
    cognome                     VARCHAR(20)         NOT NULL,
    codice_fiscale              CHAR(16)            NOT NULL    UNIQUE,
    matricola                   CHAR(5)             NOT NULL    UNIQUE,
    data_nascita                DATE,
    ora_nascita                 TIME,    
    PRIMARY KEY(id_contatti)
) ENGINE = InnoDB;

DELIMITER /
CREATE TRIGGER trg_nome_cognome_insert
BEFORE INSERT ON tcontatti
FOR EACH ROW
    BEGIN
        IF CHAR_LENGTH(NEW.nome) < 3 AND CHAR_LENGTH(NEW.cognome) < 3 THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'entrambi';
        END IF;
        IF CHAR_LENGTH(NEW.nome) < 3 THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'nome';
        END IF;
        IF CHAR_LENGTH(NEW.cognome) < 3 THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'cognome';
        END IF;
    END /

--non lo usiamo
CREATE TRIGGER trg_nome_cognome_update
BEFORE UPDATE ON tcontatti
FOR EACH ROW
    BEGIN
        IF CHAR_LENGTH(NEW.nome) < 3 AND CHAR_LENGTH(NEW.cognome) < 3 THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'entrambi';
        END IF;
        IF CHAR_LENGTH(NEW.nome) < 3 THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'nome';
        END IF;
        IF CHAR_LENGTH(NEW.cognome) < 3 THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'cognome';
        END IF;
    END /




CREATE TRIGGER trg_data_nascita_insert
BEFORE INSERT ON tcontatti
FOR EACH ROW
    BEGIN
        IF NEW.data_nascita > CURDATE() THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'data';
        END IF;
    END /

--non lo usiamo
CREATE TRIGGER trg_data_nascita_update
BEFORE UPDATE ON tcontatti
FOR EACH ROW
    BEGIN
        IF NEW.data_nascita > CURDATE() THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'data';
        END IF;
    END /



CREATE TRIGGER trg_codice_fiscale_insert
BEFORE INSERT ON tcontatti
FOR EACH ROW
    BEGIN    
        IF NOT NEW.codice_fiscale REGEXP '^[a-zA-Z]{6}\\d{2}[a-zA-Z]\\d{2}[A-Z]\\d{3}[A-Z]$' THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'codice_fiscale';
        END IF;
    END /

--non lo usiamo
CREATE TRIGGER trg_codice_fiscale_update
BEFORE UPDATE ON tcontatti
FOR EACH ROW
    BEGIN    
        IF NOT NEW.codice_fiscale REGEXP '^[a-zA-Z]{6}\\d{2}[a-zA-Z]\\d{2}[A-Z]\\d{3}[A-Z]$' THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'codice_fiscale';
        END IF;
    END /



CREATE TRIGGER trg_matricola_insert
BEFORE INSERT ON tcontatti
FOR EACH ROW
    BEGIN    
        IF NOT NEW.matricola REGEXP '^[a-zA-Z]{2}\\d{3}$' THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'matricola';
        END IF;
    END /

--non lo usiamo
CREATE TRIGGER trg_matricola_update
BEFORE UPDATE ON tcontatti
FOR EACH ROW
    BEGIN    
        IF NOT NEW.matricola REGEXP '^[a-zA-Z]{2}\\d{3}$' THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'matricola';
        END IF;
    END /
DELIMITER ;