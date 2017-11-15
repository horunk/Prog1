package Practice7;

import Practice2.TextIO;

import java.util.ArrayList;

public class Sports {
    public static void main(String[] args) {
        ArrayList<Athlete> sportlased = new ArrayList<>();

        while (true) {
            System.out.println("Please enter a name of the athlete and score( or blank line to exit)");
            String input = TextIO.getlnString();

            if (input.equals("")) {
                break;
            } else {

                String[] splitData = input.split(" ");
                String name = splitData[0];
                Double score = Double.parseDouble(splitData[1]);

                sportlased.add(new Athlete(name, score));

            }
        }

        System.out.println(sportlased);
        for (Athlete sportlane:
                sportlased
                ) {
            System.out.println(sportlane.getName()+ " " + sportlane.getResult());
        }

    }
}
