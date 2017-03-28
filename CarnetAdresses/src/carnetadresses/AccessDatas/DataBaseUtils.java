package carnetadresses.AccessDatas;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mamar
 */
public class DataBaseUtils {
    
    private static final String userTest = "jp_user";
    private static final String mdpTest = "jp_user";
    private static final String urlTest = "jdbc:mysql://localhost/";
    private static final String dbNameTest = "javaprojecttest";
        
    public static Connection CreateDatabaseTest() throws SQLException
    {
        Connection connection = null;
        Statement stmt = null;
        try 
        {
            connection = DataBaseUtils.CreateNewConnection(DataBaseUtils.urlTest, DataBaseUtils.userTest, DataBaseUtils.mdpTest);
             stmt = connection.createStatement();
            
            String st = String.format("DROP DATABASE IF EXISTS %s", DataBaseUtils.dbNameTest);
            boolean ret = false;
            /* Exécution d'une requête de lecture */
            int executeUpdate = stmt.executeUpdate(st);
            System.out.println("Database droped successfully...");
            
            System.out.println("Creating database...");
            st = String.format("CREATE DATABASE %s DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;", DataBaseUtils.dbNameTest);
            executeUpdate = stmt.executeUpdate(st);
            stmt.close();
            connection.close();
            
            connection = DataBaseUtils.CreateNewConnection(DataBaseUtils.urlTest + DataBaseUtils.dbNameTest, DataBaseUtils.userTest, DataBaseUtils.mdpTest);
            stmt = connection.createStatement();
            String sql = "CREATE TABLE Contacts(\n" +
"        Id         int (11) Auto_increment  NOT NULL ,\n" +
"        Nom        Varchar (100) NOT NULL ,\n" +
"        Prenom     Varchar (100) ,\n" +
"        Rue        Varchar (200) ,\n" +
"        Complement Varchar (200) ,\n" +
"        CP         Varchar (5) ,\n" +
"        Ville      Varchar (200) ,\n" +
"        Tel1       Varchar (12) ,\n" +
"        Tel2       Varchar (12) ,\n" +
"        Mail1      Varchar (200) ,\n" +
"        Mail2      Varchar (200) ,\n" +
"        PRIMARY KEY (Id )\n" +
")ENGINE=InnoDB;";
            
            executeUpdate = stmt.executeUpdate(sql);
            
        } 
        catch (SQLException sQLException) 
        {
            System.out.println(sQLException.getMessage());
            throw  sQLException;
        }
        finally
        {
            if(stmt != null)
            {
                try
                {
                    stmt.close();
                }
                catch(SQLException ex)
                {}
            }
        }
        
        return connection;
    }
    
    public static Connection CreateNewConnection(String urldb, String user, String pwd)
    {
        Connection connection = null;
        try
        {
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(urldb, user, pwd);
        }catch(SQLException se)
        {
           //Handle errors for JDBC
           se.printStackTrace();
        }
       catch(Exception e){
           //Handle errors for Class.forName
           e.printStackTrace();
        }

        return connection;
    }
}
