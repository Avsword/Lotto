package fi.tuni.tamk.tiko.varjonenaaro.util;

import java.io.Console;

/**
 * MyConsole deals with interactions between the user and the console.
 * 
 * @author Aaro Varjonen
 */
public class MyConsole {
    /**
     * * readInt gets an input from the user, checks if it's an int value, and then
     * outputs the int value. If input != int, then it asks the end user again. Loop
     * continues as long as either one OR both are false.
     * 
     * @param min                      minimum int value
     * @param max                      maximum int value
     * @param errorMessageNonNumeric   error message if input isn't an int
     * @param errorMessageNonMinAndMax error message if input isn't within min and
     *                                 max
     * @return returns an int within the set conditions.
     */
    public static int readInt(int min, int max, String errorMessageNonNumeric, String errorMessageNonMinAndMax) {
        Console c = System.console();
        int input = 0;
        boolean isInteger = false;
        boolean isMinMax = false;

        while ((isInteger == false || isMinMax == false) || (isInteger == false && isMinMax == false)) {
            // NumericCheck
            try {
                input = Integer.parseInt(c.readLine());
                // MinMaxCheck if the input is an int
                if (input > min && input < max) {
                    // System.out.println("TB: IN IF");
                    isMinMax = true;
                } else {
                    System.out.println(errorMessageNonMinAndMax);
                    isMinMax = false;
                    // System.out.println("TB: IN ELSE");
                }
                isInteger = true;
            } catch (NumberFormatException e) {
                System.out.println(errorMessageNonNumeric);
            }
            // System.out.println(isInteger);
            // System.out.println(isMinMax);
        }
        return input;
    }
}