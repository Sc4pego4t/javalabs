import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class lab5 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Deque<Integer>> numbersStackList = new ArrayList<>();
        String input = null;
        while(!(input = scanner.nextLine()).isEmpty()) {
            Deque<Integer> stack = new ArrayDeque<>();
            for (char character : input.toCharArray()) {
                stack.add(Character.getNumericValue(character));
            }
            numbersStackList.add(stack);
        }
        scanner.close();

        for (Deque<Integer> stack : numbersStackList) {
            int summ = 0;
            int counter = 0;
            while(!stack.isEmpty()) {
                int el = stack.pop();
                summ += Math.pow(10, counter) * el;
                counter += 1;
            }
            System.out.println(summ);
        }
    }
}
