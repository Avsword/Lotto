package fi.tuni.tamk.tiko.varjonenaaro.util;

/**
 * Math class contains different math operators.
 * 
 * Improved or altered versions of typical java.lang math operators. (Atleast
 * for now)
 * 
 * @author Aaro Varjonen
 */

public class Math {
    /**
     * Returns a random value within min and max.
     * 
     * Different than the normal java.lang.Math, this doesn't only return a random
     * number between 0-1, but between any integers.
     * 
     * @param min minimun random value
     * @param max maximum random value
     * @return a random value withing set parameters.
     */
    public static int getRandom(int min, int max) {
        return min + (int) (java.lang.Math.random() * ((max - min) + 1));
    }
}