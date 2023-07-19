package chap06;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class MathUtils {

    public static long sum(File dataFile) {

        if (!dataFile.exists()) {
            throw new IllegalArgumentException("파일이 존재하지 않습니다");
        }

        long sum = 0;
        try {
            List<String> lines = Files.readAllLines(dataFile.toPath());

            for (String line : lines) {
                sum += Long.parseLong(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return sum;
    }
}
