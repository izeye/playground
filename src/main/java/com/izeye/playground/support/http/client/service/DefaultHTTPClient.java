package com.izeye.playground.support.http.client.service;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.izeye.playground.support.http.client.domain.HTTPClientFailureException;
import com.izeye.playground.support.http.client.domain.HTTPRequest;
import com.izeye.playground.support.http.client.domain.HTTPResponse;

@Service("httpClient")
public class DefaultHTTPClient implements HTTPClient {

	@Resource
	private HTTPResponseParser httpResponseParser;

	@Override
	public HTTPResponse send(HTTPRequest request)
			throws HTTPClientFailureException {
		return send(request, false);
	}

	@Override
	public HTTPResponse send(HTTPRequest request, boolean contentLengthLimited)
			throws HTTPClientFailureException {
		Socket socket = null;

		BufferedOutputStream bos = null;
		BufferedReader br = null;
		try {
			socket = new Socket(request.getHost(), request.getPort());

			OutputStream os = socket.getOutputStream();
			bos = new BufferedOutputStream(os);
			bos.write(request.getRawRequest().getBytes());
			bos.flush();

			InputStream is = socket.getInputStream();
			return httpResponseParser.parse(is, contentLengthLimited);
		} catch (UnknownHostException e) {
			e.printStackTrace();
			throw new HTTPClientFailureException(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new HTTPClientFailureException(e);
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
