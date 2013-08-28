package com.izeye.playground.support.http.client.domain;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.util.HtmlUtils;

public class HTTPResponse {

	private String rawResponse;

	private String version;
	private HttpStatus status;

	private Map<String, String> headers;

	private String body;

	public String getRawResponse() {
		return rawResponse;
	}

	public void setRawResponse(String rawResponse) {
		this.rawResponse = rawResponse;
	}

	public String getHtmlEscapedRawResponse() {
		return HtmlUtils.htmlEscape(getRawResponse());
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public int getStatusCode() {
		return status.value();
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getHtmlEscapedBody() {
		return HtmlUtils.htmlEscape(getBody());
	}

	@Override
	public String toString() {
		return "HTTPResponse [rawResponse=" + rawResponse + ", version="
				+ version + ", status=" + status + ", headers=" + headers
				+ ", body=" + body + "]";
	}

}
