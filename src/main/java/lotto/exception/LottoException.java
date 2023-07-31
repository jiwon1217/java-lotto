package lotto.exception;

import java.util.List;
import lotto.constant.ExceptionMessage;

public class LottoException {

    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final int LOTTO_LENGTH = 6;

    public static void validateLotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateNumberRange(numbers);
        validateDuplicateNumber(numbers);
    }

    private static void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_SIZE.toString());
        }
    }

    private static void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_RANGE || number > MAX_RANGE) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_RANGE.toString());
            }
        }
    }

    private static void validateDuplicateNumber(List<Integer> numbers) {
        int uniqueNumberCount = (int) numbers.stream()
            .distinct()
            .count();

        if (numbers.size() != uniqueNumberCount) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_LOTTO_NUMBER.toString());
        }
    }
}
