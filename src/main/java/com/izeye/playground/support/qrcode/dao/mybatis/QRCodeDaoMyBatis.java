package com.izeye.playground.support.qrcode.dao.mybatis;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.izeye.playground.support.qrcode.dao.QRCodeDao;
import com.izeye.playground.support.qrcode.domain.QRCodeGenerationLog;
import com.izeye.playground.support.qrcode.domain.QRCodeGenerationRequest;

@Repository("qrCodeDao")
public class QRCodeDaoMyBatis implements QRCodeDao {

	@Resource
	private SqlSession sqlSession;

	@Override
	public void insert(QRCodeGenerationRequest qrCodeGenerationRequest) {
		QRCodeMapper mapper = sqlSession.getMapper(QRCodeMapper.class);
		mapper.insert(qrCodeGenerationRequest);
	}

	@Override
	public List<QRCodeGenerationLog> getAllQRCodeGenerationLogs() {
		QRCodeMapper mapper = sqlSession.getMapper(QRCodeMapper.class);
		return mapper.getAllQRCodeGenerationLogs();
	}

}
