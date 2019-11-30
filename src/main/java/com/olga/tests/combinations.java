package com.olga.tests;

// Java program to print all combination of size r in an array of size n
import java.io.*;

class Combination {
    private int allCombinations[][];

    /* alphabet[] ---> Input Array
    output[] ---> Temporary array to store current combination
    alphabetStart & alphabetEnd ---> Staring and Ending indexes in alphabet[]
    outputPointer ---> Current outputPointer in output[]
    combinationSize ---> Size of a combination to be printed */
    static void helper(int alphabet[], int output[], int alphabetStart,
                                int alphabetEnd, int outputPointer, int combinationSize)
    {
        // Current combination is ready to be printed, print it
        if (outputPointer == combinationSize)
        {
            for (int j=0; j<combinationSize; j++)
                System.out.print(output[j]+" ");
            System.out.println("");
            return;
        }

        // replace outputPointer with all possible elements. The condition
        // "alphabetEnd-alphabetPointer+1 >= combinationSize-outputPointer" makes sure that including one element
        // at outputPointer will make a combination with remaining elements
        // at remaining positions
        for (int alphabetPointer=alphabetStart; alphabetPointer<=alphabetEnd; alphabetPointer++)
        {
            output[outputPointer] = alphabet[alphabetPointer];
            helper(alphabet, output, 0, alphabetEnd, outputPointer+1, combinationSize);
        }
    }

    // The main function that prints all combinations of size combinationSize
    // in alphabet[] of size n. This function mainly uses combinationUtil()
    static void printCombination(int alphabet[], int combinationSize)
    {
        // A temporary array to store all combination one by one
        int output[]=new int[combinationSize];

        // Print all combination using temprary array 'output[]'
        helper(alphabet, output, 0, alphabet.length-1, 0, combinationSize);
    }

    /*Driver function to check for above function*/
    public static void main (String[] args) {
        int arr[] = {1, 2, 3};
        int r = 3;
        int n = arr.length;
        printCombination(arr,  r);
    }
}

/* This code is contributed by Devesh Agrawal */
