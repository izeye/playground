package com.izeye.playground.support.lotto.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.izeye.playground.support.lotto.domain.KoreanLottoGenerationLog;
import com.izeye.playground.support.lotto.domain.KoreanLottoSequencePeriod;
import com.izeye.playground.support.lotto.domain.KoreanLottoWinningLog;

public interface KoreanLottoMapper {

	void insertGenerationLog(@Param("numbers") String numbers,
			@Param("ip") String ip);

	List<KoreanLottoGenerationLog> getAllGenerationLogs();

	List<KoreanLottoGenerationLog> getGenerationLogs(
			KoreanLottoSequencePeriod sequencePeriod);

	void insertWinningLog(KoreanLottoWinningLog winningLog);

	List<KoreanLottoWinningLog> getAllWinningLogs();

	List<KoreanLottoWinningLog> getWinningLogsInSpecificYear(
			@Param("year") String year, @Param("nextYear") String nextYear);

	KoreanLottoWinningLog getWinningLogWithSequence(int sequence);

	KoreanLottoWinningLog getWinningLogWithDrawingDay(String drawingDay);

	KoreanLottoWinningLog getLatestWinningLog();

}
