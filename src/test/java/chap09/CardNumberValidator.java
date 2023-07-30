package chap09;

import chap07.CardValidity;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpTimeoutException;
import java.time.Duration;

public class CardNumberValidator {

    private String server;

    public CardNumberValidator(String server) {
        this.server = server;
    }

    public CardValidity validate(String cardNumber) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(server + "/card"))
                .header("Content-Type", "text/plain")
                .POST(BodyPublishers.ofString(cardNumber))
                .timeout(Duration.ofSeconds(3))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            switch (response.body()) {
                case "ok":
                    return CardValidity.VALID;
                case "bad":
                    return CardValidity.INVALID;
                case "expired":
                    return CardValidity.EXPIRED;
                case "theft":
                    return CardValidity.THEFT;
                default:
                    return CardValidity.UNKNOWN;
            }
        } catch (HttpTimeoutException e) {
            return CardValidity.TIMEOUT;
        } catch (IOException | InterruptedException e) {
            return CardValidity.ERROR;
        }
    }
}
