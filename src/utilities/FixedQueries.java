/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.sql.SQLException;
import sql.Connector;

/**
 *
 * @author Alex Hughes
 */
public class FixedQueries {

    public static void deleteContact(Connector aConnector, int aContactID) throws SQLException {

        aConnector.sendUpdate(""
                + "DELETE ce.*, e.* "
                + "FROM ContactEmail ce, Email e "
                + "WHERE ce.EmailID = e.EmailID AND ce.ContactID = " + aContactID);

        aConnector.sendUpdate(""
                + "DELETE ct.*, t.* "
                + "FROM ContactTelephone ct, Telephone t "
                + "WHERE ct.TelephoneID = t.TelephoneID AND ct.ContactID = " + aContactID);

        aConnector.sendUpdate(""
                + "DELETE FROM Contact WHERE ContactID = " + aContactID);

    }
}
