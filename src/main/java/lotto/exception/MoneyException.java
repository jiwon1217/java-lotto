package lotto.exception;

import lotto.constant.ExceptionMessage;

public class MoneyException {

    public static void validateMoney(String money) {
        validateMoneyType(money);
        validatePositiveNumber(money);
        validateDivideByThousandUnit(money);
    }

    public static void validateMoneyType(String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MONEY_TYPE.toString());
        }
    }

    public static void validatePositiveNumber(String money) {
        int amount = Integer.parseInt(money);
        if (amount < 0) {
            throw new IllegalArgumentException(ExceptionMessage.MONEY_MUST_NOT_NEGATIVE.toString());
        }
    }

    public static void validateDivideByThousandUnit(String money) {
        int amount = Integer.parseInt(money);
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(
                ExceptionMessage.MONEY_MUST_MULTIPLE_OF_THOUSAND.toString());
        }
    }
}
