package lotto.domain;

import lotto.common.exception.CustomExceptions;
import lotto.service.numberPicker.NumberPicker;

import java.util.List;
import java.util.Objects;

public class LottoNumber {
	
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 45;
	
	private final int number;
	
	private LottoNumber(int number) {
		validate(number);
		this.number = number;
	}
	
	private static void validate(int number) {
		if (number < MIN_NUMBER || number > MAX_NUMBER) {
			throw CustomExceptions.INVALID_LOTTO_NUMBER_RANGE.get(MIN_NUMBER, MAX_NUMBER);
		}
	}
	
	public static List<LottoNumber> createUnique(int count, NumberPicker numberPicker) {
		List<Integer> numbers = numberPicker.pickNumberInRange(MIN_NUMBER, MAX_NUMBER, count);
		return numbers.stream()
				.map(LottoNumber::new)
				.toList();
	}
	
	public static LottoNumber from(int number) {
		return new LottoNumber(number);
	}
	
	public static List<LottoNumber> fromList(List<Integer> numbers) {
		return numbers.stream()
				.map(LottoNumber::new)
				.toList();
	}
	
	public String getStringValue() {
		return String.valueOf(number);
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof LottoNumber that)) return false;
		return number == that.number;
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(number);
	}
}
