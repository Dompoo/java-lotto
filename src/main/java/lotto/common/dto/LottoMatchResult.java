package lotto.common.dto;

import lotto.domain.LottoPrize;

import java.math.BigDecimal;
import java.util.EnumMap;

public record LottoMatchResult(
		EnumMap<LottoPrize, Integer> winningDetails,
		BigDecimal totalIncome
) {
}
