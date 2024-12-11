package lotto.domain;

import lotto.common.dto.LottoMatchResult;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.List;
import java.util.Objects;

public class TargetLotto {
	
	private final Lotto number;
	private final LottoNumber bonusNumber;
	
	public TargetLotto(Lotto number, LottoNumber bonusNumber) {
		Objects.requireNonNull(number);
		Objects.requireNonNull(bonusNumber);
		this.number = number;
		this.bonusNumber = bonusNumber;
	}
	
	public static TargetLotto from(List<Integer> numbers, int bonusNumber) {
		return new TargetLotto(Lotto.from(numbers), LottoNumber.from(bonusNumber));
	}
	
	public LottoMatchResult matchPrize(List<Lotto> lottos) {
		EnumMap<LottoPrize, Integer> lottoPrizes = new EnumMap<>(LottoPrize.class);
		initailizeLottoPrizes(lottoPrizes);
		for (Lotto lotto : lottos) {
			LottoPrize lottoPrize = LottoPrize.calculatePrize(lotto.match(number), lotto.match(bonusNumber));
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
