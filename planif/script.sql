#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------

#------------------------------------------------------------
# Database: madmax
#------------------------------------------------------------

DROP DATABASE IF EXISTS madmax;
CREATE DATABASE IF NOT EXISTS madmax CHARACTER SET UTF8 collate utf8_bin;

#------------------------------------------------------------
# Table: Utilistateur
#------------------------------------------------------------

CREATE TABLE IF NOT EXISTS madmax.Utilisateur
(
    ID       Int  PRIMARY KEY  NOT NULL AUTO_INCREMENT,
    Login    Varchar (50) NOT NULL ,
    Password Varchar (5) NOT NULL
)
ENGINE=InnoDB;

#------------------------------------------------------------
# Table: Dictionnaire
#------------------------------------------------------------

CREATE TABLE IF NOT EXISTS madmax.Dictionnaire
(
    ID  Int  PRIMARY KEY  NOT NULL AUTO_INCREMENT,
    Mot Varchar (50) NOT NULL
)
ENGINE=InnoDB;

INSERT INTO madmax.Utilisateur(Login, Password) 
	VALUES 
	("root", "Hello"),
	("Admin", "Admin");

INSERT INTO madmax.Dictionnaire(Mot) 
	VALUES 
	("trucc"),
	("Hello"),
	("password"),
	("patate");