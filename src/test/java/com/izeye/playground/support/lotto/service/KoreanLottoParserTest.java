package com.izeye.playground.support.lotto.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.izeye.playground.support.lotto.domain.KoreanLottoNumbers;
import com.izeye.playground.support.lotto.domain.KoreanLottoWinningNumbers;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@ActiveProfiles("dev")
public class KoreanLottoParserTest {

	@Resource
	private KoreanLottoParser koreanLottoParser;

	@Test
	public void parseNumbers() {
		Set<Integer> expectedNumbers = new HashSet<Integer>(
				Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }));

		String numbers = "1,2,3,4,5,6";
		KoreanLottoNumbers koreanLottoNumbers = koreanLottoParser
				.parseNumbers(numbers);

		assertThat(koreanLottoNumbers.getNumbers(), is(expectedNumbers));
	}

	@Test(expected = IllegalArgumentException.class)
	public void parseNumbersWith5Numbers() {
		String numbers = "1,2,3,4,5";
		koreanLottoParser.parseNumbers(numbers);
	}

	@Test(expected = IllegalArgumentException.class)
	public void parseNumbersWith7Numbers() {
		String numbers = "1,2,3,4,5,6,7";
		koreanLottoParser.parseNumbers(numbers);
	}

	@Test(expected = IllegalArgumentException.class)
	public void parseNumbersWithNumber0() {
		String numbers = "0,2,3,4,5,6";
		koreanLottoParser.parseNumbers(numbers);
	}

	@Test(expected = IllegalArgumentException.class)
	public void parseNumbersWithNumber46() {
		String numbers = "1,2,3,4,5,46";
		koreanLottoParser.parseNumbers(numbers);
	}

	@Test
	public void parseWinningNumbers() {
		Set<Integer> expectedNumbers = new HashSet<Integer>(
				Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6 }));
		int expectedBonusNumber = 7;

		String winningNumbers = "1,2,3,4,5,6,7";
		KoreanLottoWinningNumbers koreanLottoWinningNumbers = koreanLottoParser
				.parseWinningNumbers(winningNumbers);

		assertThat(koreanLottoWinningNumbers.getNumbers().getNumbers(),
				is(expectedNumbers));
		assertThat(koreanLottoWinningNumbers.getBonusNumber(),
				is(expectedBonusNumber));
	}

	@Test(expected = IllegalArgumentException.class)
	public void parseWinningNumbersWith6Numbers() {
		String numbers = "1,2,3,4,5,6";
		koreanLottoParser.parseWinningNumbers(numbers);
	}

	@Test(expected = IllegalArgumentException.class)
	public void parseWinningNumbersWith8Numbers() {
		String numbers = "1,2,3,4,5,6,7,8";
		koreanLottoParser.parseWinningNumbers(numbers);
	}

	@Test(expected = IllegalArgumentException.class)
	public void parseWinningNumbersWithBonusNumber0() {
		String numbers = "1,2,3,4,5,6,0";
		koreanLottoParser.parseWinningNumbers(numbers);
	}

	@Test(expected = IllegalArgumentException.class)
	public void parseWinningNumbersWithBonusNumber46() {
		String numbers = "1,2,3,4,5,6,46";
		koreanLottoParser.parseWinningNumbers(numbers);
	}

}
