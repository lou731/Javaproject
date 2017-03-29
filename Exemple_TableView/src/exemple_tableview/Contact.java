/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemple_tableview;

/**
 *
 * @author Unkof
 */
public class Contact
    {
         private String nom;
         private String prenom;
         
         public Contact(String nom, String prenom)
             {
                 this.nom=nom;
                 this.prenom=prenom;
             }
         
         public String getNom()
             {
                return this.nom;
             }
         
         public String getPrenom()
             {
                return this.prenom;
             }
         
         public void setNom(String nom)
             {
                 this.nom=nom;
             }
         
         public void setPrenom(String prenom)
             {
                 this.prenom=prenom;
             }
         
    }
