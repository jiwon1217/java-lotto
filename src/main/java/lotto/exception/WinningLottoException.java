package lotto.exception;

import java.util.regex.Pattern;
import lotto.domain.Lotto;

public class WinningLottoException {
    private static final Pattern INPUT_PATTERN = Pattern.compile("^[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+$");
    private static final String INVALID_INPUT_PATTERN = "[ERROR] 입력 형식과 맞지 않습니다.";
    private static final String BONUS_NUMBER_IS_DUPLICATED_WITH_WINNING_NUMBER = "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.";

    public static void validateInputPattern(String winningLotto) {
        if (!INPUT_PATTERN.matcher(winningLotto).matches()) {
            throw new IllegalArgumentException(INVALID_INPUT_PATTERN);
        }
    }

    public static void validateDuplicateCheckWinningLottoAndBonusNumber(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.isContain(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_IS_DUPLICATED_WITH_WINNING_NUMBER);
        }
    }
}
