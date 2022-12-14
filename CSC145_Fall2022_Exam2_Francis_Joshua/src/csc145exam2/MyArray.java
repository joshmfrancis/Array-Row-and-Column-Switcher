/*
 * File: MyArray.java
 * Author: Joshua Francis
 * Concentration: Software Development
 * Date: 11/03/2022
 * Java class description: Helper class for the Driver Class (Main.java).
 * This Class Holds the Methods that Modify an Array or Display it Differently 
 * (See The Comments Above the Method Headers for more details). 
*/



// Package
package csc145exam2;

// Import 
import java.util.Random;

// Class 
public class MyArray {

    // Empty Constructor :O <- Suprised Face 
    public MyArray() {

    }

    // This method uses a random number generator to generate 
    // random numbers between minNum and maxNum, 
    // inclusive and returns a two dimensional array of random numbers. 
    public static int[][] getArray2D(int rows, int columns, int minNum, int maxNum) {

        
        // Random Object Created 
        Random generator = new Random();

        // Creates An Array and Populates it With the the Rows and Columns Passed in 
        int[][] Array = new int[rows][columns];

        // For Loop to Populate the Rows and Columns With Random Values 
        for (int a = 0; a < rows; a++) {

            for (int b = 0; b < columns; b++) {

                // Generates a Random Number taking into consideration the 
                
                int random = generator.nextInt(maxNum+1) + minNum;
                // Sets the Value At The Indexs Recursively at Each Index one by one 
                Array[a][b] = random;

            }
        }

        // Returns the Array for use in the getString Method 
        return Array;
    }

    // This method accepts a two-dimensional array of integers 
    // generated using the getArray2D method from above and returns 
    // a string representation of the array as shown below. 
    public static String getString(int[][] array, boolean mode, String delimiterLeft1,
            String delimiterRight1, String delimiterLeft2, String delimiterRight2) {

        String string = "";

        // For Loop to go Over Every "Row" (Happens 5 Times) array.length = Length of the (First) Row 
        for (int row = 0; row < array.length; row++) {

            // For Loop to go Over Every Element in the "Rows" (Happens 5 Times) array[row].length = Length of Columns in the Rows 
            for (int col = 0; col < array[row].length; col++) {

                // Logic For Left Delimiter "[" or "(" 
                // If Mode is True...
                if (mode == true) {
                    // If the Row Selected is odd...
                    if (row % 2 == 1) {
                        // If the Column Selected is Odd...
                        if (col % 2 == 1) {
                            // Choose "[" as the Left Delimiter 
                            string += delimiterLeft1;

                            // Else, Column that is Selected is Even... 
                        } else {
                            // Choose "(" as the Left Delimiter 
                            string += delimiterLeft2;
                        }
                        // Else, Row That is Selected is Even...
                    } else {
                        // If the Column Selected is Odd...
                        if (col % 2 == 1) {
                            // Choose "(" as the Left Delimiter 
                            string += delimiterLeft2;
                            // Else, Column that is Selected is Even... 
                        } else {
                            // Choose "[" as the Left Delimiter 
                            string += delimiterLeft1;
                        }

                    }
                    // Else, Mode is False...
                } else {
                    // If the Row Selected is Odd...
                    if (row % 2 == 1) {
                        // If the Column Selected is Odd...
                        if (col % 2 == 1) {
                            // Choose "(" as the Left Delimiter 
                            string += delimiterLeft2;

                            // Else, Column that is Selected is Even... 
                        } else {

                            // Choose "[" as the Left Delimiter 
                            string += delimiterLeft1;
                        }

                        // Else, Row That is Selected is Even...
                    } else {
                        // If the Column Selected is Odd...
                        if (col % 2 == 1) {
                            // Choose "(" as the Left Delimiter 
                            string += delimiterLeft1;
                            // Else, Column that is Selected is Even... 
                        } else {
                            // Choose "[" as the Left Delimiter
                            string += delimiterLeft2;
                        }

                    }

                }

                // For Every "Coordinate", Print out the Index in the Column From the Row 
                string += array[row][col];

                // LOGIC IS THE SAME AS LEFT DELIMITER BUT FOR THE RIGHT DELIMITER 
                // Logic For Right Delimiter "]" or ")"
                if (mode == true) {
                    if (row % 2 == 1) {
                        if (col % 2 == 1) {
                            string += delimiterRight1;
                        } else {
                            string += delimiterRight2;
                        }
                    } else {
                        if (col % 2 == 1) {
                            string += delimiterRight2;
                        } else {
                            string += delimiterRight1;
                        }
                    }
                } else {
                    if (row % 2 == 1) {
                        if (col % 2 == 1) {
                            string += delimiterRight2;
                        } else {
                            string += delimiterRight1;
                        }

                    } else {
                        if (col % 2 == 1) {
                            string += delimiterRight1;
                        } else {
                            string += delimiterRight2;
                        }
                    }
                }
            }

            // After Every Element in a Row has Been Added to the Output,
            // This Sets up the String to go to the Next Line 
            string += "\n";
        }

        //Returns the String To Be Printed To Output 
        return string;
    }

    // This method accepts a two-dimensional array of integers 
    // generated using the getArray2D method from above and modifies 
    // the original array as shown below. Works for both an even and odd number 
    // of rows and columns. If there is an odd number of rows, the last row is 
    // not row-shuffled. Similarly, when there is an odd number of columns, 
    // the last column is not column-shuffled. 
    public static void shuffleArray(int[][] array) {

        // Handles The Rows...
        // Loops Through the Array, Jumping 2 "Indexes" Each Time so That it Will Only Perform the Operation Below Every two Rows
        for (int row1 = 0; row1 < array.length; row1 += 2) {

            // To stop the Index From Going Out of Bounds 
            if (array.length == row1 + 1) {
                // Breaks and Loops Again Till Row is Greater Than or Equal to array.length. 
                break;
                // Otherwise...
            } else {
                // Swap the two Array Values at the "Indexes" (Rows) From the Temporary to the Main Array
                int[] temp = array[row1 + 1];
                array[row1 + 1] = array[row1];
                array[row1] = temp;
            }
        }

        // Handles the Columns/// 
        // Loops Through the Array, Jumping 2 "Columns" Each Time so That it Will Only Perform the Operation Below Every two Columns 
        for (int col = 0; col < array[0].length; col += 2) {
            if (array[0].length == col + 1) {
                // Breaks and Loops Again Till Row is Greater Than or Equal to array.length. 
                break;
                // Otherwise...
            } else {
                // For Loop To Go Throught All of the Rows in the Array...
                for (int row = 0; row < array.length; row++) {

                    // Creates a Temporary Storage for the Value at the Index 
                    int temp = array[row][col + 1];

                    // Swaps the Value at Row i Column Index +1 = row i at Column Index
                    array[row][col + 1] = array[row][col];
                    array[row][col] = temp;

                }
            }
        }

    }
}
