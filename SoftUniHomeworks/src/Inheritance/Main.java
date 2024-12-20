package Inheritance;

public class Main {
    public static void main(String[] args) {

        StackOfStrings sos = new StackOfStrings();

        sos.push("Pesho");
        sos.push("Gosho");
        System.out.println(sos.pop());
        System.out.println(sos.peek());
    }
}
