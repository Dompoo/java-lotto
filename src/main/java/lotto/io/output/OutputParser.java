package lotto.io.output;

import lotto.domain.Lotto;

import java.util.List;

public class OutputParser {
	
	public String parseLottos(List<Lotto> lottos) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("%d개를 구매했습니다.\n".formatted(lottos.size()));
		for (Lotto lotto : lottos) {
			stringBuilder.append(lottos);
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}
}
