
package utilities;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import phoneHughes.GoogleContact;
import sql.Connector;

/**
 * This class contains the functionality for exporting contacts.
 *
 * @author ahughes
 */
public class Export {

    //the google contact demanded fields
    public static final String GOOGLE_HEADER = ""
            + "First Name,"
            + "Last Name,"
            + "E-mail Address,"
            + "Mobile Phone,"
            + "Group Membership";

    /**
     * Exports all contacts in Google Contact compatible CSV format.
     *
     * @param con
     * @throws IOException
     * @throws SQLException
     */
    public Export(Connector con) throws IOException, SQLException {
        ArrayList<GoogleContact> contacts = new ArrayList<GoogleContact>();


        //sending the magic query that brings all the data we want
        //in the best format we can.
        ResultSet contactR = con.sendQuery(""
                + "SELECT c.Name, c.Surname, c.Comments, g.GroupName, "
                + "e.EmailAddress, t.TelephoneNumber  "
                + "FROM Contact c  "
                + "INNER JOIN ContactGroup cg ON c.ContactID = cg.ContactID  "
                + "INNER JOIN cGroup g ON g.cGroupID = cg.GroupID  "
                + "INNER JOIN ContactEmail ce ON c.ContactID = ce.ContactID  "
                + "INNER JOIN Email e ON ce.EmailID = e.EmailID  "
                + "INNER JOIN ContactTelephone ct ON c.ContactID = ct.ContactID  "
                + "INNER JOIN Telephone t ON ct.TelephoneID=t.TelephoneID;");

        //filling each contact with ResultSet data and adding to arraylist
        GoogleContact gc;
        while (contactR.next()) {
            gc = new GoogleContact();

            gc.setFirstName(contactR.getString("Name"));
            gc.setLastName(contactR.getString("Surname"));
            gc.setEmail1(contactR.getString("EmailAddress"));
            gc.setPhone1(contactR.getString("TelephoneNumber"));
            gc.setGroup(contactR.getString("GroupName"));
            
            contacts.add(gc);
        }
        printContacts(contacts);
    }

    /**
     * Prints the CSV file with the Google Contacts
     *
     * @param aList
     * @throws IOException
     */
    private void printContacts(ArrayList<GoogleContact> aList) throws IOException {
        String contents = GOOGLE_HEADER + "\n";

        String line = "";
        GoogleContact tmp;
        for (int i = 0; i < aList.size(); i++) {
            tmp = aList.get(i);

            line = tmp.getFirstName() + "," + tmp.getLastName() + ","
                    + tmp.getEmail1() + "," + tmp.getPhone1() + ","
                    + tmp.getGroup() + "\n";

            contents += line;
        }
        IO.writeFile(contents, "GoogleContacts.csv");

    }
}
