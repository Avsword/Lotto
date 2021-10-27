package fi.tuni.tamk.tiko.varjonenaaro.util;

/**
 * Arrays contains different operators for dealing with arrays.
 * 
 * 
 * 
 * @author Aaro Varjonen
 */
public class Arrays {
    /**
     * The main method is only used to test out different methods within package
     * Arrays.
     * 
     * @param args Arguments
     */
    public static void main(String[] args) {
        /*
         * String[] testarray = new String[2]; testarray[0] = "241525"; testarray[1] =
         * "5125"; int[] intarray = toIntArray(testarray);
         * System.out.println(intarray[0]); System.out.println(intarray[1]);
         * System.out.println(contains(2, intarray));
         */
        int[] array2 = new int[] { 20, 1, 21, 2, 23, 24, 25 };
        for (int i = 0; i < 7; i++) {
            System.out.println(sort(array2)[i]);
        }

    }

    /**
     * toIntArray handles converting a String array to an Int array.
     * 
     * The method checks the length of param array, and then converts each section
     * of the array to int one by one.
     * 
     * @param array The String array, which will be converted in to an int array.
     * @return Stringarray in int form
     */
    public static int[] toIntArray(String[] array) {
        int[] returnarray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            returnarray[i] = Integer.parseInt(array[i]);
        }

        return returnarray;
    }

    /**
     * Method contains searches an entire int array searching for a certain value.
     * it does this within a for-loop the length of our int array.
     * 
     * @param value Which value are we looking for
     * @param array From what are we looking for
     * @return Is param value somewhere in int array
     */
    public static boolean contains(int value, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (value == array[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method containsSameValues checks every number within array1, and checks if it
     * is contained within array2. (Tests every number, and if the are equal, add 1
     * to the matches.)
     * 
     * @param array1 First array
     * @param array2 Second array
     * @return How many values were in both arrays.
     */
    public static int containsSameValues(int[] array1, int[] array2) {
        int matches = 0;

        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
                    matches++;
                }
            }
        }
        return matches;
    }

    /**
     * Method sort sorts an array in an ascending order.
     * 
     * @param array the array to be sorted
     * @return the sorted array
     */
    public static int[] sort(int[] array) {
        int[] returnarray = new int[array.length];
        int currentminimum = 999;
        int minindex = 999;
        // Test every index
        for (int i = 0; i < array.length; i++) {
            // With every index, check every number to see the smallest.
            for (int j = 0; j < array.length; j++) {

                if (array[j] < currentminimum) {
                    // Select the smallest out of the bunch and set it as our current minimum.
                    currentminimum = array[j];
                    minindex = j;
                }
            }
            returnarray[i] = currentminimum;
            // Reset our current minimum to 999 for the "next round"
            currentminimum = 999;
            // Seal the lowest index.
            array[minindex] = 999;
        }

        return returnarray;
    }

    /**
     * This doesn't work and development for this function has stopped.
     * 
     * @param index  The number that got randomly picked
     * @param array  The array that we are removing said number from, and pushing
     *               all numbers -1 from
     * @param repeat How many times an index has previously been removed.
     * @return Returns the same int array, but with the index removed and the
     *         numbers ahead of it bumped back one index.
     */
    public static int[] removeIndex(int index, int[] array, int repeat) {
        int[] result = new int[array.length - repeat];
        // Starts at whatever number was randomly generated
        for (int i = index; i < array.length - repeat; i++) {
            // skip the first number
            if (i == index) {
                i++;
            } else {
                // Put every other number back one
                array[i - 1] = array[i];
            }

        }
        return result;
    }
}
