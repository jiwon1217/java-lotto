package lotto.domain;

import lotto.exception.MoneyException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
class MoneyTest {

    @DisplayName("금액_생성_테스트")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000})
    void generateMoneyTest(Integer inputMoney) {
        Money money = new Money(inputMoney);
        assertThat(money.getMoney()).isEqualTo(inputMoney);
    }

    @DisplayName("금액은_숫자만_가능하다")
    @ParameterizedTest
    @ValueSource(strings = {"ㄱㄴㄷ", "abc", "aㄱb"})
    void moneyTypeTest(String money) {
        assertThatThrownBy(() -> MoneyException.validateMoneyType(money))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액은_양수만_가능하다")
    @ParameterizedTest
    @ValueSource(strings = {"-1000", "-2000", "-3000"})
    void positiveNumberTest(String money) {
        assertThatThrownBy(() -> MoneyException.validatePositiveNumber(money))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액은_1000원_단위로_나누어_떨어지는_금액만_가능하다")
    @ParameterizedTest
    @ValueSource(strings = {"1", "10", "100"})
    void divideByThousandUnitTest(String money) {
        assertThatThrownBy(() -> MoneyException.validateDivideByThousandUnit(money))
            .isInstanceOf(IllegalArgumentException.class);
    }

}