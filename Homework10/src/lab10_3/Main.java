package lab10_3;

import java.io.File;
import java.io.IOException;

public class Main implements FileUtil{
    public static void main(String[] args) {
        try {
            FileUtil.encode("Homework10/file.txt", "Homework10/encode.txt");
            FileUtil.decode("Homework10/encode.txt", "Homework10/decode.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
