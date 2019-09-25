#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------

CREATE DATABASE madmax;

#------------------------------------------------------------
# Table: Utilistateur
#------------------------------------------------------------
SELECT madmax,
CREATE TABLE Utilisateur(
        ID       Int  PRIMARY KEY  NOT NULL AUTO_INCREMENT,
        Login    Varchar (50) NOT NULL ,
        Password Varchar (5) NOT NULL
)ENGINE=InnoDB;
#------------------------------------------------------------
# Table: Dictionnaire
#------------------------------------------------------------
CREATE TABLE Dictionnaire(
        ID  Int  PRIMARY KEY  NOT NULL AUTO_INCREMENT,
        Mot Varchar (50) NOT NULL
)ENGINE=InnoDB;

INSERT INTO Utilisateur(Login, Password) VALUES ("root", "Hello"),("Admin", "Admin");

INSERT INTO Dictionnaire(Mot) VALUES ("trucc"),("Hello"),("password"),("patate");

