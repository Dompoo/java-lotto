package lotto.domain;

import lotto.common.exception.CustomExceptions;
import lotto.service.numberPicker.NumberPicker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    
    private static final int LOTTO_NUMBER_COUNT = 6;
    
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw CustomExceptions.INVALID_LOTTO_NUMBER_COUNT.get(LOTTO_NUMBER_COUNT);
        }
        
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw CustomExceptions.DUPLICATED_LOTTO_NUMBER.get();
        }
    }
    
    public static Lotto from(List<Integer> numbers) {
        return new Lotto(LottoNumber.fromList(numbers));
    }

    public static List<Lotto> craete(int count, NumberPicker numberPicker) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<LottoNumber> numbers = LottoNumber.createUnique(LOTTO_NUMBER_COUNT, numberPicker);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }
    
    public int match(Lotto lotto) {
        int count = 0;
        for (LottoNumber number : lotto.numbers) {
            if (numbers.contains(number)) {
                count++;
            }
        }
        return count;
    }
    
    public boolean match(LottoNumber bonusNumber) {
		return numbers.contains(bonusNumber);
	}
}
