import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLong()) {
            long num = scanner.nextLong();

            long t = num;
            for (int i = 2; i <= t; i++) {
                while (num % i == 0) {
                    num = num / i;
                    System.out.print(i + " ");
                }
            }
        }
    }
}