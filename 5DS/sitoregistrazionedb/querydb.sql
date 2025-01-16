DROP DATABASE IF EXISTS my_martini;

CREATE DATABASE my_martini DEFAULT CHARACTER SET = utf8;

USE my_martini;

CREATE TABLE taccount (
    nome                        VARCHAR(20)         NOT NULL,
    cognome                     VARCHAR(20)         NOT NULL,
    mail                        VARCHAR(40)         NOT NULL    UNIQUE,
    pass                        VARCHAR(20)         NOT NULL,
    data_nascita                DATE,  
 
    PRIMARY KEY(mail)
) ENGINE = InnoDB;