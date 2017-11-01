package Practice5;

import Practice2.TextIO;

public class Exercise4 {

    public static void main(String[] args) {

        System.out.println("Your IQ is " + getNumber("Please insert your expected IQ",1,10));

    }

    public static int getNumber(String question, int min, int max){
        System.out.println(question);
        System.out.println("The number should be between " + min + " and " + max);
        while(true){
            int userInput;
            userInput = TextIO.getlnInt();
            if(userInput > min && userInput < max){
                return userInput;
            }else{
                System.out.println(question);
                System.out.println("Inserted number is not valid, try again.");
                System.out.println("Minimum value is " + min + " and maximum value is " + max + ".");
            }
        }
    }


}
