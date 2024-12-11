package lotto.domain;

import java.util.ArrayList;
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
	
	public List<LottoPrize> matchPrize(List<Lotto> lottos) {
		List<LottoPrize> lottoPrizes = new ArrayList<>();
		for (Lotto lotto : lottos) {
			int numberMatch = lotto.match(number);
			boolean bonusMatch = lotto.match(bonusNumber);
			lottoPrizes.add(LottoPrize.calculatePrize(numberMatch, bonusMatch));
		}
		return lottoPrizes;
	}
}
