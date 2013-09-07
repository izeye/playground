package com.izeye.playground.support.quota.service;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.izeye.playground.support.ip.domain.WhoisFailException;

@Component
@Aspect
public class QuotaAspect {

	@Resource
	private QuotaLimitService quotaLimitService;

	@Around("execution(* com.izeye.playground.support.ip.service.KisaWhoisService.whois(..))")
	public Object checkQuota(ProceedingJoinPoint pjp) throws Throwable {
		if (!quotaLimitService.isAvailable()) {
			throw new WhoisFailException("Quota is not available.");
		}
		quotaLimitService.use();

		return pjp.proceed();
	}

}
