package chap08;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaySyncTest {

    private MemoryPayInfoDao memoryDao = new MemoryPayInfoDao();

    @Test
    void someTest() throws IOException {
        PaySync paySync = new PaySync(memoryDao);

        paySync.sync("src/test/resources/c0111.csv");

        List<PayInfo> savedInfos = memoryDao.getAll();
        assertEquals(2, savedInfos.size());
    }
}
