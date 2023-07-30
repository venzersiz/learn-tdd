package appendix.a;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("integration")
public class TagTest {

    @Test
    @Tag("very-slow")
    void verySlow() {
        int result = 0;
        assertEquals(0, result);
    }
}
