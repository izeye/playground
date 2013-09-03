package com.izeye.playground.support.qrcode.dao.mybatis;

import java.util.List;

import com.izeye.playground.support.qrcode.domain.QrCodeGenerationLog;
import com.izeye.playground.support.qrcode.domain.QrCodeGenerationRequest;

public interface QrCodeMapper {

	void insert(QrCodeGenerationRequest qrCodeGenerationRequest);

	List<QrCodeGenerationLog> getAllQrCodeGenerationLogs();

}
