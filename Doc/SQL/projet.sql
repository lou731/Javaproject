#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------

#------------------------------------------------------------
# Table: Contacts
#------------------------------------------------------------

CREATE TABLE Contacts(
        Id         int (11) Auto_increment  NOT NULL ,
        Nom        Varchar (100) NOT NULL ,
        Prenom     Varchar (100) ,
        Rue        Varchar (200) ,
        Complement Varchar (200) ,
        CP         Varchar (5) ,
        Ville      Varchar (200) ,
        Tel1       Varchar (12) ,
        Tel2       Varchar (12) ,
        Mail1      Varchar (200) ,
        Mail2      Varchar (200) ,
        PRIMARY KEY (Id )
)ENGINE=InnoDB;

