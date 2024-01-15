import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args) throws IOException {
        String path = "....."; // Add te path of the resource
        String inputPath = path + "input.txt";
        String outputPath = path + "06.SortLinesOutput.txt";
        Path pathInput = Paths.get(inputPath);
        Path pathOutput = Paths.get(outputPath);
        List<String> list = Files.readAllLines(pathInput).
                stream().sorted().collect(Collectors.<String>toList());
        Files.write(pathOutput, list);
    }
}
