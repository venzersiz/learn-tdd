package chap07;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserRegisterTest {

    private UserRegister userRegister;
    private StubWeakPasswordChecker stubPasswordChecker = new StubWeakPasswordChecker();
    private MemoryUserRepository fakeRepository = new MemoryUserRepository();
    private SpyEmailNotifier spyEmailNotifier = new SpyEmailNotifier();

    @BeforeEach
    void setUp() {
        userRegister = new UserRegister(stubPasswordChecker, fakeRepository, spyEmailNotifier);
    }

    @Test
    @DisplayName("약한 암호면 가입 실패")
    void weakPassword() {
        stubPasswordChecker.setWeak(true); // 암호가 약하다고 응답하도록 설정

        assertThrows(WeakPasswordException.class,
                () -> userRegister.register("id", "pw", "email"));
    }

    @Test
    @DisplayName("이미 같은 ID가 존재하면 가입 실패")
    void dupIdExists() {
        fakeRepository.save(new User("id", "pw1", "email@email.com"));

        assertThrows(DupIdException.class, () -> {
            userRegister.register("id", "pw2", "email");
        });
    }

    @Test
    @DisplayName("같은 ID가 없으면 가입 성공함")
    void noDupId_RegisterSuccess() {
        userRegister.register("id", "pw", "email");

        User savedUser = fakeRepository.findById("id");
        assertEquals("id", savedUser.getId());
        assertEquals("email", savedUser.getEmail());
    }

    @Test
    @DisplayName("가입하면 메일을 전송함")
    void whenRegisterThenSendMail() {
        userRegister.register("id", "pw", "email@email.com");

        assertTrue(spyEmailNotifier.isCalled());
        assertEquals("email@email.com", spyEmailNotifier.getEmail());
    }
}
