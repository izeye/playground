package com.izeye.playground.support.qrcode.dao.mybatis;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.izeye.playground.support.qrcode.dao.QrCodeDao;
import com.izeye.playground.support.qrcode.domain.QrCodeGenerationLog;
import com.izeye.playground.support.qrcode.domain.QrCodeGenerationRequest;

@Repository("qrCodeDao")
public class QrCodeDaoMyBatis implements QrCodeDao {

	@Resource
	private SqlSession sqlSession;

	@Override
	public void insert(QrCodeGenerationRequest qrCodeGenerationRequest) {
		QrCodeMapper mapper = sqlSession.getMapper(QrCodeMapper.class);
		mapper.insert(qrCodeGenerationRequest);
	}

	@Override
	public List<QrCodeGenerationLog> getAllQrCodeGenerationLogs() {
		QrCodeMapper mapper = sqlSession.getMapper(QrCodeMapper.class);
		return mapper.getAllQrCodeGenerationLogs();
	}

}
