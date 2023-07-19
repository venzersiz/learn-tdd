package chap07;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static chap07.CardValidity.INVALID;
import static chap07.CardValidity.THEFT;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutoDebitRegister_Stub_Test {

    private AutoDebitRegister register;
    private StubCardNumberValidator stubValidator;
    private StubAutoDebitInfoRepository stubRepository;

    @BeforeEach
    void setUp() {
        stubValidator = new StubCardNumberValidator();
        stubRepository = new StubAutoDebitInfoRepository();
        register = new AutoDebitRegister(stubValidator, stubRepository);
    }

    @Test
    void invalidCard() {
        stubValidator.setInvalidNo("111122223333");

        AutoDebitRequest request = new AutoDebitRequest("user1", "111122223333");
        RegisterResult result = register.register(request);
        assertEquals(INVALID, result.getValidity());
    }

    @Test
    void theftCard() {
        stubValidator.setTheftNo("1234567890123456");

        AutoDebitRequest request = new AutoDebitRequest("user1", "1234567890123456");
        RegisterResult result = register.register(request);
        assertEquals(THEFT, result.getValidity());
    }
}
