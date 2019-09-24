#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: Utilistateur
#------------------------------------------------------------

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

