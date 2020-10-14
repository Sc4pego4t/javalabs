import java.util.ArrayList;

public class lab2 {
    
    public static void main(String[] args) {
        int elements = 6;
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        ArrayList<Integer> maxs = new ArrayList<>();

        // Fill array with elements
        for (int i = 0; i < elements; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < elements; j++) {
                matrix.get(i).add(i * 10 + j);
            }
        }

        System.out.println(matrix);

        // Find max elements per row
        for (int i = 0; i < elements; i++) {
            maxs.add(matrix.get(i).get(0));
            for (int j = 0; j < elements; j++) {
                if (matrix.get(i).get(j) > maxs.get(i)) {
                    maxs.set(i, matrix.get(i).get(j));
                }
            }
        }

        System.out.println(maxs);

        // Fin minimum element from max elements per row
        int minInMax = maxs.get(0);
        for (int i = 0; i < maxs.size(); i++) {
            if (maxs.get(i) < minInMax) {
                minInMax = maxs.get(i);
            }
        }
        
        matrix.remove(maxs.indexOf(minInMax));
        System.out.println(matrix);
    }
}
