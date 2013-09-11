package com.izeye.playground.support.lotto.dao;

import java.util.List;

import com.izeye.playground.support.lotto.domain.KoreanLottoGenerationLog;
import com.izeye.playground.support.lotto.domain.KoreanLottoGenerationRequest;
import com.izeye.playground.support.lotto.domain.KoreanLottoGenerationResponse;
import com.izeye.playground.support.lotto.domain.KoreanLottoWinningLog;

public interface KoreanLottoDao {

	void insert(KoreanLottoGenerationRequest request,
			KoreanLottoGenerationResponse response);

	List<KoreanLottoGenerationLog> getAllGenerationLogs();

	void insert(KoreanLottoWinningLog winningLog);

	List<KoreanLottoWinningLog> getAllWinningLogs();

}
