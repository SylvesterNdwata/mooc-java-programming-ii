
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int first = 0;
        int second = 0;

        while (true) {
            System.out.print("> ");
            System.out.println("First: " + first + "/100");
            System.out.println("Second: " + second + "/100");
            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }

            if (input.contains("add")) {
                String[] parts = input.split(" ");
                int amount = Integer.valueOf(parts[1]);

                if (first + amount > 100) {
                    first = 100;
                } else if (amount > 0) {
                    first += amount;
                }
            }
            if (input.startsWith("move")) {
                String[] parts = input.split(" ");
                int amount = Integer.valueOf(parts[1]);
                int toBeMoved = 0;
                if (first <= amount) {
                    amount = first;
                }

                if (amount + second > 100) {
                    toBeMoved = 100 - second;
                    second = 100;
                    first -= toBeMoved;
                } else {
                    second += amount;
                    first -= amount;
                }
            }

            if (input.startsWith("remove")) {
                String[] parts = input.split(" ");
                int amount = Integer.valueOf(parts[1]);

                if (amount > second) {
                    second = 0;
                } else if (second > 0) {
                    second -= amount;
                }
            }
        }
    }

}
