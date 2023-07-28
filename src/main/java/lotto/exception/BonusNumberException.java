package lotto.exception;

public class BonusNumberException {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final String INVALID_NUMBER_RANGE = "[ERROR] 로또 번호의 범위는 1 ~ 45까지 입니다.";

    public static void validateNumberRange(int number) {
        if (number < MIN_RANGE || number > MAX_RANGE) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
        }
    }
}
