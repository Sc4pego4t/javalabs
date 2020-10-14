import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class lab7 {
    
    public static void main(String[] args) {
        int elements = 10;
        ArrayList<Integer> intList = new ArrayList<>();

        for (int i = 0; i < elements; i++) {
            intList.add((int)(Math.random() * 10));
        }
        System.out.println(intList);

        System.out.printf("avg: %.2f\n", intList.stream().mapToDouble(a -> a).average().getAsDouble());

        ArrayList<String> stringList = new ArrayList<>(Arrays.asList("Andrey", "dmitriy"));
        stringList.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

        intList.stream()
            .filter(el -> Collections.frequency(intList, el) == 1)
            .map(el -> Math.pow(el, 2))
            .forEach(System.out::println);
    }
}
