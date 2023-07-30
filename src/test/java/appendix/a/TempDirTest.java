package appendix.a;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.nio.file.Path;

public class TempDirTest {

    @TempDir
    static File tempFolderPerClass; // @BeforeAll로 대체 가능

    @TempDir
    File tempFolder;

    @Test
    void fileTest(@TempDir Path tempFolder) {
    }
}
