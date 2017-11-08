package Practice6;

public class Exercise2 {

    /*
    Write a program that lets user insert 10 numbers and then prints those numbers in opposite order.
     */
static int countOfNumbers;

    public static void main(String[] args) {
        System.out.println("Insert count of integers you want to reverse: ");
        countOfNumbers = TextIO.getlnInt();
        reverse10Numbers();
    }

    //print out random name out of 10
    public static void reverse10Numbers() {
        Integer[] numbers = new Integer[countOfNumbers];

        for (int i = 0; i < numbers.length; i++) {

            System.out.println("Please insert a number with index " + (i+1) + " out of " + numbers.length);
            numbers[i] = TextIO.getlnInt();
        }

        System.out.println("This is the reverse order of inserted numbers: ");
        for (int i = numbers.length-1; i >= 0 ; i--) {
            System.out.println(numbers[i]);
        }

        //System.out.println(numbers[new Random().nextInt(numbers.length)]);
    }



}
