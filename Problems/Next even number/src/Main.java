import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int num = scanner.nextInt();
        System.out.println(num % 2 == 0 ? num + 2 : ++num);

        /* Another solution
        System.out.println((scanner.nextInt() / 2) * 2 + 2);
         */
    }
}