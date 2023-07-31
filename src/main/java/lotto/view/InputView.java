package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.MoneyException;

public class InputView {

    public static Integer inputMoney() {
        OutputView.printInputMoneyMessage();
        String money = Console.readLine();
        MoneyException.validateMoney(money);
        return Integer.parseInt(money);
    }

    public static String inputWinningLottoNumbers() {
        OutputView.printInputWinningLottoNumbersMessage();
        return Console.readLine();
    }

    public static Integer inputBonusNumber() {
        OutputView.printInputBonusNumber();
        return Integer.parseInt(Console.readLine());
    }
}
