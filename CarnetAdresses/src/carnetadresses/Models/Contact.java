package carnetadresses.Models;

/**
 * Model for contact
 */
public class Contact implements Cloneable{

    private long id;
    /**
     * 
     */
    private String nom;

    /**
     * 
     */
    private String prenom;

    /**
     * 
     */
    private String rue;

    /**
     * 
     */
    private String complement;

    /**
     * 
     */
    private String cp;

    /**
     * 
     */
    private String ville;

    /**
     * 
     */
    private String tel1;

    /**
     * 
     */
    private String tel2;

    /**
     * 
     */
    private String mail1;

    /**
     * 
     */
    private String mail2;
    
    /**
     * Default constructor
     */
    public Contact() {
    }

    

    /**
     * @return contact name
     */
    public String getNom() {
        // TODO implement here
        return this.nom;
    }

    /**
     * @param value contact name
     */
    public void setNom(String value) {
        this.nom = value;
    }

    /**
     * @return contact prenom
     */
    public String getPrenom() {
        return this.prenom;
    }

    /**
     * @param value precnom contact
     */
    public void setPrenom(String value) {
        this.prenom = value;
    }

    /**
     * @return contact rue
     */
    public String getRue() {
        return this.rue;
    }

    /**
     * @param value contact rue
     */
    public void setRue(String value) {
        this.rue = value;
    }

    /**
     * @return contact complement 
     */
    public String getComplement() {
        return this.complement;
    }

    /**
     * @param value contact complement
     */
    public void setComplement(String value) {
        this.complement = value;
    }

    /**
     * @return contact cp
     */
    public String getCp() {
        return this.cp;
    }

    /**
     * @param value contact cp
     */
    public void setCp(String value) {
        this.cp = value;
    }

    /**
     * @return contact ville
     */
    public String getVille() {
        return this.ville;
    }

    /**
     * @param value contact ville
     */
    public void setVille(String value) {
        this.ville = value;
    }

    /**
     * @return contact tel1
     */
    public String getTel1() {
        return this.tel1;
    }

    /**
     * @param value cintact tel1
     */
    public void setTel1(String value) {
        this.tel1 = value;
    }

    /**
     * @return contact tel2
     */
    public String getTel2() {
        return this.tel2;
    }

    /**
     * @param value contact tel2
     */
    public void setTel2(String value) {
        this.tel2 = value;
    }

    /**
     * @return contact mail1
     */
    public String getMail1() {
        return this.mail1;
    }

    /**
     * @param value contact mail1
     */
    public void setMail1(String value) {
        this.mail1 = value;
    }

    /**
     * @return contact mail2
     */
    public String getMail2() {
        return this.mail2;
    }

    /**
     * @param value contact mail2
     */
    public void setMail2(String value) {
        this.mail2 = value;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }
    
    /**
     * clone the current object.
     * @return cloned object
     * @throws java.lang.CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException 
    {
        Object o = null;
        try 
        {
            // On récupère l'instance à renvoyer par l'appel de la 
            // méthode super.clone()
            o = super.clone();
        } catch(CloneNotSupportedException cnse) 
        {
                // Ne devrait jamais arriver car nous implémentons 
                // l'interface Cloneable
                cnse.printStackTrace(System.err);
        }
        // on renvoie le clone
        return o;
    }
}