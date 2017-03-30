package carnetadresses.AccessDatas;

import carnetadresses.Models.Contact;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mysql.jdbc.*;
import java.sql.ResultSet;

/**
 * 
 */
public class AccesData implements IAccessData 
{
   private Connection connection = null;
   private PreparedStatement preparedStatment = null;
    
    /**
     * Default constructor
     * @throws java.sql.SQLException
     */
    public AccesData() throws SQLException 
    {    
       ResourceBundle bundle = ResourceBundle.getBundle("config");
       String url = bundle.getString("DB_URL");
       String user = bundle.getString("USER");
       String pwd = bundle.getString("PASS");
       this.connection = DataBaseUtils.CreateNewConnection(url, user, pwd);
    }
    
    /**
     * Constructor used for testing
     * @param connection builded connection
     */
    public AccesData(Connection connection)
    {
        this.connection = connection;
    }
    
   @Override
    protected void finalize() throws Throwable {
        try 
        {
            if(null != this.preparedStatment)
            {
                this.preparedStatment.close();
                System.out.println("Close preparedStatement...");
            }
            
            if(this.connection != null)
            {
                this.connection.close();
                this.connection = null;
                System.out.println("Close connection...");
            }
        } finally 
        {
            super.finalize();
        }
    }
    
    /**
     * Get a contact by id
     * @param id contact
     * @return contact found, null otherwise
     */
   @Override
    public Contact GetContact(long id)
    {
        Contact contact = null;
        if(null != this.connection)
        {
            String sql = "select * from contacts where id=?"; 
            try 
            {
                //préparation de la requête
                this.preparedStatment = (PreparedStatement)connection.prepareStatement(sql);
                this.preparedStatment.setLong(1, id);
                ResultSet result = preparedStatment.executeQuery();
                if (result != null && result.next()) 
                {
                    contact = this.FillContact(result);
                    System.out.println("Get contact with id=" + id);
                }                
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(AccesData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return contact;
    }

    /**
     * Get all contacts
     * @return list of all contacts
     */
    @Override
    public ArrayList<Contact> GetContacts() 
    {
        ArrayList<Contact> contacts = new ArrayList<>();
        if(null != this.connection)
        {
            String sql = "select * from contacts"; 
            try 
            {
                //préparation de la requête
                this.preparedStatment = (PreparedStatement)connection.prepareStatement(sql);
                ResultSet result = this.preparedStatment.executeQuery(sql);
                if (result != null) 
                {
                    while(result.next())
                    {
                        Contact contact = this.FillContact(result);
                        contacts.add(contact);
                    }
                } 
                
                System.out.println("Get contacts, count = " + contacts.size());
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(AccesData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return contacts;
    }
    
    /**
     * Search contacts
     * @param search, string to search in prenom or nom
     * @return List og found contacts
     */
   @Override
    public ArrayList<Contact> GetContacts(String search)
    {  
        ArrayList<Contact> contacts = new ArrayList<>();
        if(null != this.connection)
        {
            String sql = "select * from contacts where Nom like ? or Prenom like ?"; 
            try 
            {
                //préparation de la requête
                this.preparedStatment = (PreparedStatement)connection.prepareStatement(sql);
                String s = "%" + search + "%";
                this.preparedStatment.setString(1, s);
                this.preparedStatment.setString(2, s);
                ResultSet result = this.preparedStatment.executeQuery();
                if (result != null) 
                {
                    while(result.next())
                    {
                        Contact contact = this.FillContact(result);
                        contacts.add(contact);
                    }
                } 
                
                System.out.println("Get contacts for search = '" + search + "', count = " + contacts.size());
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(AccesData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return contacts;
}

    /**
     * Remove contact by its id
     * @param id contact
     * @return true if removed, false if error occurs
     */
    @Override
    public boolean SupressContact(long id) {
        if(null != this.connection)
        {
            String sql = "delete from contacts where id=?"; 
            try 
            {
                //préparation de la requête
                this.preparedStatment = (PreparedStatement)connection.prepareStatement(sql);
                this.preparedStatment.setLong(1, id);
                this.preparedStatment.executeUpdate();
                System.out.println("Delete with = '" + id + "', sucessfully");
                return true;
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(AccesData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return false;
    }

    /**
     * Modify specified contact
     * @param contact to modify
     * @return true if success, false otherwise
     */
    @Override
    public boolean ModifyContact(Contact contact) 
    {
        if(null != this.connection)
        {
            String sql = "UPDATE contacts SET Nom = ?, Prenom = ?, Rue = ?, Complement = ?," +
                         "CP = ?, Ville = ?, Tel1 = ?, Tel2 = ?, Mail1 = ?, Mail2 = ?" + 
                         " WHERE id= ? ";
            try 
            {
                //préparation de la requête
                this.preparedStatment = (PreparedStatement) connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                this.UpdatePrepareStatement(this.preparedStatment, contact, true);
                this.preparedStatment.executeUpdate();
                System.out.println("Updated with = 'Id = " + contact.getId() + "', sucessfully");
                return true;
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(AccesData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return false;
    }

    /**
     * Add new contact
     * @param contact to add
     * @return contact added with its id filled, null if error occurs
     */
    @Override
    public Contact AddContact(Contact contact) {
        Contact ret = null;
        if(null != this.connection)
        {
            String sql = "insert into contacts (Nom, Prenom, Rue, Complement, CP, Ville, Tel1, Tel2, Mail1, Mail2) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
            try 
            {
                //préparation de la requête
                this.preparedStatment = (PreparedStatement) connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                this.UpdatePrepareStatement(this.preparedStatment, contact, false);
                this.preparedStatment.executeUpdate();
                ResultSet rs = this.preparedStatment.getGeneratedKeys();
                if (rs != null && rs.next()) 
                {
                    long id = rs.getLong(1);
                    ret = this.GetContact(id);
                    System.out.println("Added with = 'Id = " + ret.getId() + "', sucessfully");
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(AccesData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return ret;
    }
     
    /**
     * Fill contact fileds
     * @param result of sql request
     * @return created contact
     * @throws SQLException 
     */
    private Contact FillContact(ResultSet result) throws SQLException
    {
        Contact contact = new Contact();
        contact.setId(result.getLong(1));
        contact.setNom(result.getString(2));
        contact.setPrenom(result.getString(3));
        contact.setRue(result.getString(4));
        contact.setComplement(result.getString(5));
        contact.setCp(result.getString(6));
        contact.setVille(result.getString(7));
        contact.setTel1(result.getString(8));
        contact.setTel2(result.getString(9));
        contact.setMail1(result.getString(10));
        contact.setMail2(result.getString(11));
        return contact;
    }
    
    /**
     * Fill preparedStatement with contact field
     * @param stmt preparestatement to fill
     * @param contact to inspect
     * @param withId true if id must be filled, false otherwise
     * @throws SQLException 
     */
    private void UpdatePrepareStatement(PreparedStatement stmt, Contact contact, boolean withId) throws SQLException 
    {
        stmt.setString(1, contact.getNom());
        stmt.setString(2, contact.getPrenom());
        stmt.setString(3, contact.getRue());
        stmt.setString(4, contact.getComplement());
        stmt.setString(5, contact.getCp());
        stmt.setString(6, contact.getVille());
        stmt.setString(7, contact.getTel1());
        stmt.setString(8, contact.getTel2());
        stmt.setString(9, contact.getMail1());
        stmt.setString(10, contact.getMail2());
        if(withId)
        {
            stmt.setLong(11, contact.getId());
        }
    }
}