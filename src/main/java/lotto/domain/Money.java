package lotto.domain;

import static lotto.exception.MoneyException.validateDivideByThousand;
import static lotto.exception.MoneyException.validatePositive;
import static lotto.exception.MoneyException.validateMoneyType;

public class Money {
    private final int money;

    public Money(String money) {
        validateMoneyType(money);
        validatePositive(money);
        validateDivideByThousand(money);
        this.money = Integer.parseInt(money);
    }

    public int getMoney() {
        return money;
    }

    public int calculateLottoCount(Money unit) {
        return this.money / unit.money;
    }
}
