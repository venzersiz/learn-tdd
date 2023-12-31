package chap07;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static chap07.CardValidity.VALID;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutoDebitRegisterTest {

    private AutoDebitRegister register;

    @BeforeEach
    void setUp() {
        register = new AutoDebitRegister(new CardNumberValidator(), new JpaAutoDebitInfoRepository());
    }

    @Test
    void validCard() {
        // 업체에서 받은 테스트용 유효한 카드번호 사용
        AutoDebitRequest request = new AutoDebitRequest("user1", "1234123412341234");
        RegisterResult result = register.register(request);
        assertEquals(VALID, result.getValidity());
    }

    @Test
    void theftCard() {
        // 업체에서 받은 도난 테스트용 카드번호 사용
        AutoDebitRequest request = new AutoDebitRequest("user1", "1234123412341234");
        RegisterResult result = register.register(request);
        assertEquals(VALID, result.getValidity());
    }
}
