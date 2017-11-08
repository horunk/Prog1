package Practice6;

import javax.xml.soap.Text;
import java.util.ArrayList;

public class Exercise4 {
    /*
    Write a method that lets user input names as long as user inputs an empty line.
    After that all names are printed out with a number showing how many times the name contains letter 'a':

0 John
2 Adelina
1 Aron
3 Barbara

     */

    public static void main(String[] args) {
        showNumberOfLetterAinName();
    }

    public static void showNumberOfLetterAinName(){
        ArrayList<String> names = new ArrayList<>();

        while (true) {
            String input;
            System.out.println("Insert a name or newline to end");
            input = TextIO.getlnString();
            if (input.equals("")){
                break;
            }else{
                names.add(input);
            }
        }

        for (String name : names
             ) {
            int letterCount=0;
            for (int i = 0; i < name.length(); i++) {
                if (name.charAt(i) == 'a' || name.charAt(i) == 'A'){
                    letterCount++;
                }

            }
            System.out.println( letterCount +" : " + name);
        }

    }


}
