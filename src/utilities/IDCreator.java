/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.sql.*;
import sql.Connector;
import sql.MySqlConnector;

/**
 *
 * @author Alex Hughes
 */
public class IDCreator {

    public static int createID(Connector aConnector, String aTableName) throws SQLException {
        int id = -1;
        
        ResultSet idR = aConnector.sendQuery(""
                + "SELECT MAX(" + aTableName + "ID) "
                + "FROM " + aTableName);
        
        while(idR.next())
            id = idR.getInt(1) + 1;
        
        return id;
    }
}
