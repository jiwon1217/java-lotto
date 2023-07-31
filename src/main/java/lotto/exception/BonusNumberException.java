package lotto.exception;

import lotto.constant.ExceptionMessage;

public class BonusNumberException {

    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;

    public static void validateNumberRange(int number) {
        if (number < MIN_RANGE || number > MAX_RANGE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_RANGE.toString());
        }
    }
}
