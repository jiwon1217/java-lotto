package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.InputMessage;
import lotto.exception.MoneyException;

public class InputView {

    private static final String NEW_LINE = System.lineSeparator();

    public static Integer inputMoney() {
        System.out.println(InputMessage.INPUT_MONEY);
        String money = Console.readLine();
        MoneyException.validateMoney(money);
        return Integer.parseInt(money);
    }

    public static String inputWinningLottoNumbers() {
        System.out.println(InputMessage.INPUT_WINNING_LOTTO_NUMBERS);
        return Console.readLine();
    }

    public static Integer inputBonusNumber() {
        System.out.printf(NEW_LINE);
        System.out.println(InputMessage.INPUT_BONUS_NUMBER);
        return Integer.parseInt(Console.readLine());
    }
}
