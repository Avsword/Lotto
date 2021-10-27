package fi.tuni.tamk.tiko.varjonenaaro;

import fi.tuni.tamk.tiko.varjonenaaro.util.*;
import fi.tuni.tamk.tiko.varjonenaaro.util.Math;

public class Lotto {

    /**
     * main method initializes variables, executes packages and deals with end-user
     * interactions in order to create the lotto experience.
     * 
     * @param args String arguments
     */
    public static void main(String[] args) {
        // Command-line argument implementation
        int[] commandlineToint = new int[args.length];
        // If there aren't any command-line arguments, then...
        if (args.length != 0) {
            // Insert every string arg while checking if the input was int.
            for (int i = 0; i < args.length; i++) {
                try {
                    commandlineToint[i] = Integer.parseInt(args[i]);
                } catch (Exception e) {
                    System.err.println("Command line argument number. " + i + " is invalid. inputs must be numerical");
                    System.exit(1);
                }
            }
        }

        // MyConsole initialization
        int min = 0;
        int max = 41;
        String errorMessageNonMinAndMax = "Input was not between 1 and " + max;
        String errorMessageNonNumeric = "Input was not numeric";

        // How many matches do you need to get. Set to 7 by default, but can be changed.
        int wincondition = 7;
        // If there are commandline args, then set it to the length of the array
        if (args.length != 0) {
            wincondition = args.length;
        }

        // Arrays initialization
        int[] inputArray = new int[wincondition];

        if (args.length != 0) {
            inputArray = commandlineToint;
        } else {
            // if there aren't any commandline arguments, then do the manual input.
            // While the length of our input array is less than wincondition.
            int successfulInputs = 0;
            int userinput = 0;
            while (successfulInputs < wincondition) {
                System.out.println(
                        "Please give a unique number between 1 and 40, " + (successfulInputs + 1) + "/" + wincondition);
                // readInt loops until it gets a valid input.
                userinput = MyConsole.readInt(min, max, errorMessageNonNumeric, errorMessageNonMinAndMax);
                // If the end user's input is not contained beforehand within the Array, THEN we
                // can save it in our inputArray
                if (Arrays.contains(userinput, inputArray) == false) {
                    // System.out.println("TB: IN IF");
                    inputArray[successfulInputs] = userinput;
                } else if (Arrays.contains(userinput, inputArray) == true) {
                    System.out.println("Unique numbers!");
                    continue;
                }
                successfulInputs++;
            }
        }

        // Initializing the looping game
        int matches = 0;
        int weeks = 0;
        int highscore = 0;
        int lifetimecounter = 0;
        int[] winninglotto = new int[wincondition];
        while (matches != wincondition) {
            int[] lotto = new int[wincondition];
            lotto = calculatelotto(wincondition, max);
            matches = Arrays.containsSameValues(lotto, inputArray);
            weeks++;
            if (matches > highscore) {
                highscore = matches;
                System.out.println("Got " + highscore + " right! Took " + (weeks / 52) + " years");
            }
            // When jackpot conditions are met, then...
            if (matches == wincondition) {
                winninglotto = lotto;
                // Lifetime implementation
                if ((weeks / 52) >= 120) {
                    System.out.println("Although it took more than a lifetime... Let's try again!");
                    lifetimecounter++;
                    // Reset the game
                    matches = 0;
                    highscore = 0;
                    weeks = 0;
                }
            }
        }

        // Sort the arrays and print them.
        int[] sortedInputArray = new int[wincondition];
        sortedInputArray = Arrays.sort(inputArray);
        System.out.println("You won! Your win took only " + lifetimecounter + " lifetimes");
        for (int a = 0; a < wincondition; a++) {
            System.out.print(sortedInputArray[a] + " ");
        }

        int[] sortedLottoArray = new int[wincondition];
        sortedLottoArray = Arrays.sort(winninglotto);
        System.out.println(" ");
        for (int b = 0; b < wincondition; b++) {
            System.out.print(sortedLottoArray[b] + " ");
        }
    }

    /**
     * Calculatelotto-method picks out a random index from an array the length of
     * 40, and places it within the return int[]
     * 
     * @return returns an int array the size of wincondition, with all unique
     *         numbers from between 1-40.
     */
    private static int[] calculatelotto(int wincondition, int max) {
        // Autofills an array of however many options we want.
        int[] array40 = new int[max];
        for (int i = 1; i < array40.length; i++) {
            array40[i] = i;
        }
        int[] lotto = new int[wincondition];
        int lottorepeats = 0;
        while (lottorepeats < wincondition) {
            // Gets a random number from out array40.
            int index = Math.getRandom(0, array40.length - lottorepeats);
            // if the random number is NOT in our lotto array, then we can save it.
            if (Arrays.contains(index, lotto) == false) {
                // System.out.println("TB: IN IF");
                lotto[lottorepeats] = index;
                // If our random number IS in our lotto array,then restart the loop
            } else if (Arrays.contains(index, lotto) == true) {
                // System.out.println("Unique numbers!");
                continue;
            }
            lottorepeats++;
        }
        return lotto;
    }
}