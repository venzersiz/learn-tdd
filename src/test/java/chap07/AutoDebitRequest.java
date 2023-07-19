package chap07;

public class AutoDebitRequest {

    private final String userId;

    private final String cardNumber;

    public AutoDebitRequest(String userId, String cardNumber) {
        this.userId = userId;
        this.cardNumber = cardNumber;
    }

    public String getUserId() {
        return userId;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}
