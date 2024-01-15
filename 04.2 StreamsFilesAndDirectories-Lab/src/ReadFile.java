import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) throws RuntimeException {
        String path = "....."; // Add te path of the resource

        try (FileInputStream inputStream = new FileInputStream(path)) {
            int oneByte = inputStream.read();
            while(oneByte >= 0){
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = inputStream.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
