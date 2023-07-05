package sem5;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWorks {
    public static String readFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static void writeFile(String fileName, String textFile) throws IOException {
        try{
            Files.writeString(Path.of(fileName), textFile, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IOException("Try again");
        }

    }
}
