import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        String path = "....."; // Add te path of the resource
        File file = new File(path);
        File[] nestedFiles = file.listFiles();
        assert nestedFiles != null;
        for (File nestedFile : nestedFiles) {
            if(nestedFile.isFile()){
                System.out.printf("%s: [%d]%n", nestedFile.getName(), nestedFile.length());
            }
        }
    }
}
