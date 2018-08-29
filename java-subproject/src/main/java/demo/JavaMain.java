package demo;

public class JavaMain {

    public static void main(String[] args) {
        final GreetingJoiner example = new GreetingJoiner(new Greeter("Hi"));
        example.addName("Harry");
        example.addName("Ron");
        example.addName(null);
        example.addName("Hermione");

        System.out.println(example.getJoinedGreeting());
    }
}
