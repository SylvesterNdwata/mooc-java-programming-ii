
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        /*Container container = new Container();
        
        container.add(50);
        System.out.println(container);
        System.out.println(container.contains());
        
        container.remove(60);
        System.out.println(container);
        
        container.add(200);
        System.out.println(container);*/
        Container first = new Container();
        Container second = new Container();

        while (true) {
            System.out.println("First: " + first);
            System.out.println("Second: " + second);

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }

            if (input.contains("add")) {
                String[] parts = input.split(" ");
                int amount = Integer.valueOf(parts[1]);

                first.add(amount);
            }
            if (input.startsWith("move")) {
                String[] parts = input.split(" ");
                int amount = Integer.valueOf(parts[1]);
                int toBeMoved = 0;

                if (first.contains() < amount) {
                    toBeMoved = first.contains();
                    first.remove(toBeMoved);
                    second.add(toBeMoved);
                } else {
                    first.remove(amount);
                    second.add(amount);
                }
            }

            if (input.startsWith("remove")) {
                String[] parts = input.split(" ");
                int amount = Integer.valueOf(parts[1]);

                second.remove(amount);

            }
        }

    }
}
