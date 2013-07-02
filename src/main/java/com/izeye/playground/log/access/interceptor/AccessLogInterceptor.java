package com.izeye.playground.log.access.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.izeye.playground.common.util.HttpUtils;
import com.izeye.playground.log.access.service.AccessLogService;

@Component("accessLogInterceptor")
public class AccessLogInterceptor extends HandlerInterceptorAdapter {

	private static final String URI_PREFIX_RESOURCES = "/resources/";

	@Resource
	private AccessLogService accessLogService;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String requestURI = request.getRequestURI();
		if (!requestURI.startsWith(URI_PREFIX_RESOURCES)) {
			String ip = request.getRemoteAddr();
			String url = request.getRequestURL().toString();
			String userAgent = HttpUtils.getUserAgent(request);
			String referer = HttpUtils.getReferer(request);
			accessLogService.log(ip, url, userAgent, referer);
		}
		return super.preHandle(request, response, handler);
	}

}
