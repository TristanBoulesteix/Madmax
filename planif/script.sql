#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------

CREATE DATABASE madmax;

#------------------------------------------------------------
# Table: Utilistateur
#------------------------------------------------------------
SELECT madmax,
CREATE TABLE Utilistateur(
        ID       Int  Auto_increment  NOT NULL ,
        Login    Varchar (50) NOT NULL ,
        Password Varchar (5) NOT NULL
)ENGINE=InnoDB;
#------------------------------------------------------------
# Table: Dictionnaire
#------------------------------------------------------------
CREATE TABLE Dictionnaire(
        ID  Int  Auto_increment  NOT NULL ,
        Mot Varchar (50) NOT NULL
)ENGINE=InnoDB;

INSERT INTO Utilistateur(Login, Password) VALUES ("root", "Hello", "Admin", "Admin");

