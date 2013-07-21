package com.izeye.playground.support.qrcode.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.izeye.playground.support.qrcode.dao.QRCodeDao;
import com.izeye.playground.support.qrcode.domain.QRCodeGenerationLog;
import com.izeye.playground.support.qrcode.domain.QRCodeGenerationRequest;

@Service("qrCodeService")
public class DefaultQRCodeService implements QRCodeService {

	@Resource
	private QRCodeDao qrCodeDao;

	@Override
	public byte[] text2QRCode(QRCodeGenerationRequest request)
			throws UnsupportedEncodingException, WriterException, IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		text2QRCodeInternal(request.getText(), request.getSize(),
				request.getSize(), baos);

		qrCodeDao.insert(request);
		return baos.toByteArray();
	}

	@Override
	public void text2QRCode(String text, int size, String filename)
			throws WriterException, IOException {
		text2QRCodeInternal(text, size, size, filename);
	}

	@Override
	public void text2QRCode(String text, int size, OutputStream os)
			throws WriterException, IOException {
		text2QRCodeInternal(text, size, size, os);
	}

	@Override
	public void text2QRCode(String text, int width, int height, String filename)
			throws WriterException, IOException {
		text2QRCodeInternal(text, width, height, filename);
	}

	@Override
	public void text2QRCode(String text, int width, int height, OutputStream os)
			throws WriterException, IOException {
		text2QRCodeInternal(text, width, height, os);
	}

	private void text2QRCodeInternal(String text, int width, int height,
			String filename) throws UnsupportedEncodingException,
			WriterException, IOException {
		BitMatrix bitMatrix = createBitMatrix(text, width, height);
		MatrixToImageWriter.writeToFile(bitMatrix, "png", new File(filename));
	}

	private void text2QRCodeInternal(String text, int width, int height,
			OutputStream os) throws UnsupportedEncodingException,
			WriterException, IOException {
		BitMatrix bitMatrix = createBitMatrix(text, width, height);
		MatrixToImageWriter.writeToStream(bitMatrix, "png", os);
	}

	private BitMatrix createBitMatrix(String text, int width, int height)
			throws UnsupportedEncodingException, WriterException {
		text = new String(text.getBytes("UTF-8"), "ISO-8859-1");

		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE,
				width, height);
		return bitMatrix;
	}

	@Override
	public List<QRCodeGenerationLog> getAllQRCodeGenerationLogs() {
		return qrCodeDao.getAllQRCodeGenerationLogs();
	}

}
