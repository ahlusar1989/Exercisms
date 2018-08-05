import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class CollapseSpaces {

    public static Scanner readInput(Scanner sc){
        Scanner result = null;
        while(result == null){
            System.out.println("File name?");
            String name = sc.next();
            try {
                result = new Scanner(new File(name));
            } catch (FileNotFoundException e){
                System.out.println("File not found. Please try again");

            }
        }
        return result;
    }

    public static void collapseAllSpaces(Scanner input, PrintStream output){
        while (input.hasNext()) {
            String currentLine = input.nextLine();
            Scanner formattedOutput = new Scanner(currentLine);
            if(formattedOutput.hasNext()){
                output.print(formattedOutput.next());
                while(formattedOutput.hasNext()){
                    output.print(" " + formattedOutput.next());
                }
                output.println();
            }
        }
        input.close();
        output.close();
    }

    public static void collapseAndWriteOut(Scanner sc){
        Scanner input = readInput(sc);
        System.out.println("Please provide output file name");
        String fileName = sc.next();
        File f = new File(fileName);
        PrintStream out = null;
        if(!f.exists()){
            try{
                out = new PrintStream(f);
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
            collapseAllSpaces(input, out);
        } else {
            System.out.println("File already exists");
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        Scanner console = new Scanner(System.in);
        collapseAndWriteOut(console);
    }

}
