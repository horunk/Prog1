package Practice4;

public class Exercise4 {
    /* Use loops to print out a table like that:
                1 0 0 0 0 0 0
                0 1 0 0 0 0 0
                0 0 1 0 0 0 0
                0 0 0 1 0 0 0
                0 0 0 0 1 0 0
                0 0 0 0 0 1 0
                0 0 0 0 0 0 1
    */
    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            for(int j = 0; j < 7; j++) {
                if(i==j){
                    System.out.print(1+ " ");
                }else{
                    System.out.print(0 + " ");
                }
            }
            System.out.print("\n");
        }


    }


}
