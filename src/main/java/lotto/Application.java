package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.domain.result.Result;
import lotto.exception.BonusNumberException;
import lotto.exception.WinningLottoException;
import lotto.util.LottoConverter;
import lotto.util.LottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        try {
            Money money = new Money(InputView.inputMoney());
            LottoCount lottoCount = new LottoCount(money);
            OutputView.printLottoCount(lottoCount);

            Lottos lottos = LottoNumberGenerator.generateLottos(lottoCount);
            OutputView.printPurchasedLottoNumbers(lottos);

            WinningLotto winningLotto = createWinningLotto();
            Result result = new Result(lottos, winningLotto);

            printResult(result, money);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
    }

    private static WinningLotto createWinningLotto() {
        String winningLottoNumbers = InputView.inputWinningLottoNumbers();
        WinningLottoException.validateInputPattern(winningLottoNumbers);

        Lotto winningLotto = LottoConverter.convertToLotto(winningLottoNumbers);

        int bonusNumber = InputView.inputBonusNumber();
        BonusNumberException.validateNumberRange(bonusNumber);
        WinningLottoException.validateDuplicateCheckWinningLottoAndBonusNumber(winningLotto, bonusNumber);

        return new WinningLotto(winningLotto, bonusNumber);
    }

    private static void printResult(Result result, Money money) {
        OutputView.printStatistic(result);
        OutputView.printYield(result, money);
    }
}
