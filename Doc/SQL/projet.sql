#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: Client
#------------------------------------------------------------

CREATE TABLE Client(
        Id         int (11) Auto_increment  NOT NULL ,
        Nom        Varchar (100) NOT NULL ,
        Prenom     Varchar (100) NOT NULL ,
        Rue        Varchar (200) NOT NULL ,
        Complement Varchar (200) NOT NULL ,
        CP         Varchar (5) NOT NULL ,
        Ville      Varchar (200) NOT NULL ,
        Tel1       Varchar (12) NOT NULL ,
        Tel2       Varchar (12) NOT NULL ,
        Mail1      Varchar (200) NOT NULL ,
        Mail2      Varchar (200) NOT NULL ,
        PRIMARY KEY (Id )
)ENGINE=InnoDB;

