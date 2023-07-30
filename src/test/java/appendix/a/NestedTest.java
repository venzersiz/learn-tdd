package appendix.a;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NestedTest {

    @BeforeEach
    void outerBefore() {
    }

    @Test
    void outer() {
    }

    @AfterEach
    void outerAfter() {
    }

    @Nested
    class NestedA {

        @BeforeEach
        void nestedBefore() {
        }

        @Test
        void nested() {
        }

        @AfterEach
        void nestedAfter() {
        }
    }
}
