DROP DATABASE IF EXISTS my_martini;

CREATE DATABASE my_martini DEFAULT CHARACTER SET = utf8;

USE my_martini;

CREATE TABLE tcontatti (
    id_contatti                 BIGINT              NOT NULL    AUTO_INCREMENT,
    nome                        VARCHAR(20)         NOT NULL,
    cognome                     VARCHAR(20)         NOT NULL,
    codice_fiscale              CHAR(16)            NOT NULL    UNIQUE,
    data_nascita                DATE,
    ora_nascita                 TIME,    
    attivo                      BOOLEAN             DEFAULT	TRUE,
    CONSTRAINT chk_nome_cognome CHECK(CHAR_LENGTH(nome) >= 3 AND CHAR_LENGTH(cognome) >= 3),
    PRIMARY KEY(id_contatti),
    INDEX icontatti (nome, cognome)
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

CREATE TABLE toperatori (
    id_operatori                INT                 NOT NULL    AUTO_INCREMENT,
    nome                        VARCHAR(20),
    PRIMARY KEY(id_operatori),
    INDEX ioperatori (nome)
) ENGINE = InnoDB;

CREATE TABLE ttelefoni (
    id_telefoni                 BIGINT              NOT NULL    AUTO_INCREMENT,
    numero                      VARCHAR(20),
    tipo                        ENUM('P', 'C', 'L'), /* Personale - Casa - Lavoro */
    fk_contatti                 BIGINT              NOT NULL, /* NULL */
    fk_operatore                INT                 NOT NULL,
    PRIMARY KEY(id_telefoni),
    INDEX itelefoni (numero),
    FOREIGN KEY(fk_contatti) REFERENCES tcontatti(id_contatti)
        ON UPDATE CASCADE
	    ON DELETE CASCADE, /*SET NULL, RESTRICT oppure NO ACTION*/
    FOREIGN KEY(fk_operatore) REFERENCES toperatori(id_operatori)
        ON UPDATE CASCADE
        ON DELETE RESTRICT	    	
) ENGINE = InnoDB;