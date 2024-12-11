package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {

	당첨_1등(6, false),
	당첨_2등(5, true),
	당첨_3등(5, false),
	당첨_4등(4, false),
	당첨_5등(3, false),
	낙첨(0, false),
	;
	
	private final int numberMatch;
	private final boolean bonusMatch;
	
	LottoPrize(int numberMatch, boolean bonusMatch) {
		this.numberMatch = numberMatch;
		this.bonusMatch = bonusMatch;
	}
	
	public static LottoPrize calculatePrize(int numberMatch, boolean bonusMatch) {
		return Arrays.stream(LottoPrize.values())
				.filter(lottoPrize -> lottoPrize.numberMatch >= numberMatch)
				.filter(lottoPrize -> {
					if (bonusMatch) {
						return lottoPrize.bonusMatch;
					}
					return true;
				})
				.findFirst()
				.orElse(LottoPrize.낙첨);
	}
}
