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
    CONSTRAINT chk_nome_cognome CHECK(CHAR_LENGTH(nome) >= 3 AND CHAR_LENGTH(cognome) >= 3),
    PRIMARY KEY(id_contatti),
    INDEX icontatti (nome, cognome)
) ENGINE = InnoDB;

DELIMITER $$

CREATE TRIGGER trg_nome_cognome_insert
BEFORE INSERT ON tcontatti
FOR EACH ROW
BEGIN
    IF CHAR_LENGTH(NEW.nome) < 3 AND CHAR_LENGTH(NEW.cognome) < 3 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Entrambi nome e cognome devono avere almeno 3 caratteri';
    END IF;
    IF CHAR_LENGTH(NEW.nome) < 3 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Il nome deve avere almeno 3 caratteri';
    END IF;
    IF CHAR_LENGTH(NEW.cognome) < 3 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Il cognome deve avere almeno 3 caratteri';
    END IF;
END $$

CREATE TRIGGER trg_data_nascita_insert
BEFORE INSERT ON tcontatti
FOR EACH ROW
BEGIN
    IF NEW.data_nascita > CURDATE() THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'La data di nascita non può essere nel futuro';
    END IF;
END $$

CREATE TRIGGER trg_codice_fiscale_insert
BEFORE INSERT ON tcontatti
FOR EACH ROW
BEGIN    
    IF NOT NEW.codice_fiscale REGEXP '^[a-zA-Z]{6}[0-9]{2}[a-zA-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$' THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Codice fiscale non valido';
    END IF;
END $$

CREATE TRIGGER trg_matricola_insert
BEFORE INSERT ON tcontatti
FOR EACH ROW
    BEGIN    
        IF NOT NEW.matricola REGEXP '^[a-zA-Z]{2}\\d{3}$' THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'matricola';
        END IF;
    END $$


CREATE TRIGGER trg_matricola_update
BEFORE UPDATE ON tcontatti
FOR EACH ROW
    BEGIN    
        IF NOT NEW.matricola REGEXP '^[a-zA-Z]{2}\\d{3}$' THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'matricola';
        END IF;
    END $$

DELIMITER ;

CREATE TABLE toperatori (
    id_operatori INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(20),
    PRIMARY KEY(id_operatori),
    INDEX ioperatori (nome)
) ENGINE = InnoDB;

CREATE TABLE ttelefoni (
    id_telefoni  BIGINT NOT NULL AUTO_INCREMENT,
    numero       VARCHAR(20),
    tipo         ENUM('P', 'C', 'L'), /* Personale - Casa - Lavoro */
    fk_contatti  BIGINT NULL, 
    fk_operatore INT NOT NULL,
    PRIMARY KEY(id_telefoni),
    INDEX itelefoni (numero),
    FOREIGN KEY(fk_contatti) REFERENCES tcontatti(id_contatti)
        ON UPDATE CASCADE
        ON DELETE SET NULL,
    FOREIGN KEY(fk_operatore) REFERENCES toperatori(id_operatori)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
) ENGINE = InnoDB;
