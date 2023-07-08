package lotto.domain;

import java.util.Collections;
import java.util.List;

import static lotto.exception.LottoException.validateDuplicateNumber;
import static lotto.exception.LottoException.validateLottoSize;
import static lotto.exception.LottoException.validateNumberRange;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateNumberRange(numbers);
        validateDuplicateNumber(numbers);
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
