import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class WriteToFile {
    public static void main(String[] args) throws IOException {
        String pathOutput = "....."; // Add te path of the resource
        String pathInput = "....."; // Add te path of the resource
        List<Character> skipp = Arrays.asList(',', '.', '!', '?');
        FileOutputStream outputStream = new FileOutputStream(pathOutput);
        try (FileInputStream inputStream = new FileInputStream(pathInput)) {
            int oneByte = inputStream.read();
            while (oneByte >= 0) {
                if (!skipp.contains((char) oneByte)) {
                    outputStream.write(oneByte);
                }
                oneByte = inputStream.read();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        outputStream.close();

    }
}
