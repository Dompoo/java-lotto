package lotto.io.input;

import lotto.io.reader.Reader;
import lotto.io.writer.Writer;

import java.util.List;

public class InputHandler {
	
	private final Reader reader;
	private final Writer writer;
	private final InputValidator inputValidator;
	private final InputParser inputParser;
	
	public InputHandler(Reader reader, Writer writer, InputValidator inputValidator, InputParser inputParser) {
		this.reader = reader;
		this.writer = writer;
		this.inputValidator = inputValidator;
		this.inputParser = inputParser;
	}
	
	public int handlePurchaseMoney() {
		writer.write("\n구입금액을 입력해 주세요.\n");
		String input = reader.readLine();
		inputValidator.validatePurchaseMoney(input);
		return inputParser.parsePurchaseMoney(input);
	}
	
	public List<Integer> handleTargetNumbers() {
		writer.write("\n당첨 번호를 입력해 주세요.\n");
		String input = reader.readLine();
		inputValidator.validateTargetNumbers(input);
		return inputParser.parseTargetNumbers(input);
	}
	
	public int handleBonusNumber() {
		writer.write("\n보너스 번호를 입력해 주세요.\n");
		String input = reader.readLine();
		inputValidator.validateBonusNumber(input);
		return inputParser.parseBonusNumber(input);
	}
}
