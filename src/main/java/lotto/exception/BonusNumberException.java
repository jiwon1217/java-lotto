package lotto.exception;

import lotto.constant.ExceptionMessage;
import lotto.constant.LottoNumber;

public class BonusNumberException {

    public static void validateNumberRange(int number) {
        if (number < LottoNumber.MIN_RANGE || number > LottoNumber.MAX_RANGE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_RANGE.toString());
        }
    }
}
