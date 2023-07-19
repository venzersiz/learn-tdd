package chap07;

import java.time.LocalDateTime;

public class AutoDebitRegister {

    private final CardNumberValidator validator;
    private final JpaAutoDebitInfoRepository repository;

    public AutoDebitRegister(CardNumberValidator validator, JpaAutoDebitInfoRepository repository) {
        this.validator = validator;
        this.repository = repository;
    }

    public RegisterResult register(AutoDebitRequest request) {

        CardValidity validity = validator.validate(request.getCardNumber());

        if (validity != CardValidity.VALID) {
            return RegisterResult.error(validity);
        }

        AutoDebitInfo info = repository.findOne(request.getUserId());
        if (info == null) {
            AutoDebitInfo newInfo = new AutoDebitInfo(request.getUserId(), request.getCardNumber(), LocalDateTime.now());
            repository.save(newInfo);
        } else {
            info.changeCardNumber(request.getCardNumber());
        }

        return RegisterResult.success();
    }
}
