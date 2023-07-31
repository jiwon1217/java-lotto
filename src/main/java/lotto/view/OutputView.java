package lotto.view;

import lotto.constant.OutputMessage;
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
        System.out.printf(OutputMessage.NUMBER_OF_PURCHASED_LOTTOS.toString(), lottoCount.getLottoCount());
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
        System.out.println(OutputMessage.STATISTIC_HEADER);
        System.out.println(OutputMessage.STATISTIC_BORDER);

        for (Rank rank : Rank.getRankWithoutMiss()) {
            System.out.printf(OutputMessage.STATISTIC_BODY.toString(), rank.getMatchCount(), getMatchBonusBall(rank),
                    winnings.get(rank.getWinnings()), result.getRankCount(rank));
            System.out.println();
        }
    }

    private static String getMatchBonusBall(Rank rank) {
        if (rank.equals(Rank.SECOND)) {
            return OutputMessage.COMMA.toString() + OutputMessage.MATCH_BONUS_BALL;
        }
        return "";
    }

    public static void printYield(Result result, Money money) {
        double winnings = result.getWinnings();
        double yield = (winnings / money.getMoney()) * ONE_HUNDRED;
        System.out.printf(OutputMessage.TOTAL_YIELD.toString(), yield);
    }

    public static void printErrorMessage(String message){
        System.out.println(message);
    }
}
