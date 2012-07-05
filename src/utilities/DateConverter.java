/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.Scanner;

/**
 *
 * @author Alex Hughes
 */
public class DateConverter {

    public static String SqlStringToString(String aSqlDate) {
        String date = "";
        String day = null, month = null, year = null;

        Scanner scanner = new Scanner(aSqlDate);
        scanner.useDelimiter("-");


        while (scanner.hasNext()) {
            year = scanner.next();
            month = scanner.next();
            day = scanner.next();
        }
        date = day + "/" + month + "/" + year;

        return date;
    }
}
