package com.izeye.playground.support.lotto.service;

import static com.izeye.playground.support.lotto.domain.KoreanLottoConstants.NUMBER_COUNT;
import static com.izeye.playground.support.lotto.domain.KoreanLottoConstants.SELECTION_COUNT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.izeye.playground.support.lotto.dao.KoreanLottoDao;
import com.izeye.playground.support.lotto.domain.KoreanLottoLog;
import com.izeye.playground.support.lotto.domain.KoreanLottoRequest;
import com.izeye.playground.support.lotto.domain.KoreanLottoResponse;

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

	@Override
	public KoreanLottoResponse getLuckyNumbers(KoreanLottoRequest request) {
		List<Integer> selectedNumbers = new ArrayList<Integer>();

		List<Integer> numbers = new ArrayList<Integer>(NUMBERS);
		for (int i = 0; i < SELECTION_COUNT; i++) {
			selectedNumbers.add(numbers.remove(RANDOM.get().nextInt(
					numbers.size())));
		}
		Collections.sort(selectedNumbers);

		KoreanLottoResponse response = new KoreanLottoResponse(selectedNumbers);
		koreanLottoDao.insert(request, response);
		return response;
	}

	@Override
	public List<KoreanLottoLog> getAllKoreanLottoLogs() {
		return koreanLottoDao.getAllKoreanLottoLogs();
	}

}
