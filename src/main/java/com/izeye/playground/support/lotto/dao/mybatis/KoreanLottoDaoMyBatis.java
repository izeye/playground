package com.izeye.playground.support.lotto.dao.mybatis;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.izeye.playground.support.lotto.dao.KoreanLottoDao;
import com.izeye.playground.support.lotto.domain.KoreanLottoLog;
import com.izeye.playground.support.lotto.domain.KoreanLottoRequest;
import com.izeye.playground.support.lotto.domain.KoreanLottoResponse;

@Repository("koreanLottoDao")
public class KoreanLottoDaoMyBatis implements KoreanLottoDao {

	@Resource
	private SqlSession sqlSession;

	@Override
	public void insert(KoreanLottoRequest request, KoreanLottoResponse response) {
		KoreanLottoMapper mapper = sqlSession
				.getMapper(KoreanLottoMapper.class);
		mapper.insert(response.getNumbersAsString(), request.getIp());
	}

	@Override
	public List<KoreanLottoLog> getAllKoreanLottoLogs() {
		KoreanLottoMapper mapper = sqlSession
				.getMapper(KoreanLottoMapper.class);
		return mapper.getAllKoreanLottoLogs();
	}

}
