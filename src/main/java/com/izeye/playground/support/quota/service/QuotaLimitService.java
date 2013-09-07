package com.izeye.playground.support.quota.service;

import com.izeye.playground.support.quota.domain.Quota;

public interface QuotaLimitService {

	boolean isAvailable();

	void use();

	Quota getQuota();

}
