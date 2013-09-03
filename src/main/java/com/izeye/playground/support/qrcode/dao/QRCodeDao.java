package com.izeye.playground.support.qrcode.dao;

import java.util.List;

import com.izeye.playground.support.qrcode.domain.QrCodeGenerationLog;
import com.izeye.playground.support.qrcode.domain.QrCodeGenerationRequest;

public interface QrCodeDao {

	void insert(QrCodeGenerationRequest qrCodeGenerationRequest);

	List<QrCodeGenerationLog> getAllQrCodeGenerationLogs();

}
