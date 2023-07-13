package lotto.domain;

public class LottoCount {

    private static final Integer DEFAULT_UNIT = 1000;
    private final int lottoCount;

    public LottoCount(Money money) {
        lottoCount = calculateLottoCount(money, new Money(DEFAULT_UNIT));
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public int calculateLottoCount(Money money, Money unit) {
        return money.getMoney() / unit.getMoney();
    }
}
