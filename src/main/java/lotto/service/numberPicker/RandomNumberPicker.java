package lotto.service.numberPicker;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumberPicker implements NumberPicker {
	
	@Override
	public List<Integer> pickNumberInRange(int startInclusive, int endInclusive, int count) {
		return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
	}
}
