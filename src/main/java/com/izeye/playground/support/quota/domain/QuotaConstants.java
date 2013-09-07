package com.izeye.playground.support.quota.domain;

public interface QuotaConstants {

	int KISA_WHOIS_DAILY_QUERY_HARD_LIMIT = 10000;

	// NOTE:
	// Conservatively, use only 50% of maximum.
	int KISA_WHOIS_DAILY_QUERY_SOFT_LIMIT = (int) (KISA_WHOIS_DAILY_QUERY_HARD_LIMIT * 0.5);

}
