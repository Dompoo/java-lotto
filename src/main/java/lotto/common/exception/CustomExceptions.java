package lotto.common.exception;

public enum CustomExceptions {
	
	INVALID_PURCHASE_MONEY_FORMAT(
			"구입금액 입력 포맷이 잘못되었습니다.",
			IllegalArgumentException.class
	),
	INVALID_TARGET_NUMBERS_FORMAT(
			"당첨 번호 입력 포맷이 잘못되었습니다.",
			IllegalArgumentException.class
	),
	INVALID_BONUS_NUMBER_FORMAT(
			"보너스 번호 입력 포맷이 잘못되었습니다.",
			IllegalArgumentException.class
	),
	INVALID_LOTTO_NUMBER_RANGE(
			"로또 번호는 %d~%d 사이여야 합니다.",
			IllegalArgumentException.class
	),
	INVALID_LOTTO_NUMBER_COUNT(
			"로또 번호는 %d개여야 합니다.",
			IllegalArgumentException.class
	),
	DUPLICATED_LOTTO_NUMBER_AND_BONUS_NUMBER(
			"로또 번호와 보너스 번호는 중복될 수 없습니다.",
			IllegalArgumentException.class
	),
	DUPLICATED_LOTTO_NUMBER(
			"로또 번호는 중복될 수 없습니다.",
			IllegalArgumentException.class
	),
	INVALID_MONEY_UNIT(
			"금액은 %d원 단위여야 합니다.",
			IllegalArgumentException.class
	),
	OVER_MAX_RETRY_ATTEPMT(
			"최대 재시도 회수를 초과했습니다.",
			IllegalStateException.class
	),
	;
	
	private final String message;
	private final Class<? extends RuntimeException> exceptionType;
	
	CustomExceptions(String message, Class<? extends RuntimeException> exceptionType) {
		this.message = message;
		this.exceptionType = exceptionType;
	}
	
	public RuntimeException get(Object... args) {
		try {
			return exceptionType.getDeclaredConstructor(String.class).newInstance(message.formatted(args));
		} catch (Exception e) {
			return new RuntimeException(message);
		}
	}
}
