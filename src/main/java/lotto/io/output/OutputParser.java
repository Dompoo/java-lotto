package lotto.io.output;

import lotto.domain.Lotto;
import lotto.domain.LottoPrize;

import java.util.EnumMap;
import java.util.List;

public class OutputParser {
	
	public String parseLottos(List<Lotto> lottos) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("%d개를 구매했습니다.\n".formatted(lottos.size()));
		for (Lotto lotto : lottos) {
			stringBuilder.append(lotto);
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}
	
	public String parseWinning(EnumMap<LottoPrize, Integer> lottoPrizes) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("당첨 통계\n");
		stringBuilder.append("---\n");
		lottoPrizes.forEach((lottoPrize, number) -> {
			stringBuilder.append("%d개 일치".formatted(lottoPrize.numberMatch));
			if (lottoPrize.bonusMatch) {
				stringBuilder.append("보너스 볼 일치");
			}
			stringBuilder.append("(%,d원) - %d개".formatted(lottoPrize.prizeMoney, number));
			stringBuilder.append("\n");
		});
		return stringBuilder.toString();
	}
}
