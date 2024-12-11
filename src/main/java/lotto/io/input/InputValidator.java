package lotto.io.input;

import lotto.common.exception.CustomExceptions;

import java.util.regex.Pattern;

public class InputValidator {
	
	private static final Pattern TARGET_NUMBERS_PATTERN = Pattern.compile("(.+,)+.+");
	
	public void validatePurchaseMoney(String input) {
		try {
			Integer.parseInt(input);
		} catch (IllegalArgumentException e) {
			throw CustomExceptions.INVALID_PURCHASE_MONEY_FORMAT.get();
		}
	}
	
	public void validateTargetNumbers(String input) {
		if (!TARGET_NUMBERS_PATTERN.matcher(input).matches()) {
			throw CustomExceptions.INVALID_TARGET_NUMBERS_FORMAT.get();
		}
		try {
			for (String str : input.split(",")) {
				Integer.parseInt(str);
			}
		} catch (IllegalArgumentException e) {
			throw CustomExceptions.INVALID_TARGET_NUMBERS_FORMAT.get();
		}
	}
}
