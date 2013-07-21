package com.izeye.playground.support.ip.domain;

import com.izeye.playground.common.util.StringConstants;

public class WhoisDetail {

	public static final WhoisDetail NOT_AVAILABLE = new WhoisDetail(
			StringConstants.NOT_AVAILABLE, StringConstants.NOT_AVAILABLE,
			StringConstants.NOT_AVAILABLE, StringConstants.NOT_AVAILABLE);

	private final String ispOrgName;
	private final String ispAddr;
	private final String userOrgName;
	private final String userAddr;

	public WhoisDetail(String ispOrgName, String ispAddr, String userOrgName,
			String userAddr) {
		this.ispOrgName = ispOrgName;
		this.ispAddr = ispAddr;
		this.userOrgName = userOrgName;
		this.userAddr = userAddr;
	}

	public String getIspOrgName() {
		return ispOrgName;
	}

	public String getIspAddr() {
		return ispAddr;
	}

	public String getUserOrgName() {
		return userOrgName;
	}

	public String getUserAddr() {
		return userAddr;
	}

	@Override
	public String toString() {
		return "WhoisDetail [ispOrgName=" + ispOrgName + ", ispAddr=" + ispAddr
				+ ", userOrgName=" + userOrgName + ", userAddr=" + userAddr
				+ "]";
	}

}
