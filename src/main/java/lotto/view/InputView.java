package lotto.view;

import static lotto.exception.MoneyException.validateDivideByThousand;
import static lotto.exception.MoneyException.validateMoneyType;
import static lotto.exception.MoneyException.validatePositive;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String NEW_LINE = System.lineSeparator();
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_LOTTO_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static Integer inputMoney() {
        System.out.println(INPUT_MONEY);
        String money = Console.readLine();
        validateMoney(money);
        return Integer.parseInt(money);
    }

    private static void validateMoney(String money) {
        validateMoneyType(money);
        validatePositive(money);
        validateDivideByThousand(money);
    }

    public static String inputWinningLottoNumbers() {
        System.out.println(INPUT_WINNING_LOTTO_NUMBERS);
        return Console.readLine();
    }

    public static Integer inputBonusNumber() {
        System.out.printf(NEW_LINE);
        System.out.println(INPUT_BONUS_NUMBER);
        return Integer.parseInt(Console.readLine());
    }
}
