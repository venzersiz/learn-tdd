package chap07;

public class RegisterResult {

    private final CardValidity cardValidity;

    public RegisterResult(CardValidity cardValidity) {
        this.cardValidity = cardValidity;
    }

    public CardValidity getValidity() {
        return cardValidity;
    }

    public static RegisterResult success() {

        return new RegisterResult(CardValidity.VALID);
    }

    public static RegisterResult error(CardValidity validity) {

        return new RegisterResult(validity);
    }
}
