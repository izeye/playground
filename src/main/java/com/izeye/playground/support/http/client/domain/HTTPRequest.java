package com.izeye.playground.support.http.client.domain;

import static com.izeye.playground.support.http.client.domain.HTTPClientConstants.DEFAULT_HEADER_CONNECTION;
import static com.izeye.playground.support.http.client.domain.HTTPClientConstants.DEFAULT_HEADER_REFERER;
import static com.izeye.playground.support.http.client.domain.HTTPClientConstants.DEFAULT_HEADER_USER_AGENT;
import static com.izeye.playground.support.http.client.domain.HTTPClientConstants.DEFAULT_HTTP_VERSION;
import static com.izeye.playground.support.http.client.domain.HTTPClientConstants.DEFAULT_PATH;
import static com.izeye.playground.support.http.domain.HTTPConstants.CRLF;
import static com.izeye.playground.support.http.domain.HTTPConstants.DEFAULT_PORT;
import static com.izeye.playground.support.http.domain.HTTPConstants.HEADER_CONNECTION;
import static com.izeye.playground.support.http.domain.HTTPConstants.HEADER_DELIMITER;
import static com.izeye.playground.support.http.domain.HTTPConstants.HEADER_HOST;
import static com.izeye.playground.support.http.domain.HTTPConstants.HEADER_REFERER;
import static com.izeye.playground.support.http.domain.HTTPConstants.HEADER_USER_AGENT;
import static com.izeye.playground.support.http.domain.HTTPConstants.PARAMETERS_DELIMITER;
import static com.izeye.playground.support.http.domain.HTTPConstants.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HTTPRequest {

	private HTTPMethod method;
	private URL url;

	private String version;

	private String host;
	private int port;
	private String path;
	private String query;
	private String uri;

	private Map<String, String> headers;
	private Map<String, String> parameters;

	private String parametersAsString;

	public HTTPRequest(HTTPMethod method, URL url) {
		this.method = method;

		setUrl(url);

		this.headers = new HashMap<String, String>();
		this.parameters = new HashMap<String, String>();

		setDefaultHeaders();
	}

	public void setDefaultHeaders() {
		headers.put(HEADER_HOST, getHost());
		headers.put(HEADER_USER_AGENT, DEFAULT_HEADER_USER_AGENT);
		headers.put(HEADER_REFERER, DEFAULT_HEADER_REFERER);
		headers.put(HEADER_CONNECTION, DEFAULT_HEADER_CONNECTION);
	}

	public HTTPRequest(HTTPMethod method, String url)
			throws MalformedURLException {
		this(method, new URL(url));
	}

	public HTTPMethod getMethod() {
		return method;
	}

	public void setMethod(HTTPMethod method) {
		this.method = method;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;

		String host = url.getHost();
		int port = url.getPort();
		String path = url.getPath();
		String query = url.getQuery();

		setHost(host);
		setPort(port);
		setPath(path);
		setQuery(query);

		String uri = getPath() + (getQuery() == null ? "" : "?" + getQuery());
		setUri(uri);
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port == -1 ? DEFAULT_PORT : port;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path.isEmpty() ? DEFAULT_PATH : path;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public Map<String, String> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;

		if (getMethod() == HTTPMethod.POST && parameters.size() != 0) {
			StringBuilder sbParameters = new StringBuilder();
			for (Map.Entry<String, String> parameter : parameters.entrySet()) {
				sbParameters.append(parameter.getKey());
				sbParameters.append(PARAMETER_DELIMITER);
				sbParameters.append(parameter.getValue());
				sbParameters.append(PARAMETERS_DELIMITER);
			}
			sbParameters.deleteCharAt(sbParameters.length() - 1);
			this.parametersAsString = sbParameters.toString();

			headers.put(HEADER_CONTENT_TYPE,
					HEADER_CONTENT_TYPE_APPLICATION_X_WWW_FORM_URLENCODED);
			headers.put(HEADER_CONTENT_LENGTH,
					String.valueOf(parametersAsString.getBytes().length));
		}
	}

	public String getRawRequest() {
		StringBuilder sb = new StringBuilder();
		sb.append(getMethod().name());
		sb.append(' ');
		sb.append(getUri());
		sb.append(' ');
		sb.append("HTTP/");
		sb.append(DEFAULT_HTTP_VERSION);
		sb.append(CRLF);
		for (Map.Entry<String, String> header : headers.entrySet()) {
			sb.append(header.getKey());
			sb.append(HEADER_DELIMITER);
			sb.append(header.getValue());
			sb.append(CRLF);
		}
		sb.append(CRLF);
		if (getMethod() == HTTPMethod.POST && parameters.size() != 0) {
			sb.append(parametersAsString);
		}
		return sb.toString();
	}

	@Override
	public String toString() {
		return "HTTPRequest [method=" + method + ", url=" + url + ", version="
				+ version + ", host=" + host + ", port=" + port + ", path="
				+ path + ", query=" + query + ", uri=" + uri + ", headers="
				+ headers + ", parameters=" + parameters + "]";
	}

}
