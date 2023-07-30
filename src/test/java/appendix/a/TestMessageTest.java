package appendix.a;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMessageTest {

    @Test
    void test() {
        List<Integer> ret = Arrays.asList(1, 2, 4);

        List<Integer> expected = Arrays.asList(1, 2, 3);
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), ret.get(i), "ret[" + i + "]");
        }
    }
}
