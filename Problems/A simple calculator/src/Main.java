import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        long first = scanner.nextLong();
        String operation = scanner.next();
        long second = scanner.nextLong();

        switch (operation) {
            case "+":
                System.out.println(first + second);
                break;
            case "-":
                System.out.println(first - second);
                break;
            case "*":
                System.out.println(first * second);
                break;
            case "/":
                try {
                    System.out.println(first / second);
                    break;
                } catch (ArithmeticException e) {
                    System.out.println("Division by 0!");
                    break;
                }
                /* Another solution 1
                System.out.println(second == 0 ? "Division by 0!" : first / second);
                 */
            default:
                System.out.println("Unknown operator");
                break;
        }
    }
}