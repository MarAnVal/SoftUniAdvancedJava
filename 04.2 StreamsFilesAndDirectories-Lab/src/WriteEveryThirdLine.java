import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws RuntimeException {
        String path = "....."; // Add te path of the resource
        String inputPath = path + "input.txt";
        String outputPath = path + "05.WriteEveryThirdLineOutput.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             PrintStream writer = new PrintStream(new FileOutputStream(outputPath))) {
            int countLines = 1;
            String line = reader.readLine();
            while (line != null) {
                if (countLines % 3 == 0) {
                    writer.println(line);

                }
                countLines++;
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
