package Practice5;

public class Exercise5 {

    public static void main(String[] args) {
        //ADD METHOD CALL AND OUTPUT
        System.out.println(random(1,77));
        System.out.println(random(1,77));
        System.out.println(random(1,77));
        System.out.println(random(1,77));
        System.out.println(random(1,77));

    }

    public static int random(int min, int max){
        int range = max - min + 1;
            return (int)(Math.random() * range)+min;

    }
}
