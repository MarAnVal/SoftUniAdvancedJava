import java.io.File;

public class GetFolderSize {
    public static int recursion(String path, String folder) {
        String folderPath = path + "\\" + folder;
        File file = new File(folderPath);
        File[] nestedFiles = file.listFiles();
        assert nestedFiles != null;
        int result = 1;
        for (File nestedFile : nestedFiles) {
            if (nestedFile.isDirectory()) {
                System.out.printf("%s%n", nestedFile.getName());
                result += recursion(folderPath, nestedFile.getName());
            }
        }
        return result;
    }


    public static void main(String[] args) {
        String path = "....."; // Add te path of the resource
        String folder = "Files-and-Streams";
        int count = recursion(path, folder);
        System.out.printf("%d folders", count);
    }

}
