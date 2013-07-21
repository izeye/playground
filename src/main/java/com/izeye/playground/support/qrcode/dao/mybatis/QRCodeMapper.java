package com.izeye.playground.support.qrcode.dao.mybatis;

import java.util.List;

import com.izeye.playground.support.qrcode.domain.QRCodeGenerationLog;
import com.izeye.playground.support.qrcode.domain.QRCodeGenerationRequest;

public interface QRCodeMapper {

	void insert(QRCodeGenerationRequest qrCodeGenerationRequest);

	List<QRCodeGenerationLog> getAllQRCodeGenerationLogs();

}
