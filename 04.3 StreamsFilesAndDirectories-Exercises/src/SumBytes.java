import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SumBytes {
    public static void main(String[] args) throws IOException {
        String path = "....."; // Add te path of the resource
        String inputPath = path + "\\input.txt";
        List<String> lines = Files.readAllLines(Path.of(inputPath));
        Long sum = 0L;
        for (String line : lines) {
            for (char ch : line.toCharArray()) {
                sum += (int) ch;
            }
        }
        System.out.println(sum);
    }
}
