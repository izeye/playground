package com.izeye.playground.support.lotto.service;

import java.util.List;

import com.izeye.playground.support.lotto.domain.KoreanLottoLog;
import com.izeye.playground.support.lotto.domain.KoreanLottoRequest;
import com.izeye.playground.support.lotto.domain.KoreanLottoResponse;

public interface KoreanLottoService {

	KoreanLottoResponse getLuckyNumbers(KoreanLottoRequest request);

	List<KoreanLottoLog> getAllKoreanLottoLogs();

}
