package lotto.domain;

import lotto.common.exception.CustomExceptions;

public class LottoNumber {
	
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 45;
	
	private final int number;
	
	public LottoNumber(int number) {
		validate(number);
		this.number = number;
	}
	
	private static void validate(int number) {
		if (number < MIN_NUMBER || number > MAX_NUMBER) {
			throw CustomExceptions.INVALID_LOTTO_NUMBER_RANGE.get(MIN_NUMBER, MAX_NUMBER);
		}
	}
}
