package Practice4;

public class Exercise5 {
    /* Print out the following table with "borders". The height of the table is equal to the width.

        -----------------
        | x 0 0 0 0 0 x |
        | 0 x 0 0 0 x 0 |
        | 0 0 x 0 x 0 0 |
        | 0 0 0 x 0 0 0 |
        | 0 0 x 0 x 0 0 |
        | 0 x 0 0 0 x 0 |
        | x 0 0 0 0 0 x |
        -----------------

    */
    public static void main(String[] args) {
        System.out.println("-----------------");
        for (int i = 0; i < 7; i++) {
            System.out.print("| ");
            for (int j = 0; j < 7; j++) {
                if (i == j || i + j == 6) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.print("|\n");
        }
        System.out.println("-----------------");


    }


}
