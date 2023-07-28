package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoCount;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.result.Rank;
import lotto.model.result.Result;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String COMMA = ", ";
    private static final String NUMBER_OF_PURCHASED_LOTTOS = "%d개를 구매했습니다.";
    private static final String STATISTIC_HEADER = "당첨 통계";
    private static final String STATISTIC_BORDER = "---";
    private static final String STATISTIC_BODY = "%d개 일치%s (%s원) - %d개";
    private static final String MATCH_BONUS_BALL = "보너스 볼 일치";
    private static final String TOTAL_YIELD = "총 수익률은 %.1f%%입니다.";
    private static final int ONE_HUNDRED = 100;

    private static final Map<Integer, String> winnings = createWinningsMap();

    private static Map<Integer, String> createWinningsMap() {
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(2_000_000_000, "2,000,000,000");
        map.put(30_000_000, "30,000,000");
        map.put(1_500_000, "1,500,000");
        map.put(50_000, "50,000");
        map.put(5_000, "5,000");
        return map;
    }

    public static void printLottoCount(LottoCount lottoCount) {
        System.out.println(NEW_LINE);
        System.out.printf(NUMBER_OF_PURCHASED_LOTTOS, lottoCount.getLottoCount());
        System.out.println(NEW_LINE);
    }

    public static void printPurchasedLottoNumbers(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            List<Integer> numbers = new ArrayList<>(lotto.get());
            Collections.sort(numbers);
            System.out.println(numbers);
        }
        System.out.println(NEW_LINE);
    }

    public static void printStatistic(Result result) {
        System.out.println(NEW_LINE);
        System.out.println(STATISTIC_HEADER);
        System.out.println(STATISTIC_BORDER);

        for (Rank rank : Rank.getRankWithoutMiss()) {
            System.out.printf(STATISTIC_BODY, rank.getMatchCount(), getMatchBonusBall(rank),
                    winnings.get(rank.getWinnings()), result.getRankCount(rank));
            System.out.println();
        }
    }

    private static String getMatchBonusBall(Rank rank) {
        if (rank.equals(Rank.SECOND)) {
            return COMMA + MATCH_BONUS_BALL;
        }
        return "";
    }

    public static void printYield(Result result, Money money) {
        double winnings = result.getWinnings();
        double yield = (winnings / money.getMoney()) * ONE_HUNDRED;
        System.out.printf(TOTAL_YIELD, yield);
    }

    public static void printErrorMessage(String message){
        System.out.println(message);
    }
}
