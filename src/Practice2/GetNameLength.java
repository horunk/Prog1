package Practice2;

public class GetNameLength {
    public static void main(String[] args) {

        //ask user for his/her name and assign to variable
        System.out.println("What's your name?");
        String name = TextIO.getlnString();


        //output the number of characters in the name
        System.out.println("Your name seems to have " + name.length() + " characters.");
    }

}
