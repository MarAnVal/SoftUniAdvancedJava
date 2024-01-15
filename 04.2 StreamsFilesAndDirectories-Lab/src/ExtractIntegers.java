import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {
        //
        String path = "....."; // Add te path of the resource
        String inputPath = path + "input.txt";
        String outputPath = path + "04.ExtractIntegersOutput";

        Scanner reader = new Scanner(new FileInputStream(inputPath));
        PrintStream writer = new PrintStream(new FileOutputStream( outputPath));

        while(reader.hasNext()){
            if(reader.hasNextInt()){
                //System.out.println(reader.nextInt());
                writer.println();
            }
            reader.next();
        }
    }
}
