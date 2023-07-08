package lotto.exception;

public class MoneyException {
    public static final String INVALID_MONEY_TYPE = "[ERROR] 금액은 숫자여야 합니다.";
    public static final String MONEY_MUST_NOT_NEGATIVE = "[ERROR] 금액은 음수일 수 없습니다.";
    public static final String MONEY_MUST_MULTIPLE_OF_THOUSAND = "[ERROR] 금액은 1,000원 단위로 나누어 떨어져야 합니다.";

    public static void validateMoneyType(String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_MONEY_TYPE);
        }
    }

    public static void validatePositive(String money) {
        int amount = Integer.parseInt(money);
        if (amount < 0) {
            throw new IllegalArgumentException(MONEY_MUST_NOT_NEGATIVE);
        }
    }

    public static void validateDivideByThousand(String money) {
        int amount = Integer.parseInt(money);
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(MONEY_MUST_MULTIPLE_OF_THOUSAND);
        }
    }
}
