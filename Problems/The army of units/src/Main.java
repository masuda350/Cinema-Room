import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        int category = new Scanner(System.in).nextInt();
        System.out.println(army(category));

        /* Another solution 1
        System.out.println(units < 1 ? "no army" :
                           units < 20 ? "pack" :
                           units < 250 ? "throng" :
                           units < 1000 ? "zounds" : "legion");
         */
    }

    static String army(int category) {
        if (category < 1) {
            return "no army";
        } else if (category < 20) {
            return "pack";
        } else if (category < 250) {
            return "throng";
        } else if (category < 1000) {
            return "zounds";
        } else {
            return "legion";
        }
    }
}