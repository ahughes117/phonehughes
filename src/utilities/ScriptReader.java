/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Alex Hughes
 */
public class ScriptReader {

    private static ArrayList<String> queries = new ArrayList<String>();

    public static void parseScript() throws IOException {
        FileInputStream inStream = new FileInputStream("src_mysql/src_create.sql");

        Scanner sc = new Scanner(inStream);
        sc.useDelimiter(";");

        while (sc.hasNext()) {
            queries.add(sc.next());
        }
        queries.set(queries.size() - 1, null);
    }

    public static String getQuery(int i) {
        String query = null;

        if (i >= 0 && i < queries.size()-1) {
            query = queries.get(i);
        }

        return query;
    }

    public static int getQueryNumber() {
        return queries.size();
    }
}
