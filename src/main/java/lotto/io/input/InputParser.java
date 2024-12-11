package lotto.io.input;

import java.util.Arrays;
import java.util.List;

public class InputParser {
	
	public int parsePurchaseMoney(String input) {
		return Integer.parseInt(input);
	}
	
	public List<Integer> parseTargetNumbers(String input) {
		return Arrays.stream(input.split(","))
				.map(String::trim)
				.map(Integer::parseInt)
				.toList();
	}
}
