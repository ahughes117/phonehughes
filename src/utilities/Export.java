/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
            //+ "E-mail 1 - Type,"
            + "E-mail Address,"
            //+ "Email2-Type,"
            //+ "Email2-Value,"
            //+ "Phone 1 - Type,"
            + "Mobile Phone,"
            //+ "Phone2-Type,"
            //+ "Phone2-Value,"
            //+ "Notes,"
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
                + "select c.Name, c.Surname, c.Comments, g.GroupName, "
                + "e.EmailAddress, t.TelephoneNumber  "
                + "from Contact c  "
                + "inner join ContactGroup cg on c.ContactID = cg.ContactID  "
                + "inner join cGroup g on g.cGroupID = cg.GroupID  "
                + "inner join ContactEmail ce on c.ContactID = ce.ContactID  "
                + "inner join Email e on ce.EmailID = e.EmailID  "
                + "inner join ContactTelephone ct on c.ContactID = ct.ContactID  "
                + "inner join Telephone t on ct.TelephoneID=t.TelephoneID;");

        //filling each contact with ResultSet data and adding to arraylist
        GoogleContact gc;
        while (contactR.next()) {
            gc = new GoogleContact();

            gc.setFirstName(contactR.getString("Name"));
            gc.setLastName(contactR.getString("Surname"));
            gc.setEmail1(contactR.getString("EmailAddress"));
            gc.setPhone1(contactR.getString("TelephoneNumber"));
            gc.setGroup(contactR.getString("GroupName"));
            //gc.setNotes(contactR.getString("Comments"));

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
                    /*+ tmp.getEmailType() + ","*/ + tmp.getEmail1() + ","
                    /*+ tmp.getPhoneType() + ","*/ + tmp.getPhone1() + ","
                    /*+ tmp.getNotes() + ","*/ + tmp.getGroup() + "\n";

            contents += line;
        }
        IO.writeFile(contents, "GoogleContacts.csv");

    }
}
