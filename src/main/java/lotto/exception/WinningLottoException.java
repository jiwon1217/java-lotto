package lotto.exception;

import java.util.regex.Pattern;
import lotto.constant.ExceptionMessage;
import lotto.model.Lotto;

public class WinningLottoException {

    private static final Pattern INPUT_PATTERN = Pattern.compile("^[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+$");

    public static void validateInputPattern(String winningLotto) {
        if (!INPUT_PATTERN.matcher(winningLotto).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_PATTERN.toString());
        }
    }

    public static void validateDuplicateCheckWinningLottoAndBonusNumber(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.isContain(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.BONUS_NUMBER_IS_DUPLICATED_WITH_WINNING_NUMBER.toString());
        }
    }
}
