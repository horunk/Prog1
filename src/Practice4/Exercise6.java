package Practice4;

public class Exercise6 {
    /* Print out a table like that:

        0 1 2 3 4 5 6 7 8 9
        1 2 3 4 5 6 7 8 9 0
        2 3 4 5 6 7 8 9 0 1
        3 4 5 6 7 8 9 0 1 2
        4 5 6 7 8 9 0 1 2 3
        5 6 7 8 9 0 1 2 3 4
        6 7 8 9 0 1 2 3 4 5
        7 8 9 0 1 2 3 4 5 6
        8 9 0 1 2 3 4 5 6 7
        9 0 1 2 3 4 5 6 7 8

    */
    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            for(int j = 0; j < 10; j++) {
                if(i+j <= 9) {
                    System.out.print(i + j + " ");
                }else{
                    System.out.print(i+j-9 + " ");
                }
            }
            System.out.print("\n");
        }


    }


}