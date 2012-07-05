/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.sql.SQLException;
import phoneHughes.Credentials;

/**
 *
 * @author Alex Hughes
 */
public class EmbeddedConnector extends Connector {
    
        
    public EmbeddedConnector (Credentials cre) throws SQLException, ClassNotFoundException {
        super(cre);
    }
}
