import java.util.ArrayList;

class lab1 {
    public static void main(String[] args) {
        int elements = 10;
        ArrayList<Integer> source = new ArrayList<>(elements);

        // set values
        for (int i = 0; i < elements; i++) {
            source.add(i);
        }

        ArrayList<Integer> shuffled = new ArrayList<>(source);

        // shuffle until elements are on unique positions
        do {
            for (int i = 0; i < source.size(); i++) {
                int indexToUse = (int)(Math.random() * (source.size() - 1));
                int buffer = shuffled.get(indexToUse);
                shuffled.set(indexToUse, shuffled.get(i));
                shuffled.set(i, buffer);
            }
        } while(!isUniqueShuffled(source, shuffled));

        System.out.println(source);
        System.out.println(shuffled);
    }

    static <Element> boolean isUniqueShuffled(ArrayList<Element> source, ArrayList<Element> shuffled) {

        for (int i = 0; i < source.size(); i++) {
            if (source.get(i) == shuffled.get(i)) {
                return false;
            }
        }
        return true;
    }
}