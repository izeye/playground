package com.izeye.playground.support.lotto.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.izeye.playground.support.lotto.domain.KoreanLottoLog;

public interface KoreanLottoMapper {

	void insert(@Param("numbers") String numbers, @Param("ip") String ip);

	List<KoreanLottoLog> getAllKoreanLottoLogs();

}
