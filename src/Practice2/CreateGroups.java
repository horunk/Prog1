package Practice2;

public class CreateGroups {

    public static void main(String[] args) {

        // ask user for number of people
        System.out.println("Please insert the number of people to be divided into groups: ");
        int countOfPeople = TextIO.getInt();

        //ask user for size of the groups
        System.out.println("Please insert the needed size of the groups: ");
        int sizeOfGroups = TextIO.getInt();

        // calculate number of people not fitting into groups and the count of groups
        int leftOvers = countOfPeople%sizeOfGroups;
        int countOfGroups = (countOfPeople-leftOvers)/sizeOfGroups;


        //output the results
        if (leftOvers == 0){
            System.out.println("You can create " + countOfGroups + " groups and noone will be left out! Good job!");
        }else if (leftOvers == 1 ){
            System.out.println("You can create " + countOfGroups + " groups, but " + leftOvers + " person will be without any group. Sorry...");
        }else{
            System.out.println("You can create " + countOfGroups + " groups, but " + leftOvers + " persons will be without any group. Sorry...");
        }

    }
}
