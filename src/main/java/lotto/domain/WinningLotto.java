package lotto.domain;

import static lotto.exception.WinningLottoException.validateBonusNumber;
import static lotto.exception.WinningLottoException.validateInputPattern;
import static lotto.exception.WinningLottoException.validateNumberRange;

import java.util.Arrays;
import java.util.stream.Collectors;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(String winningLotto, int bonusNumber) {
        validateInputPattern(winningLotto);
        this.winningLotto = convert(winningLotto);
        validateBonusNumber(this.winningLotto, bonusNumber);
        validateNumberRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private Lotto convert(String winningLotto) {
        return new Lotto(Arrays.stream(winningLotto.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    public boolean isContain(int number) {
        return this.winningLotto.isContain(number);
    }
}
