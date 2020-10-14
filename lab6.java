import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class lab6 {

    static File currentFolder = new File(Paths.get("").toAbsolutePath().toString());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = null;
        try {
            while (!(input = scanner.nextLine()).isEmpty()) {
                String[] inputTokens = input.split(" ");
                switch (inputTokens[0]) {
                    case "ls":
                        ls();
                        break;
                    case "cd":
                        cd(inputTokens[1]);
                        break;
                    case "touch":
                        touch(inputTokens[1]);
                        break;
                    case "rm":
                        rm(inputTokens[1]);
                        break;
                    case "cat":
                        cat(inputTokens[1]);
                        break;
                    case "echo":
                        if (inputTokens[2].equals("-a")) {
                            echo(inputTokens[1], connectText(inputTokens, 3), true);
                        } else {
                            echo(inputTokens[1], connectText(inputTokens, 2), false);
                        }
                }
            }
        } catch(ArrayIndexOutOfBoundsException ex) {
            System.out.println("There should be more arguments in this call");
        } catch(Exception ex) {
            System.out.println(ex);
        }
        scanner.close();
    }

    static void ls() {
        for (File file : currentFolder.listFiles()) {
            System.out.println(file.getName());
        }
    }

    static void cd(String path) {
        if(path.toCharArray()[0] == '/') {
            currentFolder = new File(path);
        } else if(path.equals("..")) {
            currentFolder = currentFolder.getParentFile();
        } else {
            currentFolder = new File(currentFolder.getAbsolutePath(), path);
        }
    }

    static void touch(String filename) throws IOException {
        (new File(currentFolder.getAbsolutePath(), filename)).createNewFile();
    }

    static void rm(String filename) throws IOException {
        (new File(currentFolder.getAbsolutePath(), filename)).delete();
    }

    static void cat(String filename) throws IOException {
        Scanner scanner = new Scanner(new File(currentFolder.getAbsolutePath(), filename));
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            System.out.println(input);
        } 
    }

    static void echo(String filename, String text, boolean shouldAppend) throws IOException {
        FileWriter writer = new FileWriter(new File(currentFolder.getAbsolutePath(), filename), shouldAppend);
        writer.write(text);
        writer.close();
    }

    static String connectText(String[] text, int startingFrom) {
        String result = "";
        for (int i = startingFrom; i < text.length; i += 1) {
            result += text[i] + " ";
        } 
        return result;
    }
}
