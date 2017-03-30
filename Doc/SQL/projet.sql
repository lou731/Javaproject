#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------

#------------------------------------------------------------
# Table: Contacts
#------------------------------------------------------------

CREATE TABLE Contacts(
        Id         int (11) Auto_increment  NOT NULL ,
        Nom        Varchar (30) NOT NULL ,
        Prenom     Varchar (30) ,
        Rue        Varchar (50) ,
        Complement Varchar (50) ,
        CP         Varchar (5) ,
        Ville      Varchar (50) ,
        Tel1       Varchar (12) ,
        Tel2       Varchar (12) ,
        Mail1      Varchar (50) ,
        Mail2      Varchar (50) ,
        PRIMARY KEY (Id )
)ENGINE=InnoDB;

