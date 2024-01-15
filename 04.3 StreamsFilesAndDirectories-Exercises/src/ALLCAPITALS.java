import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ALLCAPITALS {
    public static void main(String[] args) throws IOException {
        String path = "....."; // Add te path of the resource
        String inputPath = path + "\\input.txt";
        String outputPat = path + "\\output.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputPat));
        List<String> lines = Files.readAllLines(Path.of(inputPath));
        for (String line : lines) {
            writer.write(line.toUpperCase());
            writer.newLine();
        }
        writer.close();
        //V2 ot line 14 down
//
//        BufferedReader reader = new BufferedReader(new FileReader(inputPath));
//        String line = reader.readLine();
//        while (line != null) {
//            writer.write(line.toUpperCase());
//            writer.newLine();
//            line = reader.readLine();
//        }
//        writer.close();
    }
}
