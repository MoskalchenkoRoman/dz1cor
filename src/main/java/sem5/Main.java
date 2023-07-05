package sem5;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String file1;
        file1 = "C:\\Users\\rymos\\IdeaProjects\\dz1cor\\src\\main\\java\\dz5\\file";
        String file2 = "C:\\Users\\rymos\\IdeaProjects\\dz1cor\\src\\main\\java\\dz5\\Encryptor.txt";
        String file3 = "C:\\Users\\rymos\\IdeaProjects\\dz1cor\\src\\main\\java\\dz5\\Decryptor.txt";

        String contents = FileWorks.readFile(file1);
        System.out.println("Тест: " + contents);
        String encryptText = Cypher.encrypt(contents, 3);
        FileWorks.writeFile(file2, encryptText);
        System.out.println("Шифровка: " + encryptText);
        String decryptText = Cypher.decrypt(encryptText, 3);
        FileWorks.writeFile(file3, decryptText);
        System.out.println("Расшифровка: " + decryptText);
    }
}
