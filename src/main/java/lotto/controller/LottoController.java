package lotto.controller;

import lotto.common.RetryHandler;
import lotto.common.dto.LottoMatchResult;
import lotto.domain.Lotto;
import lotto.domain.LottoAccount;
import lotto.domain.TargetLotto;
import lotto.io.input.InputHandler;
import lotto.io.output.OutputHandler;
import lotto.service.numberPicker.NumberPicker;

import java.util.List;

public class LottoController {
	
	private final InputHandler inputHandler;
	private final OutputHandler outputHandler;
	private final RetryHandler retryHandler;
	private final NumberPicker numberPicker;
	
	public LottoController(InputHandler inputHandler, OutputHandler outputHandler, RetryHandler retryHandler, NumberPicker numberPicker) {
		this.inputHandler = inputHandler;
		this.outputHandler = outputHandler;
		this.retryHandler = retryHandler;
		this.numberPicker = numberPicker;
	}
	
	public void run() {
		LottoAccount lottoAccount = retryHandler.tryUntilSuccess(() -> {
			int purchaseMoney = inputHandler.handlePurchaseMoney();
			return new LottoAccount(purchaseMoney);
		});
		
		List<Lotto> lottos = Lotto.craete(lottoAccount, numberPicker);
		outputHandler.handleLottos(lottos);
		
		TargetLotto targetLotto = retryHandler.tryUntilSuccess(() -> {
			List<Integer> numbers = inputHandler.handleTargetNumbers();
			int bonusNumber = inputHandler.handleBonusNumber();
			return TargetLotto.from(numbers, bonusNumber);
		});
		
		LottoMatchResult result = targetLotto.matchPrize(lottos);
		outputHandler.handleWinning(result.winningDetails());
		outputHandler.handleStatics(lottoAccount.getMoney(), result.totalIncome());
	}
}
