package dz5;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws Exception {


//        int[] arr = {111, 222, 333};
//        int[] array = new int[3];
//        byte[] barr = new byte[3];
//
//        for (int i = 0; i < arr.length; i++) {
//            array[i] = convInt(arr[i]);
//        }
//        for (int j = 0; j < array.length; j++) {
//            barr[j] = (byte) array[j];
//        }
//        try (FileOutputStream fos = new FileOutputStream("DZ.txt")){
//            fos.write(barr);
//        }
//        File file = new File("DZ.txt");
//        System.out.println(file.length());

        File folder = new File("C:\\Users\\rymos\\IdeaProjects\\dz1cor\\src\\main\\java\\dz5\\");
        File directory = new File("./backup");

        if (!directory.exists()) {
            Files.createDirectory(Paths.get(directory.getPath()));
            System.out.printf("Папка %s создана. \n", directory);
        } else {
            System.out.printf("Папка %s  существует. \n", directory);
        }

        for (File file : Objects.requireNonNull(folder.listFiles())) {
            System.out.printf("Файл: %s \n", file.getName());
            if (file.isFile()) {
                try {
                    Files.copy(Paths.get(file.getPath()), Paths.get(directory.getAbsolutePath() + "\\" + file.getName()), StandardCopyOption.REPLACE_EXISTING);
                    System.out.printf("Файл %s продублированн. \n", file.getName());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static int convInt(int num){
        return Integer.parseInt(String.valueOf((int) (num / 100 * Math.pow(4, 2) + num / 10 % 10 * Math.pow(4, 1) + num % 10 * Math.pow(4, 0))));
    }

}
