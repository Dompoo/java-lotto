package lotto.domain;

import java.util.Objects;

public class TargetLotto {
	
	private final Lotto target;
	private final LottoNumber bonusNumber;
	
	public TargetLotto(Lotto target, LottoNumber bonusNumber) {
		Objects.requireNonNull(target);
		Objects.requireNonNull(bonusNumber);
		this.target = target;
		this.bonusNumber = bonusNumber;
	}
}
