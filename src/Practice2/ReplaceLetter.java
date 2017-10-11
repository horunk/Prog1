package Practice2;

public class ReplaceLetter {
    public static void main(String[] args) {

        //ask user for the letter to be replaced
        System.out.println("Please insert the letter you wish to be replaced: ");
        char letter = TextIO.getlnChar();

        //ask user for the letter to be replaced with
        System.out.println("Please insert the letter you wish to be replaced with: ");
        char replaceWith = TextIO.getlnChar();

        // ask user for the string
        System.out.println("Please insert the text you wish to be processed: ");
        String userText = TextIO.getlnString();

        //output the text with user selected char replaced with second char
        System.out.println("Your modified text is following: \n");
        System.out.println(userText.replace(letter, replaceWith));

    }
}
