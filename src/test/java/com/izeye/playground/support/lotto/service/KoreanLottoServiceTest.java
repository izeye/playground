package com.izeye.playground.support.lotto.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.izeye.playground.support.lotto.domain.KoreanLottoSequencePeriod;
import com.izeye.playground.support.lotto.domain.KoreanLottoWinningLog;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@ActiveProfiles("dev")
public class KoreanLottoServiceTest {

	@Resource
	private KoreanLottoService koreanLottoService;

	@Test
	public void getRank() {
		String numbers = "1,2,3,4,5,6";
		String winningNumbers = "1,2,3,4,5,6,7";
		assertThat(koreanLottoService.getRank(numbers, winningNumbers), is(1));

		numbers = "1,2,3,4,5,6";
		winningNumbers = "1,2,3,4,5,7,6";
		assertThat(koreanLottoService.getRank(numbers, winningNumbers), is(2));

		numbers = "1,2,3,4,5,6";
		winningNumbers = "1,2,3,4,5,7,8";
		assertThat(koreanLottoService.getRank(numbers, winningNumbers), is(3));

		numbers = "1,2,3,4,5,6";
		winningNumbers = "1,2,3,4,7,8,9";
		assertThat(koreanLottoService.getRank(numbers, winningNumbers), is(4));

		numbers = "1,2,3,4,5,6";
		winningNumbers = "1,2,3,7,8,9,10";
		assertThat(koreanLottoService.getRank(numbers, winningNumbers), is(5));

		numbers = "1,2,3,4,5,6";
		winningNumbers = "1,2,7,8,9,10,11";
		assertThat(koreanLottoService.getRank(numbers, winningNumbers), is(6));

		numbers = "1,2,3,4,5,6";
		winningNumbers = "1,7,8,9,10,11,12";
		assertThat(koreanLottoService.getRank(numbers, winningNumbers), is(6));

		numbers = "1,2,3,4,5,6";
		winningNumbers = "7,8,9,10,11,12,13";
		assertThat(koreanLottoService.getRank(numbers, winningNumbers), is(6));
	}

	@Test
	public void getRankWithNumbersAndDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2013);
		calendar.set(Calendar.MONTH, 8); // 9
		calendar.set(Calendar.DAY_OF_MONTH, 6);
		Date date = calendar.getTime();
		assertThat(koreanLottoService.getRank("4,11,13,17,20,31", date), is(1));
		assertThat(koreanLottoService.getRank("1,2,3,17,20,31", date), is(5));
		assertThat(koreanLottoService.getRank("1,2,3,4,5,6", date), is(6));

		calendar.set(Calendar.DAY_OF_MONTH, 7);
		calendar.set(Calendar.HOUR_OF_DAY, 19);
		date = calendar.getTime();
		assertThat(koreanLottoService.getRank("4,11,13,17,20,31", date), is(1));

		calendar.set(Calendar.HOUR_OF_DAY, 20);
		date = calendar.getTime();
		assertThat(koreanLottoService.getRank("4,11,13,17,20,31", date),
				is(nullValue()));

		calendar.set(Calendar.DAY_OF_MONTH, 8);
		date = calendar.getTime();
		assertThat(koreanLottoService.getRank("4,11,13,17,20,31", date),
				is(nullValue()));
	}

	@Test
	public void getAllWinningLogs() {
		List<KoreanLottoWinningLog> allWinningLogs = koreanLottoService
				.getAllWinningLogs();
		System.out.println(allWinningLogs);
	}

	@Test
	public void getDrawingDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2013);
		calendar.set(Calendar.MONTH, 8); // 9
		calendar.set(Calendar.DAY_OF_MONTH, 6);
		Date generatedTime = calendar.getTime();
		assertThat(koreanLottoService.getDrawingDay(generatedTime),
				is("2013-09-07"));

		calendar.set(Calendar.DAY_OF_MONTH, 7);
		calendar.set(Calendar.HOUR_OF_DAY, 19);
		generatedTime = calendar.getTime();
		assertThat(koreanLottoService.getDrawingDay(generatedTime),
				is("2013-09-07"));

		calendar.set(Calendar.HOUR_OF_DAY, 20);
		generatedTime = calendar.getTime();
		assertThat(koreanLottoService.getDrawingDay(generatedTime),
				is("2013-09-14"));

		calendar.set(Calendar.DAY_OF_MONTH, 8);
		generatedTime = calendar.getTime();
		assertThat(koreanLottoService.getDrawingDay(generatedTime),
				is("2013-09-14"));
	}

	@Test
	public void getSequencePeriod() {
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
		KoreanLottoSequencePeriod expected = new KoreanLottoSequencePeriod(
				startTime, endTime);
		String drawingDay = "2013-09-07";
		assertThat(koreanLottoService.getSequencePeriod(drawingDay),
				is(expected));
	}

}
