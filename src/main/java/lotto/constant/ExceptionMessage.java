package lotto.constant;

public enum ExceptionMessage {

    INVALID_MONEY_TYPE("[ERROR] 금액은 숫자여야 합니다."),
    MONEY_MUST_NOT_NEGATIVE("[ERROR] 금액은 음수일 수 없습니다."),
    MONEY_MUST_MULTIPLE_OF_THOUSAND("[ERROR] 금액은 1,000원 단위로 나누어 떨어져야 합니다."),
    INVALID_INPUT_PATTERN("[ERROR] 입력 형식과 맞지 않습니다."),
    INVALID_NUMBER_RANGE("[ERROR] 로또 번호의 범위는 1 ~ 45까지 입니다."),
    BONUS_NUMBER_IS_DUPLICATED_WITH_WINNING_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다."),
    INVALID_LOTTO_SIZE("[ERROR] 로또는 6개의 숫자로 이루어져야 합니다."),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 로또의 6개의 수는 중복될 수 없습니다.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
