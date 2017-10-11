package Practice2;

public class CalculateMore {
    public static void main(String[] args) {
        double a = 15.3;
        double b = 20.2;
        double c;

        c = a * b;

        System.out.println(a + " * " + b + " = " + c);
        System.out.format("%.2f * %.1f = %.4f", a, b, c);
    }
}