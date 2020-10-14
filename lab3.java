import java.util.ArrayList;
import java.util.Collections;

public class lab3 {
    
    public static void main(String[] args) {
        String text = "Texture is an iOS framework built on top of UIKit";
        ArrayList<String> fragments = new ArrayList<>();

        for (int i = 0; i < text.length() - 3; i+=3) {
            char[] fragment = text.substring(i, i + 3).toCharArray();
            fragment[1] = getRandSymbolWhichIsNotIn(fragment);
            fragments.add(new String(fragment));
        }

        Collections.sort(fragments);
        System.out.println(fragments);
    }

    static char getRandSymbolWhichIsNotIn(char[] symbols) {
        endless: while(true) {
            char randSymbol = (char)(Math.random() * 26 + 'a');
            for (char c : symbols) {
                if (c == randSymbol) {
                    continue endless;
                }
            }
            return randSymbol;
        }
    }
}
