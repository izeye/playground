package com.izeye.playground.support.lotto.dao;

import java.util.List;

import com.izeye.playground.support.lotto.domain.KoreanLottoLog;
import com.izeye.playground.support.lotto.domain.KoreanLottoRequest;
import com.izeye.playground.support.lotto.domain.KoreanLottoResponse;

public interface KoreanLottoDao {

	void insert(KoreanLottoRequest request, KoreanLottoResponse response);

	List<KoreanLottoLog> getAllKoreanLottoLogs();

}
