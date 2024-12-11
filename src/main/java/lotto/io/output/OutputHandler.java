package lotto.io.output;

import lotto.domain.Lotto;
import lotto.io.writer.Writer;

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
}
