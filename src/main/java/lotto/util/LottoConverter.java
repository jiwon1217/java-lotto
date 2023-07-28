package lotto.util;

import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class LottoConverter {

    public static Lotto convertToLotto(String winningLottoNumbers) {
        return new Lotto(Arrays.stream(winningLottoNumbers.split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toList()));
    }
}

