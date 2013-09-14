package com.izeye.playground.support.lotto.service;

import static com.izeye.playground.support.lotto.domain.KoreanLottoConstants.CLOSE_DAY_OF_WEEK_START;
import static com.izeye.playground.support.lotto.domain.KoreanLottoConstants.CLOSE_HOUR_START;
import static com.izeye.playground.support.lotto.domain.KoreanLottoConstants.NUMBER_COUNT;
import static com.izeye.playground.support.lotto.domain.KoreanLottoConstants.SELECTION_COUNT;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.izeye.playground.common.util.DateUtils;
import com.izeye.playground.support.lotto.dao.KoreanLottoDao;
import com.izeye.playground.support.lotto.domain.KoreanLottoGenerationLog;
import com.izeye.playground.support.lotto.domain.KoreanLottoGenerationRequest;
import com.izeye.playground.support.lotto.domain.KoreanLottoGenerationResponse;
import com.izeye.playground.support.lotto.domain.KoreanLottoNumbers;
import com.izeye.playground.support.lotto.domain.KoreanLottoSequencePeriod;
import com.izeye.playground.support.lotto.domain.KoreanLottoWinningLog;
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
	public KoreanLottoGenerationResponse generate(
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
	public List<KoreanLottoGenerationLog> getAllGenerationLogs() {
		List<KoreanLottoGenerationLog> allGenerationLogs = koreanLottoDao
				.getAllGenerationLogs();
		return analyze(allGenerationLogs);
	}

	@Override
	public List<KoreanLottoGenerationLog> getLatestGenerationLogs() {
		Date now = new Date();
		String drawingDay = getDrawingDay(now);
		KoreanLottoSequencePeriod sequencePeriod = getSequencePeriod(drawingDay);
		return getGenerationLogs(sequencePeriod);
	}

	@Override
	public List<KoreanLottoGenerationLog> getGenerationLogs(
			KoreanLottoSequencePeriod sequencePeriod) {
		return analyze(koreanLottoDao.getGenerationLogs(sequencePeriod));
	}

	@Override
	public List<KoreanLottoGenerationLog> getGenerationLogs(int sequence) {
		KoreanLottoWinningLog winningLog = koreanLottoDao
				.getWinningLog(sequence);
		String drawingDay = winningLog.getDay();
		KoreanLottoSequencePeriod sequencePeriod = getSequencePeriod(drawingDay);
		return getGenerationLogs(sequencePeriod);
	}

	private List<KoreanLottoGenerationLog> analyze(
			List<KoreanLottoGenerationLog> generationLogs) {
		for (KoreanLottoGenerationLog generationLog : generationLogs) {
			Date generatedTime = generationLog.getGeneratedTime();
			String drawingDay = getDrawingDay(generatedTime);
			KoreanLottoWinningLog winningLog = getWinningLog(drawingDay);
			if (winningLog == null) {
				continue;
			}
			generationLog.setSequence(winningLog.getSequence());
			Integer rank = getRank(generationLog.getNumbers(), winningLog);
			generationLog.setRank(rank);
			generationLog.setPrize(winningLog.getPrize(rank));
		}
		return generationLogs;
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

	@Override
	public Integer getRank(String numbers, Date generatedTime) {
		String drawingDay = getDrawingDay(generatedTime);
		KoreanLottoWinningLog winningLog = getWinningLog(drawingDay);
		if (winningLog == null) {
			return null;
		}
		return getRank(numbers, winningLog);
	}

	private Integer getRank(String numbers, KoreanLottoWinningLog winningLog) {
		String winningNumbers = winningLog.getNumbers();
		return getRank(numbers, winningNumbers);
	}

	@Override
	public List<KoreanLottoWinningLog> getAllWinningLogs() {
		return koreanLottoDao.getAllWinningLogs();
	}

	@Override
	public List<KoreanLottoWinningLog> getWinningLogsInSpecificYear(String year) {
		return koreanLottoDao.getWinningLogsInSpecificYear(year);
	}

	@Override
	public String getDrawingDay(Date generatedTime) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(generatedTime);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
		int remainingDays;
		if (dayOfWeek == CLOSE_DAY_OF_WEEK_START
				&& hourOfDay >= CLOSE_HOUR_START) {
			remainingDays = 7;
		} else {
			remainingDays = CLOSE_DAY_OF_WEEK_START - dayOfWeek;
		}
		long timestamp = generatedTime.getTime()
				+ TimeUnit.DAYS.toMillis(remainingDays);
		return DateUtils.formatDate(timestamp);
	}

	@Override
	public KoreanLottoWinningLog getWinningLog(String drawingDay) {
		return koreanLottoDao.getWinningLog(drawingDay);
	}

	@Override
	public KoreanLottoWinningLog getLatestWinningLog() {
		return koreanLottoDao.getLatestWinningLog();
	}

	@Override
	public KoreanLottoSequencePeriod getSequencePeriod(String drawingDay) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(DateUtils.parseDate(drawingDay));
		calendar.set(Calendar.HOUR_OF_DAY, CLOSE_HOUR_START);
		Date endTime = calendar.getTime();
		Date startTime = new Date(endTime.getTime() - TimeUnit.DAYS.toMillis(7));
		return new KoreanLottoSequencePeriod(startTime, endTime);
	}

}
