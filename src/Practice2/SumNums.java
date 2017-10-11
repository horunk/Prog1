package Practice2;

import javax.xml.soap.Text;

public class SumNums {

    public static void main(String[] args) {

        // ask user for first Integer and insert to variable
        System.out.println("Please insert the first integer of two: ");
        int firstInt = TextIO.getInt();

        //ask user for second integer and insert to variable
        System.out.println("Please insert the second integer or two: ");
        int secondInt = TextIO.getInt();


        // sum the two variables and give output to user
        System.out.println("The product of two inserted integers is: " + firstInt*secondInt);
    }

}
