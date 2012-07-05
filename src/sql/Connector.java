/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

/**
 * This is the abstract - interface wrapper class for the different types of
 * Database Connectors
 * @author Alex Hughes
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import phoneHughes.Credentials;

public abstract class Connector {
    
    protected static Connection connection;
    protected Credentials credentials;
    
    protected java.util.Properties connProperties;
    protected static final String DATABASE_USER = "user";
    protected static final String DATABASE_PASSWORD = "password";
    
    public Connector(Credentials cre) throws SQLException, ClassNotFoundException {
        credentials = cre;
        reConnect();
    }
    
    public void reConnect() throws SQLException, ClassNotFoundException {
        
        connProperties = new java.util.Properties();
        connProperties.put(DATABASE_USER, credentials.getUsername());
        connProperties.put(DATABASE_PASSWORD, credentials.getPassword());
        
        connection = DriverManager.getConnection(credentials.getURL(), connProperties);
        printInfo();
    }
    
    public ResultSet sendQuery(String aQuery) throws SQLException {
        ResultSet rs = null;      
        return rs;
    }
    
    public int sendUpdate(String aQuery) throws SQLException {
        return 0;
    }
    
    public void setSchema(String aSchema) throws SQLException {
        
    }
    
    protected void printInfo() {
        System.out.println("Database Management...");
        System.out.println("Succesfully connected to: " + credentials.getURL());
    }
    
    
    public void closeConnection() throws SQLException {
        connection.close();
    }
    
    public Credentials getCredentials(){
        return credentials;
    }
    
}
