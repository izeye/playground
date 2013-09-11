package com.izeye.playground.support.lotto.service;

import static com.izeye.playground.support.lotto.domain.KoreanLottoConstants.NUMBER_COUNT;
import static com.izeye.playground.support.lotto.domain.KoreanLottoConstants.SELECTION_COUNT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.izeye.playground.support.lotto.dao.KoreanLottoDao;
import com.izeye.playground.support.lotto.domain.KoreanLottoGenerationLog;
import com.izeye.playground.support.lotto.domain.KoreanLottoGenerationRequest;
import com.izeye.playground.support.lotto.domain.KoreanLottoGenerationResponse;
import com.izeye.playground.support.lotto.domain.KoreanLottoNumbers;
import com.izeye.playground.support.lotto.domain.KoreanLottoWinningNumbers;

@Service("lottoService")
public class DefaultKoreanLottoService implements KoreanLottoService {

	private final ThreadLocal<Random> RANDOM = new ThreadLocal<Random>() {
		protected Random initialValue() {
			return new Random();
		}
	};

	private static final List<Integer> NUMBERS = new ArrayList<Integer>();
	static {
		for (int i = 1; i <= NUMBER_COUNT; i++) {
			NUMBERS.add(i);
		}
	}

	@Resource
	private KoreanLottoDao koreanLottoDao;

	@Resource
	private KoreanLottoParser koreanLottoParser;

	@Override
	public KoreanLottoGenerationResponse getLuckyNumbers(
			KoreanLottoGenerationRequest request) {
		List<Integer> selectedNumbers = new ArrayList<Integer>();

		List<Integer> numbers = new ArrayList<Integer>(NUMBERS);
		for (int i = 0; i < SELECTION_COUNT; i++) {
			selectedNumbers.add(numbers.remove(RANDOM.get().nextInt(
					numbers.size())));
		}
		Collections.sort(selectedNumbers);

		KoreanLottoGenerationResponse response = new KoreanLottoGenerationResponse(
				selectedNumbers);
		koreanLottoDao.insert(request, response);
		return response;
	}

	@Override
	public List<KoreanLottoGenerationLog> getAllKoreanLottoLogs() {
		return koreanLottoDao.getAllGenerationLogs();
	}

	@Override
	public Integer getRank(KoreanLottoNumbers numbers,
			KoreanLottoWinningNumbers winningNumbers) {
		Set<Integer> numbersSet = numbers.getNumbers();
		Set<Integer> winningNumberSet = winningNumbers.getNumbers()
				.getNumbers();
		winningNumberSet.removeAll(numbersSet);
		switch (winningNumberSet.size()) {
		case 0:
			return 1;

		case 1:
			return numbersSet.contains(winningNumbers.getBonusNumber()) ? 2 : 3;

		case 2:
			return 4;

		case 3:
			return 5;

		default:
			return 6;
		}
	}

	@Override
	public Integer getRank(String numbers, String winningNumbers) {
		return getRank(koreanLottoParser.parseNumbers(numbers),
				koreanLottoParser.parseWinningNumbers(winningNumbers));
	}

}
