import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    static String fileName = "texto.txt";

    public static String Read(String filename) {

        String fileContent = "";

        try {

            File file = new File(filename);

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                fileContent += scanner.nextLine() + "\n";
            }

            scanner.close();

            return fileContent;

        } catch (FileNotFoundException e) {

            System.out.println("Archivo no encontrado: " + e.getMessage());

            return "null";
        }
    }

    public static void main(String[] args) {
        Markov_Chain mc = new Markov_Chain(7, Read(fileName));
        mc.Markov(1000);
        System.out.println(mc.Get_Result());
    }
}