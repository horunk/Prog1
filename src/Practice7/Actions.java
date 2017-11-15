package Practice7;

import Practice2.TextIO;

import javax.xml.soap.Text;
import java.util.ArrayList;

public class Actions {
    public static void main(String[] args) {

        ArrayList<Human> meieInimesed = new ArrayList<>();

        while (true) {
            System.out.println("Please enter a name ... ( or blank line to exit)");
            String inputName = TextIO.getlnString();

            if (inputName.equals("")) {
                break;
            } else {
                System.out.println("... and please insert age");
                Integer inputAge = TextIO.getlnInt();

                meieInimesed.add(new Human(inputName, inputAge));
            }
        }


        System.out.println(meieInimesed);
        for (Human inimene:
             meieInimesed
                ) {
            inimene.greet();
        }

    }
}
