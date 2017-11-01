package Practice5;

import Practice2.TextIO;

public class Exercise4 {

    // Extension of Exercise 3, adding question parameter for the function.

    public static void main(String[] args) {



        System.out.println("Your IQ is " + getNumber("Please insert your expected IQ",1,10));

    }

    public static int getNumber(String question, int min, int max){
        System.out.println(question);     // print out the question provided by method call
        System.out.println("The number should be between " + min + " and " + max);  // print out additional information about minimum and maximum values
        while(true){ // beginning of the user input loop with validation
            int userInput;
            userInput = TextIO.getlnInt(); // get input
            if(userInput > min && userInput < max){ // check if input is valid with min and max values
                return userInput; // if true, return user input
            }else{
                System.out.println(question); // tell user to try again
                System.out.println("Inserted number is not valid, try again.");
                System.out.println("Minimum value is " + min + " and maximum value is " + max + ".");
            }
        }
    }


}
