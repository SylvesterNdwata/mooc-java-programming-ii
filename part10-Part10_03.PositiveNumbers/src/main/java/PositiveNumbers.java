
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here
        List<String> inputs = new ArrayList<>();

        System.out.println("Input numbers, type \"end\" to stop.");
        while (true) {
            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            }

            inputs.add(input);
        }

        List<Integer> values = inputs.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toCollection(ArrayList::new));

        List<Integer> finalList = positive(values);

        for (Integer value : finalList) {
            System.out.println(value);
        }
    }

    public static List<Integer> positive(List<Integer> numbers) {

        List<Integer> values = numbers.stream()
                .filter(value -> value > 0)
                .collect(Collectors.toCollection(ArrayList::new));

        return values;
    }

}
