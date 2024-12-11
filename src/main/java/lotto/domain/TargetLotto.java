package lotto.domain;

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
	
	public EnumMap<LottoPrize, Integer> matchPrize(List<Lotto> lottos) {
		EnumMap<LottoPrize, Integer> lottoPrizes = new EnumMap<>(LottoPrize.class);
		for (Lotto lotto : lottos) {
			LottoPrize lottoPrize = LottoPrize.calculatePrize(
					lotto.match(number),
					lotto.match(bonusNumber)
			);
			lottoPrizes.put(lottoPrize, lottoPrizes.getOrDefault(lottoPrize, 0) + 1);
		}
		return lottoPrizes;
	}
}
