import java.util.Scanner;

public class Kaprekar {

    public static int kaprekarSteps(int n) {
        final int TARGET = 6174;
        int steps = 0;

        while (n != TARGET) {
            String s = String.format("%04d", n);

            if (s.chars().distinct().count() == 1) {
                return -1;
            }

            char[] digits = s.toCharArray();
            java.util.Arrays.sort(digits);
            int small = Integer.parseInt(new String(digits));

            int big = Integer.parseInt(new StringBuilder(new String(digits)).reverse().toString());

            n = big - small;
            steps++;
        }

        return steps;
    }

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter a 4-digit number: ");
            int n = sc.nextInt();

            int result = kaprekarSteps(n);

            if (result == -1) {
                System.out.println("All digits are same. Kaprekar process won't reach 6174.");
            } else {
                System.out.println("Steps to reach 6174: " + result);
            }
        }
    }
}