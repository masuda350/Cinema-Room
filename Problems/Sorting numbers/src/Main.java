import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void sort(int[] numbers) {
        // write your code here
        Arrays.sort(numbers);
        /* Another solution 1
        boolean hasChanges = false;
        do {
            hasChanges = false;
            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i] < numbers[i - 1]) {
                    int current = numbers[i - 1];
                    numbers[i - 1] = numbers[i];
                    numbers[i] = current;
                    hasChanges = true;
                }
            }
        } while (hasChanges);
         */
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String[] values = scanner.nextLine().split("\\s+");
        int[] numbers = Arrays.stream(values)
                .mapToInt(Integer::parseInt)
                .toArray();
        sort(numbers);
        Arrays.stream(numbers).forEach(e -> System.out.print(e + " "));
    }
}