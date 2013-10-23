package com.izeye.playground.support.daum.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.izeye.playground.support.daum.dao.MypeopleBotDao;
import com.izeye.playground.support.daum.domain.MypeopleBotCallbackAction;
import com.izeye.playground.support.daum.domain.MypeopleBotCallbackLog;
import com.izeye.playground.support.daum.domain.MypeopleBotException;

@Service("mypeopleBotService")
public class DefaultMypeopleBotService implements MypeopleBotService {  

	private static final String XML = ".xml";
	private static final String JSON = ".json";
	private static final String URI_MYPEOPLE_BOT = "https://apis.daum.net/mypeople";
	private static final String URI_MYPEOPLE_BOT_SEND = URI_MYPEOPLE_BOT
			+ "/buddy/send";
	private static final String URI_MYPEOPLE_BOT_SEND_JSON = URI_MYPEOPLE_BOT_SEND
			+ JSON;
	private static final String URI_MYPEOPLE_BOT_SEND_XML = URI_MYPEOPLE_BOT_SEND
			+ XML;

	private static final String MESSAGE_WELCOME = "Welcome to izeye's playground!";

	@Value("${daum.mypeople.api.key}")
	private String apiKey;

	@Resource
	private MypeopleBotDao mypeopleBotDao;

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public void handleCallback(MypeopleBotCallbackAction action,
			String groupId, String buddyId, String content) {
		mypeopleBotDao.insert(new MypeopleBotCallbackLog(action.getValue(),
				groupId, buddyId, content));

		switch (action) {
		case ADD_BUDDY:
			send(buddyId, MESSAGE_WELCOME);
			break;

		case SEND_FROM_MESSAGE:
			send(buddyId, content);
			break;

		case SEND_FROM_GROUP:
		case CREATE_GROUP:
		case INVITE_TO_GROUP:
		case EXIT_FROM_GROUP:
		case HELP_FROM_MESSAGE:
		case HELP_FROM_GROUP:
		case EXIT_BOT:
			// TODO:
			// Not implemented yet.
			break;

		default:
			throw new MypeopleBotException("Unexpected action: " + action);
		}
	}

	@Override
	public void send(String buddyId, String content) {
		try {
			HttpClient httpClient = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(URI_MYPEOPLE_BOT_SEND_JSON);
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("buddyId", buddyId));
			params.add(new BasicNameValuePair("content", content));
			params.add(new BasicNameValuePair("apikey", apiKey));
			httpPost.setEntity(new UrlEncodedFormEntity(params));
			HttpResponse httpResponse = httpClient.execute(httpPost);
			String response = toString(httpResponse);
			log.debug(response);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new MypeopleBotException(e);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			throw new MypeopleBotException(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new MypeopleBotException(e);
		}
	}

	private String toString(HttpResponse httpResponse)
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
