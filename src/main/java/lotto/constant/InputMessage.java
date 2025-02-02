package lotto.constant;

public enum InputMessage {

    INPUT_MONEY("구입금액을 입력해 주세요."),
    INPUT_WINNING_LOTTO_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private String message;

    InputMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
