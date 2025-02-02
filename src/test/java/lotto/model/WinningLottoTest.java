package lotto.model;

import java.util.Arrays;
import lotto.exception.BonusNumberException;
import lotto.exception.WinningLottoException;
import lotto.util.LottoConverter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class WinningLottoTest {
    @Test
    void 당첨_번호와_보너스_번호_입력_테스트() {
        Lotto winningLottoNumbers = LottoConverter.convertToLotto("1,2,3,4,5,6");
        int bonusNumber = 7;

        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(winningLotto.getWinningLotto().get()).isEqualTo(lotto.get());
        assertThat(bonusNumber).isEqualTo(winningLotto.getBonusNumber());
    }

    @Test
    void 당첨_번호_입력시_입력형식을_준수해야한다() {
        String winningLottoNumbers = "1, 2, 3, 4, 5, 6";

        assertThatThrownBy(() -> WinningLottoException.validateInputPattern(winningLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력 형식과 맞지 않습니다.");
    }

    @Test
    void 당첨_번호의_범위는_1부터_45까지_이다() {
        String winningLottoNumbers = "0,1,2,3,4,5";

        assertThatThrownBy(() -> LottoConverter.convertToLotto(winningLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호의 범위는 1 ~ 45까지 입니다.");
    }

    @Test
    void 당첨_번호는_서로_중복될_수_없다() {
        String winningLottoNumbers = "1,1,2,3,4,5";

        assertThatThrownBy(() -> LottoConverter.convertToLotto(winningLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또의 6개의 수는 중복될 수 없습니다.");
    }

    @Test
    void 보너스_번호는_당첨_번호와_중복_될_수_없다() {
        String winningLottoNumbers = "1,2,3,4,5,6";
        int bonusNumber = 6;

        Lotto winningLotto = LottoConverter.convertToLotto(winningLottoNumbers);

        assertThatThrownBy(() -> WinningLottoException.validateDuplicateCheckWinningLottoAndBonusNumber(winningLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
    }

    @Test
    void 보너스_번호의_범위는_1부터_45까지_이다() {
        int bonusNumber = 46;

        assertThatThrownBy(() -> BonusNumberException.validateNumberRange(bonusNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 로또 번호의 범위는 1 ~ 45까지 입니다.");
    }
}