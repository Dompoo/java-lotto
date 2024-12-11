package lotto.io.output;

import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.io.writer.Writer;

import java.util.EnumMap;
import java.util.List;

public class OutputHandler {
	
	private final Writer writer;
	private final OutputParser outputParser;
	
	public OutputHandler(Writer writer, OutputParser outputParser) {
		this.writer = writer;
		this.outputParser = outputParser;
	}
	
	public void handleLottos(List<Lotto> lottos) {
		String output = outputParser.parseLottos(lottos);
		writer.write(output);
	}
	
	public void handleWinning(EnumMap<LottoPrize, Integer> lottoPrizes) {
		String output = outputParser.parseWinning(lottoPrizes);
		writer.write(output);
	}
}
