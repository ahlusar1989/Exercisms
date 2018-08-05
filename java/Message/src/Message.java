import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Message {
    public static void main(String[] args) throws FileNotFoundException{
        try {
            File f = new File("message.txt");
            PrintStream outputFile = new PrintStream(f);
            outputFile.println("Testing,");
            outputFile.println("1, 2, 3.");
            outputFile.println();
            outputFile.println("This is my output file");
            outputFile.close();
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
