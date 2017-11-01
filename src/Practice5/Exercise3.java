package Practice5;

import Practice2.TextIO;

public class Exercise3 {

    public static void main(String[] args) {

        System.out.println("Your number is " + getNumber(1,100));

    }

    public static int getNumber(int min, int max){
        System.out.println("Please insert number between " + min + " and " + max);
        while(true){
            int userInput;
            userInput = TextIO.getlnInt();
            if(userInput > min && userInput < max){
                return userInput;
            }else{
                System.out.println("Inserted number is not valid, try again.");
                System.out.println("Minimum value is " + min + " and maximum value is " + max + ".");
            }
        }
    }


}
