/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author ahughes
 */
public class IO {
    
    /**
     * This function takes a filename as a parameter, reads the file's contents
     * into a String, encoded in UTF-8 and returns the String.
     * 
     * @param aFile
     * @return
     * @throws IOException 
     */
    public static String readFile(String aFile) throws IOException {
        String contents = "";
        String s;
        BufferedReader fr = new BufferedReader(new InputStreamReader(new FileInputStream(aFile), "UTF8"));
        while ((s = fr.readLine()) != null) {
            contents += s + "\n";
        }
        fr.close();
        return contents;
    }
    
    /**
     * This function takes a String with some content and a String which is 
     * the filename, writes the content to the file using UTF-8 encoding
     * and finally closes the file.
     * 
     * @param aContent
     * @param aFileName
     * @throws IOException 
     */
    public static void writeFile(String aContent, String aFileName) throws IOException {
        BufferedWriter fr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aFileName), "UTF8"));
        fr.write(aContent);
        fr.close();
    }
    
}
