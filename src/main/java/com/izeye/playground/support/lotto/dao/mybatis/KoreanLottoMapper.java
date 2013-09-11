package com.izeye.playground.support.lotto.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.izeye.playground.support.lotto.domain.KoreanLottoGenerationLog;
import com.izeye.playground.support.lotto.domain.KoreanLottoWinningLog;

public interface KoreanLottoMapper {

	void insertGenerationLog(@Param("numbers") String numbers,
			@Param("ip") String ip);

	List<KoreanLottoGenerationLog> getAllGenerationLogs();

	void insertWinningLog(KoreanLottoWinningLog winningLog);

	List<KoreanLottoWinningLog> getAllWinningLogs();

}
