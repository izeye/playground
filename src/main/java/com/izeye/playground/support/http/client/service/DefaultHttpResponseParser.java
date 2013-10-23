package com.izeye.playground.support.http.client.service;

import static com.izeye.playground.support.http.client.domain.HttpClientConstants.DEFAULT_RESPONSE_CONTENT_LENGTH_LIMIT;
import static com.izeye.playground.support.http.domain.HttpConstants.CRLF;
import static com.izeye.playground.support.http.domain.HttpConstants.HEADER_CONTENT_LENGTH;
import static com.izeye.playground.support.http.domain.HttpConstants.HEADER_DELIMITER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.izeye.playground.support.http.client.domain.HttpClientFailureException;
import com.izeye.playground.support.http.client.domain.HttpResponse;

@Service("httpResponseParser")
public class DefaultHttpResponseParser implements HttpResponseParser {

	@Override
	public HttpResponse parse(InputStream is) throws HttpClientFailureException {
		return parse(is, false);
	}

	@Override
	public HttpResponse parse(InputStream is, boolean contentLengthLimited)
			throws HttpClientFailureException {
		HttpResponse response = new HttpResponse();

		BufferedReader br = null;
		try {
			StringBuilder sbRawResponse = new StringBuilder();
			br = new BufferedReader(new InputStreamReader(is));

			String line = br.readLine();
			sbRawResponse.append(line);
			sbRawResponse.append(CRLF);

			String[] splitLine = line.split(" ");
			String version = splitLine[0].split("/")[1];
			HttpStatus status = HttpStatus.valueOf(Integer
					.valueOf(splitLine[1]));
			response.setVersion(version);
			response.setStatus(status);

			Map<String, String> headers = new HashMap<String, String>();
			while (!(line = br.readLine()).isEmpty()) {
				sbRawResponse.append(line);
				sbRawResponse.append(CRLF);

				splitLine = line.split(HEADER_DELIMITER);
				String headerName = splitLine[0];
				String headerValue = splitLine[1].trim();
				headers.put(headerName, headerValue);
			}
			if (contentLengthLimited) {
				int contentLength = Integer.parseInt(headers
						.get(HEADER_CONTENT_LENGTH));
				if (contentLength > DEFAULT_RESPONSE_CONTENT_LENGTH_LIMIT) {
					throw new HttpClientFailureException(
							"Content length is too big: " + contentLength
									+ " (Max content length: "
									+ DEFAULT_RESPONSE_CONTENT_LENGTH_LIMIT
									+ ")");
				}
			}
			sbRawResponse.append(CRLF);

			response.setHeaders(headers);

			StringBuilder sbBody = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sbBody.append(line);
				sbBody.append("\n");
			}
			if (sbBody.length() != 0) {
				sbBody.deleteCharAt(sbBody.length() - 1);
			}
			String body = sbBody.toString();
			sbRawResponse.append(body);

			response.setBody(body);

			String rawResponse = sbRawResponse.toString();
			response.setRawResponse(rawResponse);
			return response;
		} catch (IOException e) {
			e.printStackTrace();
			throw new HttpClientFailureException(e);
		}
	}

}
