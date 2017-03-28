package carnetadresses.Models;

/**
 * Model for contact
 */
public class Contact {

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
     * @return
     */
    public String getNom() {
        // TODO implement here
        return this.nom;
    }

    /**
     * @param value
     */
    public void setNom(String value) {
        this.nom = value;
    }

    /**
     * @return
     */
    public String getPrenom() {
        return this.prenom;
    }

    /**
     * @param value
     */
    public void setPrenom(String value) {
        this.prenom = value;
    }

    /**
     * @return
     */
    public String getRue() {
        return this.rue;
    }

    /**
     * @param value
     */
    public void setRue(String value) {
        this.rue = value;
    }

    /**
     * @return
     */
    public String getComplement() {
        return this.complement;
    }

    /**
     * @param value
     */
    public void setComplement(String value) {
        this.complement = value;
    }

    /**
     * @return
     */
    public String getCp() {
        return this.cp;
    }

    /**
     * @param value
     */
    public void setCp(String value) {
        this.cp = value;
    }

    /**
     * @return
     */
    public String getVille() {
        return this.ville;
    }

    /**
     * @param value
     */
    public void setVille(String value) {
        this.ville = value;
    }

    /**
     * @return
     */
    public String getTel1() {
        return this.tel1;
    }

    /**
     * @param value
     */
    public void setTel1(String value) {
        this.tel1 = value;
    }

    /**
     * @return
     */
    public String getTel2() {
        return this.tel2;
    }

    /**
     * @param value
     */
    public void setTel2(String value) {
        this.tel2 = value;
    }

    /**
     * @return
     */
    public String getMail1() {
        return this.mail1;
    }

    /**
     * @param value
     */
    public void setMail1(String value) {
        this.mail1 = value;
    }

    /**
     * @return
     */
    public String getMail2() {
        return this.mail2;
    }

    /**
     * @param value
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

}