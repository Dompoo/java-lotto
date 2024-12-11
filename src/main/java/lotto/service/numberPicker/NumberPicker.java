package lotto.service.numberPicker;

import java.util.List;

public interface NumberPicker {
	
	List<Integer> pickNumberInRange(int startInclusive, int endInclusive, int count);
}
