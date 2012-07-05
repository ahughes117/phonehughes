/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import GUI.LoginFrame;
import java.io.*;
import phoneHughes.Credentials;

/**
 *
 * @author Alex Hughes
 */
public class IOCredentials {
    
    public static void saveCredentials() {
        try {
            FileOutputStream fileOut = new FileOutputStream("credentials.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(LoginFrame.credentials);

            out.close();
            fileOut.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadCredentials() {
        try {
            FileInputStream fileIn = new FileInputStream("credentials.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            Object obj = in.readObject();

            if (obj instanceof Credentials) {
                LoginFrame.setCredentials((Credentials) obj);
            }

            in.close();
            fileIn.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
