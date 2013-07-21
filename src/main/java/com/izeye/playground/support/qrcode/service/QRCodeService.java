package com.izeye.playground.support.qrcode.service;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.google.zxing.WriterException;
import com.izeye.playground.support.qrcode.domain.QRCodeGenerationLog;
import com.izeye.playground.support.qrcode.domain.QRCodeGenerationRequest;

public interface QRCodeService {

	byte[] text2QRCode(QRCodeGenerationRequest request)
			throws UnsupportedEncodingException, WriterException, IOException;

	void text2QRCode(String text, int size, String filename)
			throws WriterException, IOException;

	void text2QRCode(String text, int size, OutputStream os)
			throws WriterException, IOException;

	void text2QRCode(String text, int width, int height, String filename)
			throws WriterException, IOException;

	void text2QRCode(String text, int width, int height, OutputStream os)
			throws WriterException, IOException;

	List<QRCodeGenerationLog> getAllQRCodeGenerationLogs();

}
