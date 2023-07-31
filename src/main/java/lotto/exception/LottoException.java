package lotto.exception;

import java.util.List;

public class LottoException {

    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final int LOTTO_LENGTH = 6;
    public static final String INVALID_LOTTO_SIZE = "[ERROR] 로또는 6개의 숫자로 이루어져야 합니다.";
    public static final String INVALID_NUMBER_RANGE = "[ERROR] 로또 번호의 범위는 1 ~ 45까지 입니다.";
    public static final String DUPLICATE_LOTTO_NUMBER = "[ERROR] 로또의 6개의 수는 중복될 수 없습니다.";

    public static void validateLotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateNumberRange(numbers);
        validateDuplicateNumber(numbers);
    }

    private static void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE);
        }
    }

    private static void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_RANGE || number > MAX_RANGE) {
                throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
            }
        }
    }

    private static void validateDuplicateNumber(List<Integer> numbers) {
        int uniqueNumberCount = (int) numbers.stream()
            .distinct()
            .count();

        if (numbers.size() != uniqueNumberCount) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER);
        }
    }
}
