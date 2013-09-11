package com.izeye.playground.support.lotto.service;

import java.util.List;

import com.izeye.playground.support.lotto.domain.KoreanLottoGenerationLog;
import com.izeye.playground.support.lotto.domain.KoreanLottoGenerationRequest;
import com.izeye.playground.support.lotto.domain.KoreanLottoGenerationResponse;
import com.izeye.playground.support.lotto.domain.KoreanLottoNumbers;
import com.izeye.playground.support.lotto.domain.KoreanLottoWinningNumbers;

public interface KoreanLottoService {

	KoreanLottoGenerationResponse getLuckyNumbers(
			KoreanLottoGenerationRequest request);

	List<KoreanLottoGenerationLog> getAllKoreanLottoLogs();

	Integer getRank(KoreanLottoNumbers numbers,
			KoreanLottoWinningNumbers winningNumbers);

	Integer getRank(String numbers, String winningNumbers);

}
