package Practice4;

public class Exercise3 {
    public static void main(String[] args) {
        // Print out numbers that are divisble by 3 from 30 to 0 on one line (30, 27, 24, 21 etc)

        for(int i = 30; i > 1; i--) {
            if (i % 3 == 0){
                System.out.print(i + " ");
            }
        }


    }
}
