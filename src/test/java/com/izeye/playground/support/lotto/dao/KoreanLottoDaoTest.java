package com.izeye.playground.support.lotto.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.izeye.playground.support.lotto.domain.KoreanLottoGenerationLog;
import com.izeye.playground.support.lotto.domain.KoreanLottoGenerationRequest;
import com.izeye.playground.support.lotto.domain.KoreanLottoGenerationResponse;
import com.izeye.playground.support.lotto.domain.KoreanLottoSequencePeriod;
import com.izeye.playground.support.lotto.domain.KoreanLottoWinningLog;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@ActiveProfiles("dev")
public class KoreanLottoDaoTest {

	@Resource
	private KoreanLottoDao koreanLottoDao;

	@Test
	public void insertGenerationLog() {
		String ip = "1.2.3.4";
		List<Integer> numbers = Arrays
				.asList(new Integer[] { 1, 2, 3, 4, 5, 6 });

		KoreanLottoGenerationRequest request = new KoreanLottoGenerationRequest(
				ip);
		KoreanLottoGenerationResponse response = new KoreanLottoGenerationResponse(
				numbers);

		koreanLottoDao.insert(request, response);
	}

	@Test
	public void getAllGenerationLogs() {
		List<KoreanLottoGenerationLog> allGenerationLogs = koreanLottoDao
				.getAllGenerationLogs();
		System.out.println(allGenerationLogs);
	}

	@Test
	public void getGenerationLogs() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2013);
		calendar.set(Calendar.MONTH, 7); // 8
		calendar.set(Calendar.DAY_OF_MONTH, 31);
		calendar.set(Calendar.HOUR_OF_DAY, 20);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date startTime = calendar.getTime();

		calendar.set(Calendar.MONTH, 8); // 9
		calendar.set(Calendar.DAY_OF_MONTH, 7);
		calendar.set(Calendar.HOUR_OF_DAY, 20);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date endTime = calendar.getTime();
		KoreanLottoSequencePeriod sequencePeriod = new KoreanLottoSequencePeriod(
				startTime, endTime);
		koreanLottoDao.getGenerationLogs(sequencePeriod);
	}

	@Test
	public void insertWinningLog() {
		int sequence = 1;
		String day = "2013-09-11";
		String numbers = "1,2,3,4,5,6,7";
		int prize1 = 1;
		int prize2 = 2;
		int prize3 = 3;
		int prize4 = 4;
		int prize5 = 5;

		KoreanLottoWinningLog winningLogs = new KoreanLottoWinningLog(sequence,
				day, numbers, prize1, prize2, prize3, prize4, prize5);

		koreanLottoDao.insert(winningLogs);
	}

	@Test
	public void getAllWinningLogs() {
		List<KoreanLottoWinningLog> allWinningNumbers = koreanLottoDao
				.getAllWinningLogs();
		System.out.println(allWinningNumbers);
	}

	@Test
	public void getWinningLogsInSpecificYear() {
		String year = "2010";
		List<KoreanLottoWinningLog> winningLogs = koreanLottoDao
				.getWinningLogsInSpecificYear(year);
		System.out.println(winningLogs);
	}

	@Test
	public void getWinningLogWithSequence() {
		int sequence = 562;

		String day = "2013-09-07";
		String numbers = "4,11,13,17,20,31,33";
		int prize1 = 1166694614;
		int prize2 = 41940003;
		int prize3 = 1195607;
		int prize4 = 50000;
		int prize5 = 5000;

		KoreanLottoWinningLog expected = new KoreanLottoWinningLog(sequence,
				day, numbers, prize1, prize2, prize3, prize4, prize5);

		assertThat(koreanLottoDao.getWinningLog(sequence), is(expected));
	}

	@Test
	public void getWinningLogWithDrawingDay() {
		String drawingDay = "2013-09-07";

		int sequence = 562;
		String numbers = "4,11,13,17,20,31,33";
		int prize1 = 1166694614;
		int prize2 = 41940003;
		int prize3 = 1195607;
		int prize4 = 50000;
		int prize5 = 5000;

		KoreanLottoWinningLog expected = new KoreanLottoWinningLog(sequence,
				drawingDay, numbers, prize1, prize2, prize3, prize4, prize5);

		assertThat(koreanLottoDao.getWinningLog(drawingDay), is(expected));
	}

	@Test
	public void getLatestWinningLog() {
		KoreanLottoWinningLog latestWinningLog = koreanLottoDao
				.getLatestWinningLog();
		System.out.println(latestWinningLog);
	}

}
