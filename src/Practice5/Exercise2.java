package Practice5;

public class Exercise2 {

    public static void main(String[] args) {
        String output = xCharacters('c',10);
        System.out.println("Your output is: " + output);
    }

    private static String xCharacters(char inputChar, int timesRepeated){
        String result = "";

        for(int i = 0; timesRepeated > i; i++){
            result = result + inputChar;
        }
        System.out.println(result);
        return result;
    }

}
