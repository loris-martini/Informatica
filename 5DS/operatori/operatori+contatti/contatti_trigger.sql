DROP DATABASE IF EXISTS my_martini;

CREATE DATABASE my_martini DEFAULT CHARACTER SET = utf8;
USE my_martini;

CREATE TABLE tcontatti (
    id_contatti     BIGINT     NOT NULL AUTO_INCREMENT,
    nome            VARCHAR(20) NOT NULL,
    cognome         VARCHAR(20) NOT NULL,
    codice_fiscale  CHAR(16)    NOT NULL UNIQUE,
    matricola       CHAR(5)     NOT NULL UNIQUE,
    data_nascita    DATE,
    ora_nascita     TIME,    
    attivo          BOOLEAN     DEFAULT TRUE,
    PRIMARY KEY(id_contatti),
    INDEX icontatti (nome, cognome)
) ENGINE = InnoDB;


CREATE TABLE toperatori (
    id_operatori INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(20),
    PRIMARY KEY(id_operatori),
    INDEX ioperatori (nome)
) ENGINE = InnoDB;

CREATE TABLE ttelefoni (
    id_telefoni  BIGINT NOT NULL AUTO_INCREMENT,
    numero       VARCHAR(15),
    tipo         ENUM('P', 'C', 'L'), /* Personale - Casa - Lavoro */
    fk_contatti  BIGINT NOT NULL, 
    fk_operatore INT NOT NULL,
    PRIMARY KEY(id_telefoni),
    INDEX itelefoni (numero),
    FOREIGN KEY(fk_contatti) REFERENCES tcontatti(id_contatti) /* Integrità refernziale -> sono certo che la chiave primaria dell'altra tabella esiste veramente*/
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    FOREIGN KEY(fk_operatore) REFERENCES toperatori(id_operatori)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
) ENGINE = InnoDB;


DELIMITER $$

CREATE TRIGGER trg_nome_cognome_insert /*NOME*/
BEFORE INSERT ON tcontatti
FOR EACH ROW
BEGIN
    IF CHAR_LENGTH(NEW.nome) < 3 AND CHAR_LENGTH(NEW.cognome) < 3 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Errore 001: Contatto non inserito! Nome e cognome non validi';
    END IF;
    IF CHAR_LENGTH(NEW.nome) < 3 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Errore 002: Contatto non inserito! Cognome non valido';
    END IF;
    IF CHAR_LENGTH(NEW.cognome) < 3 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Errore 003: Contatto non inserito! Nome non valido';
    END IF;
END $$

CREATE TRIGGER trg_data_nascita_insert /*DATA*/
BEFORE INSERT ON tcontatti
FOR EACH ROW
BEGIN
    IF NEW.data_nascita > CURDATE() THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Errore 004: Contatto non inserito! Data di nascita non valida';
    END IF;
END $$

CREATE TRIGGER trg_codice_fiscale_insert /*CODICE FISCALE*/
BEFORE INSERT ON tcontatti
FOR EACH ROW
BEGIN    
    IF NOT NEW.codice_fiscale REGEXP '^[a-zA-Z]{6}[0-9]{2}[a-zA-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$' THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Errore 005: Contatto non inserito! Formato codice fiscale errato';
    END IF;
END $$

CREATE TRIGGER trg_matricola_insert /*MATRICOLA*/
BEFORE INSERT ON tcontatti
FOR EACH ROW
    BEGIN    
        IF NOT NEW.matricola REGEXP '^[a-zA-Z]{2}\\d{3}$' THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Errore 006: Contatto non inserito! Formato matricola errato';
        END IF;
    END $$

CREATE TRIGGER trg_numero_insert /*NUMERO*/
BEFORE INSERT ON ttelefoni
FOR EACH ROW
    BEGIN   
        IF NEW.numero NOT REGEXP '^[0-9]{10}$' THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Errore 007: Contatto non inserito! Formato numero di telefono errato';
        END IF;
    END $$     

DELIMITER ;
       