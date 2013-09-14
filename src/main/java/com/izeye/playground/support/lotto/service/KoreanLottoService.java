package com.izeye.playground.support.lotto.service;

import java.util.Date;
import java.util.List;

import com.izeye.playground.support.lotto.domain.KoreanLottoGenerationLog;
import com.izeye.playground.support.lotto.domain.KoreanLottoGenerationRequest;
import com.izeye.playground.support.lotto.domain.KoreanLottoGenerationResponse;
import com.izeye.playground.support.lotto.domain.KoreanLottoNumbers;
import com.izeye.playground.support.lotto.domain.KoreanLottoSequencePeriod;
import com.izeye.playground.support.lotto.domain.KoreanLottoWinningLog;
import com.izeye.playground.support.lotto.domain.KoreanLottoWinningNumbers;

public interface KoreanLottoService {

	KoreanLottoGenerationResponse generate(KoreanLottoGenerationRequest request);

	List<KoreanLottoGenerationLog> getAllGenerationLogs();

	List<KoreanLottoGenerationLog> getLatestGenerationLogs();

	List<KoreanLottoGenerationLog> getGenerationLogs(
			KoreanLottoSequencePeriod sequencePeriod);

	List<KoreanLottoGenerationLog> getGenerationLogs(int sequence);

	Integer getRank(KoreanLottoNumbers numbers,
			KoreanLottoWinningNumbers winningNumbers);

	Integer getRank(String numbers, String winningNumbers);

	Integer getRank(String numbers, Date generatedTime);

	List<KoreanLottoWinningLog> getAllWinningLogs();

	List<KoreanLottoWinningLog> getWinningLogsInSpecificYear(String year);

	String getDrawingDay(Date generatedTime);

	KoreanLottoWinningLog getWinningLog(String drawingDay);

	KoreanLottoWinningLog getLatestWinningLog();

	KoreanLottoSequencePeriod getSequencePeriod(String drawingDay);

}
