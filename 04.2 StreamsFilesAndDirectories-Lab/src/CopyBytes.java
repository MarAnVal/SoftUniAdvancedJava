import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws RuntimeException {
        String path = "....."; // Add te path of the resource
        String inputPath = path + "input.txt";
        String outputPath = path + "03.CopyBytesOutput.txt";

        try(FileInputStream input = new FileInputStream(inputPath);
            FileOutputStream output = new FileOutputStream(outputPath)){
            int oneByte = input.read();
            while (oneByte >= 0){
                if(oneByte != 10 && oneByte != 32){
                    String oneChar = String.valueOf(oneByte);
                    for (int i = 0; i < oneChar.length(); i++) {
                        output.write(oneChar.charAt(i));
                    }
                } else {
                    output.write(oneByte);
                }

                oneByte = input.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
