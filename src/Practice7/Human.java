package Practice7;

public class Human {

    public String name;
    public int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void greet() {
        System.out.println(greetAsString());
    }

    public String greetAsString() {
        String reply = "";
        if (age < 3 ){
            reply = "Boo boo";
        }else {
            reply = "Hello, my name is " + name + " and I am " + age + " years old.";
        }
        return reply;
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}
