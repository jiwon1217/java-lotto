package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.Lottos;

public class LottoNumberGenerator {

    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final int LOTTO_LENGTH = 6;

    public Lottos generateLottos(LottoCount lottoCount) {
        return generateLottoNumbers(lottoCount);
    }

    public Lottos generateLottoNumbers(LottoCount lottoCount) {
        int count = lottoCount.getLottoCount();
        Lottos lottos = new Lottos();

        while (count > 0) {
            Lotto lotto = generateLotto();
            lottos.addLotto(lotto);
            count--;
        }

        return lottos;
    }

    private Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, LOTTO_LENGTH));
    }
}
