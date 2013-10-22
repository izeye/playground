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

import com.izeye.playground.support.http.client.domain.HttpClientFailureException;
import com.izeye.playground.support.http.client.domain.HttpRequest;
import com.izeye.playground.support.http.client.domain.HttpResponse;

@Service("httpClient")
public class DefaultHttpClient implements HttpClient {

	@Resource
	private HttpResponseParser httpResponseParser;

	@Override
	public HttpResponse send(HttpRequest request)
			throws HttpClientFailureException {
		return send(request, false);
	}

	@Override
	public HttpResponse send(HttpRequest request, boolean contentLengthLimited)
			throws HttpClientFailureException {
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
			throw new HttpClientFailureException(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new HttpClientFailureException(e);
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
