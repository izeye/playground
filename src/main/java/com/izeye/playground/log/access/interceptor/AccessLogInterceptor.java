package com.izeye.playground.log.access.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.izeye.playground.common.util.HTTPUtils;
import com.izeye.playground.log.access.service.AccessLogService;

@Component("accessLogInterceptor")
public class AccessLogInterceptor extends HandlerInterceptorAdapter {

	@Resource
	private AccessLogService accessLogService;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String ip = request.getRemoteAddr();
		String url = request.getRequestURL().toString();
		String userAgent = HTTPUtils.getUserAgent(request);
		String referer = HTTPUtils.getReferer(request);
		accessLogService.log(ip, url, userAgent, referer);
		return super.preHandle(request, response, handler);
	}

}
