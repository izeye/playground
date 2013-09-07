package com.izeye.playground.support.quota.service;

import static com.izeye.playground.support.quota.domain.QuotaConstants.KISA_WHOIS_DAILY_QUERY_HARD_LIMIT;
import static com.izeye.playground.support.quota.domain.QuotaConstants.KISA_WHOIS_DAILY_QUERY_SOFT_LIMIT;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.izeye.playground.common.util.DateUtils;
import com.izeye.playground.support.quota.domain.Quota;

@Service("kisaWhoisQuotaLimitService")
public class KisaWhoisQuotaLimitService implements QuotaLimitService {

	private Date today;
	private AtomicInteger todayQueryCount;

	private final Logger log = LoggerFactory.getLogger(getClass());

	public KisaWhoisQuotaLimitService() {
		this.today = new Date();
	}

	@PostConstruct
	public void load() {
		// FIXME:
		// Load today query count if it exists.
		this.todayQueryCount = new AtomicInteger(0);
	}

	@PreDestroy
	public void save() {
		// FIXME:
		// Save today query count.
		System.out.println("Save today query count");
	}

	@Override
	public boolean isAvailable() {
		if (DateUtils.isToday(today)) {
			if (todayQueryCount.get() >= KISA_WHOIS_DAILY_QUERY_SOFT_LIMIT) {
				log.warn("Exceeded the daily query limit ("
						+ KISA_WHOIS_DAILY_QUERY_SOFT_LIMIT + "): "
						+ todayQueryCount);
				return false;
			}
		} else {
			this.today = new Date();
			this.todayQueryCount = new AtomicInteger(0);
		}
		return true;
	}

	@Override
	public void use() {
		if (!isAvailable()) {
			throw new QuotaLimitException("Exceeded the daily query limit ("
					+ KISA_WHOIS_DAILY_QUERY_SOFT_LIMIT + "): "
					+ todayQueryCount);
		}
		todayQueryCount.incrementAndGet();
	}

	@Override
	public Quota getQuota() {
		return new Quota(KISA_WHOIS_DAILY_QUERY_HARD_LIMIT,
				KISA_WHOIS_DAILY_QUERY_SOFT_LIMIT, todayQueryCount.get());
	}

}
