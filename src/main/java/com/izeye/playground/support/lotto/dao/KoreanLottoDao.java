package com.izeye.playground.support.lotto.dao;

import java.util.List;

import com.izeye.playground.support.lotto.domain.KoreanLottoGenerationLog;
import com.izeye.playground.support.lotto.domain.KoreanLottoGenerationRequest;
import com.izeye.playground.support.lotto.domain.KoreanLottoGenerationResponse;
import com.izeye.playground.support.lotto.domain.KoreanLottoSequencePeriod;
import com.izeye.playground.support.lotto.domain.KoreanLottoWinningLog;

public interface KoreanLottoDao {

	void insert(KoreanLottoGenerationRequest request,
			KoreanLottoGenerationResponse response);

	List<KoreanLottoGenerationLog> getAllGenerationLogs();

	List<KoreanLottoGenerationLog> getGenerationLogs(
			KoreanLottoSequencePeriod sequencePeriod);

	void insert(KoreanLottoWinningLog winningLog);

	List<KoreanLottoWinningLog> getAllWinningLogs();

	List<KoreanLottoWinningLog> getWinningLogsInSpecificYear(String year);

	KoreanLottoWinningLog getWinningLog(int sequence);

	KoreanLottoWinningLog getWinningLog(String drawingDay);

	KoreanLottoWinningLog getLatestWinningLog();

}
