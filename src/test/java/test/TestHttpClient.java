package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
import org.junit.Test;

public class TestHttpClient {

	@Test
	public void run() throws URISyntaxException, ClientProtocolException,
			IOException {
		HttpClient httpClient = new DefaultHttpClient();
		httpClient.getParams()
				.setParameter(CoreProtocolPNames.USER_AGENT, null);
		URIBuilder uriBuilder = new URIBuilder();
		uriBuilder.setScheme("http").setHost("localhost:8080").setPath("/");
		URI uri = uriBuilder.build();
		HttpGet httpGet = new HttpGet(uri);
		HttpResponse httpResponse = httpClient.execute(httpGet);
		String responseAsString = getResponseAsString(httpResponse);
		System.out.println(responseAsString);
	}

	private String getResponseAsString(HttpResponse httpResponse)
			throws IllegalStateException, IOException {
		StringBuilder sb = new StringBuilder();

		HttpEntity httpEntity = httpResponse.getEntity();
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line;
		while ((line = br.readLine()) != null) {
			sb.append(line);
			sb.append(System.lineSeparator());
		}
		br.close();

		return sb.toString();
	}

}
