package com.izeye.playground.support.lotto.dao.mybatis;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.izeye.playground.support.lotto.dao.KoreanLottoDao;
import com.izeye.playground.support.lotto.domain.KoreanLottoGenerationLog;
import com.izeye.playground.support.lotto.domain.KoreanLottoGenerationRequest;
import com.izeye.playground.support.lotto.domain.KoreanLottoGenerationResponse;
import com.izeye.playground.support.lotto.domain.KoreanLottoWinningLog;

@Repository("koreanLottoDao")
public class KoreanLottoDaoMyBatis implements KoreanLottoDao {

	@Resource
	private SqlSession sqlSession;

	@Override
	public void insert(KoreanLottoGenerationRequest request,
			KoreanLottoGenerationResponse response) {
		KoreanLottoMapper mapper = sqlSession
				.getMapper(KoreanLottoMapper.class);
		mapper.insertGenerationLog(response.getNumbersAsString(),
				request.getIp());
	}

	@Override
	public List<KoreanLottoGenerationLog> getAllGenerationLogs() {
		KoreanLottoMapper mapper = sqlSession
				.getMapper(KoreanLottoMapper.class);
		return mapper.getAllGenerationLogs();
	}

	@Override
	public List<KoreanLottoWinningLog> getAllWinningLogs() {
		KoreanLottoMapper mapper = sqlSession
				.getMapper(KoreanLottoMapper.class);
		return mapper.getAllWinningLogs();
	}

	@Override
	public void insert(KoreanLottoWinningLog winningLog) {
		KoreanLottoMapper mapper = sqlSession
				.getMapper(KoreanLottoMapper.class);
		mapper.insertWinningLog(winningLog);
	}

}
