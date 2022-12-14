
/*
 * File: Main.java
 * Author: Joshua Francis
 * Concentration: Software Development
 * Date: 11/03/2022
 * Java class description: Main Class That Calls the Helper Class (MyArray.java).
 * Accepts Parameters for an Array as Variables and Returns Different Versions of 
 * That Array using the methods from the helper class. 
*/


// Package 
package csc145exam2;

// Main Class 
// For Example Commmented Out Code * 
import java.util.Arrays;

public class Main {

    // Main Method 
    public static void main(String[] args) {

        // Variables Stored For Quick Changes 
        int rows = 5;
        int columns = 6;
        int minNum = 0;
        int maxNum = 9;

        Boolean mode1 = true;
        Boolean mode2 = false;
        String delimiterLeft1 = "[";
        String delimiterRight1 = "]";
        String delimiterLeft2 = "(";
        String delimiterRight2 = ")";

        System.out.println("----- Joshua Francis: CSC Software Development -----");
        
        //Spacing
        System.out.println();
        
        // Testing 
        // int[][] MainArray = {{1, 2, 3, 4, 5},{2, 7, 8, 9, 10}, {3, 12, 13, 14, 15}, {4, 17, 18, 19, 20}, {5, 22, 23, 24, 25}};
        // Stores the Array for Quick Testing to Keep the Random Values Under Control 
        int[][] MainArray = MyArray.getArray2D(rows, columns, minNum, maxNum);

        // Prints out the Array Before Formatting 
        System.out.println("Before Formatting: ");
        
        //Spacing
        System.out.println();
        
        // Regular Pattern
        System.out.println("Regular Pattern: ");
        System.out.println(Arrays.deepToString(MainArray));
        
        //Spacing
        System.out.println();
        
        // Grid Pattern 
        System.out.println("Grid Pattern: ");
        System.out.println(MyArray.getString(MainArray, mode1, "", " ", "", " "));
        
        // Spacing 
        System.out.println("After Formatting: ");
        System.out.println();

        // Shows the Output For Mode 1 
        System.out.println("Mode = " + mode1);
        System.out.println(MyArray.getString(MainArray, mode1, delimiterLeft1, delimiterRight1, delimiterLeft2, delimiterRight2));

        // Shows the Output For Mode 2 
        System.out.println("Mode = " + mode2);
        System.out.println(MyArray.getString(MainArray, mode2, delimiterLeft1, delimiterRight1, delimiterLeft2, delimiterRight2));

        // Shows the Array Before Shuffling Process // Defaults the Delimiters to "[" and "]" as Stated 
        System.out.println("Before Shuffle: ");
        System.out.println(MyArray.getString(MainArray, mode1, "[", "]", "[", "]"));

        // Shuffles The Array 
        System.out.println("After Shuffle: ");
        MyArray.shuffleArray(MainArray);
        System.out.println(MyArray.getString(MainArray, mode1, "[", "]", "[", "]"));

    }

}
