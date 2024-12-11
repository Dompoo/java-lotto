package lotto.domain;

import lotto.common.dto.LottoMatchResult;
import lotto.common.exception.CustomExceptions;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.List;
import java.util.Objects;

public class TargetLotto {
	
	private final Lotto numbers;
	private final LottoNumber bonusNumber;
	
	public TargetLotto(Lotto numbers, LottoNumber bonusNumber) {
		Objects.requireNonNull(numbers);
		Objects.requireNonNull(bonusNumber);
		validate(numbers, bonusNumber);
		this.numbers = numbers;
		this.bonusNumber = bonusNumber;
	}
	
	private void validate(Lotto numbers, LottoNumber bonusNumber) {
		if (numbers.match(bonusNumber)) {
			throw CustomExceptions.DUPLICATED_LOTTO_NUMBER_AND_BONUS_NUMBER.get();
		}
	}
	
	public static TargetLotto from(Lotto numbers, LottoNumber bonusNumber) {
		return new TargetLotto(numbers, bonusNumber);
	}
	
	public LottoMatchResult matchPrize(List<Lotto> lottos) {
		EnumMap<LottoPrize, Integer> lottoPrizes = new EnumMap<>(LottoPrize.class);
		initailizeLottoPrizes(lottoPrizes);
		for (Lotto lotto : lottos) {
			LottoPrize lottoPrize = LottoPrize.calculatePrize(lotto.match(numbers), lotto.match(bonusNumber));
			lottoPrizes.put(lottoPrize, lottoPrizes.get(lottoPrize) + 1);
		}
		BigDecimal totalIncome = calculateTotalIncome(lottoPrizes);
		return new LottoMatchResult(lottoPrizes, totalIncome);
	}
	
	private void initailizeLottoPrizes(EnumMap<LottoPrize, Integer> lottoPrizes) {
		for (LottoPrize lottoPrize : LottoPrize.values()) {
			lottoPrizes.put(lottoPrize, 0);
		}
	}
	
	private static BigDecimal calculateTotalIncome(EnumMap<LottoPrize, Integer> lottoPrizes) {
		BigDecimal totalIncome = BigDecimal.ZERO;
		for (LottoPrize lottoPrize : LottoPrize.values()) {
			totalIncome = totalIncome.add(BigDecimal.valueOf((long) lottoPrizes.get(lottoPrize) * lottoPrize.prizeMoney));
		}
		return totalIncome;
	}
}
