package lotto.model;

import lotto.constant.LottoNumber;

public class LottoCount {

    private final int lottoCount;

    public LottoCount(Money money) {
        lottoCount = calculateLottoCount(money, new Money(LottoNumber.DEFAULT_UNIT));
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public int calculateLottoCount(Money money, Money unit) {
        return money.getMoney() / unit.getMoney();
    }
}
