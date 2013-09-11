package com.izeye.playground.support.lotto.service;

import com.izeye.playground.support.lotto.domain.KoreanLottoNumbers;
import com.izeye.playground.support.lotto.domain.KoreanLottoWinningNumbers;

public interface KoreanLottoParser {

	KoreanLottoNumbers parseNumbers(String numbers);

	KoreanLottoWinningNumbers parseWinningNumbers(String winningNumbers);

}
