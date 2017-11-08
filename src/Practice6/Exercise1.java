package Practice6;

import java.util.ArrayList;
import java.util.Random;

public class Exercise1 {

    static int countOfNames;


    /*
    Write a program that lets user insert 10 names, then randomly prints out one of those names.
    Improve the program by asking user for the number of users first.
     */

    public static void main(String[] args) {
        System.out.println("Please insert the number of names: ");
        countOfNames = TextIO.getlnInt();
        print10Names(countOfNames);
    }

    //print out random name out of 10
    private static void print10Names(int countOfNames) {
        String[] names = new String[countOfNames];

        for (int i = 0; i < names.length; i++) {

            System.out.println("Please insert a name number " + (i+1) + " out of " + names.length);

            names[i] = TextIO.getlnString();

        }
        System.out.println("This is a random name out of all inserted names:");
        System.out.println(names[new Random().nextInt(names.length)]);
    }



}
