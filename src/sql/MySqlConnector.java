/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

/**
 *
 * @author Alex Hughes
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import phoneHughes.Credentials;

public class MySqlConnector extends Connector {

    private static final String MYSQL_AUTO_RECONNECT = "autoReconnect";
    private static final String MYSQL_MAX_RECONNECTS = "maxReconnects";

    public MySqlConnector(Credentials cre) throws SQLException, ClassNotFoundException {
        super(cre);
    }
    
    @Override
    public void reConnect() throws SQLException, ClassNotFoundException {
        
        if (connection != null) {
            connection.close();
        }
        
        Class.forName("com.mysql.jdbc.Driver");	//in order to manipulate data on the mySQL server
        super.reConnect();
        
        super.connProperties.put(MYSQL_AUTO_RECONNECT, "true");
        super.connProperties.put(MYSQL_MAX_RECONNECTS, "2");
        super.connProperties.put("characterEncoding", "utf8");

        printInfo();    //used to print info of the connection
    }

    @Override
    public ResultSet sendQuery(String aQuery) throws SQLException {
        ResultSet rs = null;
        
        Statement stmt;
        
        if (connection.isValid(0)) {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(aQuery);
        } else {
            try {
                reConnect();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MySqlConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
            stmt = connection.createStatement();
            rs = stmt.executeQuery(aQuery);
        }
        System.out.println(aQuery);
        return rs;
    }
    
    @Override
    public int sendUpdate(String aQuery) throws SQLException {
        Statement stmt;

        if (connection.isValid(1)) {
            stmt = connection.createStatement();
        } else {
            try {
                reConnect();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MySqlConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
            stmt = connection.createStatement();
        }
        System.out.println(aQuery);
        return stmt.executeUpdate(aQuery);
    }

    @Override
    public void setSchema(String aSchema) throws SQLException {
        connection.setSchema(aSchema);
    }

    @Override
    protected void printInfo() {
        System.out.println("The database type is MySQL");
    }
}
