package Practice5;

public class Exercise1 {
    // add borders to table
    // Print out the following table with "borders". The height of the table is equal to the width.

    /*
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

        int input = 8;
        int lineStart;

        drawLine(input);


        drawTable(input);


        drawLine(input);

    }

    private static void drawTable(int input) {
        for (int row = 0; row <= input; row++) {

            System.out.print("| ");

            for (int column = 0; column <= input; column++) {

                // row = 8; col = 8
                // row = 7; col = 7

                if (row == column || row + column == input)
                    System.out.print("x ");

                else
                    System.out.print(0 + " ");

            }
            System.out.print("| ");
            System.out.println();
        }
    }

    private static void drawLine(int input) {
        int lineStart = 0;

        while (lineStart <= input +2) {
            System.out.print("- ");
            lineStart++;
        }
        System.out.println();
    }
}
