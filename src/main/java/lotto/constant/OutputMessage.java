package lotto.constant;

public enum OutputMessage {

    COMMA(", "),
    NUMBER_OF_PURCHASED_LOTTOS("%d개를 구매했습니다."),
    STATISTIC_HEADER("당첨 통계"),
    STATISTIC_BORDER("---"),
    STATISTIC_BODY("%d개 일치%s (%s원) - %d개"),
    MATCH_BONUS_BALL("보너스 볼 일치"),
    TOTAL_YIELD("총 수익률은 %.1f%%입니다.");

    private String message;

    OutputMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
