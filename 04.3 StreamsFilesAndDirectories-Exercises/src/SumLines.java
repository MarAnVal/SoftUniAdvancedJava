import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SumLines {
    public static void main(String[] args) throws IOException {
        String path = "....."; // Add te path of the resource
        String inputPath = path + "\\input.txt";
        List<String> lines = Files.readAllLines(Path.of(inputPath));
        for (String line : lines) {
            int sum = 0;
            for (char ch : line.toCharArray()) {
                sum += (int) ch;
            }
            System.out.println(sum);

        }

        // v.2
//        String path = "C:\\Users\\.....\\OneDrive\\Desktop\\Java\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";
//        String inputPath = path + "\\input.txt";
//        List<String> lines = Files.readAllLines(Path.of(inputPath));
//        lines.stream().map(String::toCharArray).
//                forEach(arr -> {
//                    int sum = 0;
//                    for (char ch : arr) {
//                        sum += ch;
//                    }
//                    System.out.println(sum);
//                });
    }
}
