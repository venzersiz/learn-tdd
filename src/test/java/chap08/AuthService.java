package chap08;

public class AuthService {

    private String authKey = "somekey";

    public int authorize(String id, String pw) {

        boolean authorized = AuthUtil.authorize(authKey);
        if (authorized) {
            return AuthUtil.authenticate(id, pw);
        } else {
            return -1;
        }
    }
}
