package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {

	당첨_1등(2_000_000_000, 6, false),
	당첨_2등(30_000_000, 5, true),
	당첨_3등(1_500_000, 5, false),
	당첨_4등(50_000, 4, false),
	당첨_5등(5_000, 3, false),
	낙첨(0, 0, false),
	;
	
	public final int prizeMoney;
	public final int numberMatch;
	public final boolean bonusMatch;
	
	LottoPrize(int prizeMoney, int numberMatch, boolean bonusMatch) {
		this.prizeMoney = prizeMoney;
		this.numberMatch = numberMatch;
		this.bonusMatch = bonusMatch;
	}
	
	public static LottoPrize calculatePrize(int numberMatch, boolean bonusMatch) {
		return Arrays.stream(LottoPrize.values())
				.filter(lottoPrize -> lottoPrize.numberMatch <= numberMatch)
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
