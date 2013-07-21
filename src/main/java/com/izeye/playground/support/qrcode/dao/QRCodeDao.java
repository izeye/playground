package com.izeye.playground.support.qrcode.dao;

import java.util.List;

import com.izeye.playground.support.qrcode.domain.QRCodeGenerationLog;
import com.izeye.playground.support.qrcode.domain.QRCodeGenerationRequest;

public interface QRCodeDao {

	void insert(QRCodeGenerationRequest qrCodeGenerationRequest);

	List<QRCodeGenerationLog> getAllQRCodeGenerationLogs();

}
