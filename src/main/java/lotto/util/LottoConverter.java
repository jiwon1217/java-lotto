package lotto.util;

import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class LottoConverter {

    public static Lotto convertToLotto(String winningLotto) {
        return new Lotto(Arrays.stream(winningLotto.split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toList()));
    }
}

