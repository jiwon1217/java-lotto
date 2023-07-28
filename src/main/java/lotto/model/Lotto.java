package lotto.model;

import java.util.Collections;
import java.util.List;
import lotto.exception.LottoException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoException.validateLotto(numbers);
        this.numbers = numbers;
    }

    public List<Integer> get() {
        return Collections.unmodifiableList(numbers);
    }

    public int countSameNumber(WinningLotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto::isContain)
                .count();
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }
}
