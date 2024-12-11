package lotto.io.input;

import lotto.common.exception.CustomExceptions;

public class InputValidator {
	
	public void validatePurchaseMoney(String input) {
		try {
			Integer.parseInt(input);
		} catch (IllegalArgumentException e) {
			throw CustomExceptions.INVALID_PURCHASE_MONEY_FORMAT.get();
		}
	}
}
