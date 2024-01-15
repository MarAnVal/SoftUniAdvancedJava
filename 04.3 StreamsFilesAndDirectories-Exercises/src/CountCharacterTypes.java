import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String path = "....."; // Add te path of the resource
        String inputPath = path + "\\input.txt";
        String outputPath = path + "\\inputLineNumbers.txt";
        List<String> lines = Files.readAllLines(Path.of(inputPath));
        PrintWriter writer = new PrintWriter(outputPath);
        Long sum = 1L;
        for (String line : lines) {
            writer.format("%d. %s%n", sum, line);
            sum++;
        }
        writer.close();
    }
}
