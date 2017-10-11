package Practice2;

public class FirstEx {
    public static void main(String[] args) {
        System.out.println("What's your name?");

        String name = TextIO.getlnString();

        System.out.println("What's your show size?");

        int shoeSize = TextIO.getInt();

        System.out.println("Your name seems to be " + name + " and your show size is " + shoeSize);
    }


}
