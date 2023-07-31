package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoNumber;
import lotto.model.Lotto;
import lotto.model.LottoCount;
import lotto.model.Lottos;

public class LottoNumberGenerator {

    public static Lottos generateLottos(LottoCount lottoCount) {
        return generateLottoNumbers(lottoCount);
    }

    public static Lottos generateLottoNumbers(LottoCount lottoCount) {
        int count = lottoCount.getLottoCount();
        Lottos lottos = new Lottos();

        while (count > 0) {
            Lotto lotto = generateLotto();
            lottos.addLotto(lotto);
            count--;
        }

        return lottos;
    }

    private static Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(LottoNumber.MIN_RANGE, LottoNumber.MAX_RANGE, LottoNumber.LOTTO_LENGTH));
    }
}
