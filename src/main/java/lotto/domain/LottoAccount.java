package lotto.domain;

import lotto.common.exception.CustomExceptions;

public class LottoAccount {
	
	private static final int MONEY_UNIT = 1000;
	
	private final int money;
	
	public LottoAccount(int money) {
		validate(money);
		this.money = money;
	}
	
	private static void validate(int money) {
		if (money % MONEY_UNIT != 0) {
			throw CustomExceptions.INVALID_MONEY_UNIT.get(MONEY_UNIT);
		}
	}
	
	public int getMoneyDividedBy(int divide) {
		return money / divide;
	}
}
