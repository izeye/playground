package com.izeye.playground.support.ip.domain;

import com.izeye.playground.common.domain.StringConstants;

public class WhoisDetail {

	public static final WhoisDetail NOT_AVAILABLE = new WhoisDetail(
			StringConstants.NOT_AVAILABLE, StringConstants.NOT_AVAILABLE,
			StringConstants.NOT_AVAILABLE, StringConstants.NOT_AVAILABLE);

	private String ispOrgName;
	private String ispAddr;
	private String userOrgName;
	private String userAddr;

	public WhoisDetail(String ispOrgName, String ispAddr, String userOrgName,
			String userAddr) {
		this.ispOrgName = ispOrgName;
		this.ispAddr = ispAddr;
		this.userOrgName = userOrgName;
		this.userAddr = userAddr;
	}

	public WhoisDetail() {
	}

	public String getIspOrgName() {
		return ispOrgName;
	}

	public void setIspOrgName(String ispOrgName) {
		this.ispOrgName = ispOrgName;
	}

	public String getIspAddr() {
		return ispAddr;
	}

	public void setIspAddr(String ispAddr) {
		this.ispAddr = ispAddr;
	}

	public String getUserOrgName() {
		return userOrgName;
	}

	public void setUserOrgName(String userOrgName) {
		this.userOrgName = userOrgName;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ispAddr == null) ? 0 : ispAddr.hashCode());
		result = prime * result
				+ ((ispOrgName == null) ? 0 : ispOrgName.hashCode());
		result = prime * result
				+ ((userAddr == null) ? 0 : userAddr.hashCode());
		result = prime * result
				+ ((userOrgName == null) ? 0 : userOrgName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WhoisDetail other = (WhoisDetail) obj;
		if (ispAddr == null) {
			if (other.ispAddr != null)
				return false;
		} else if (!ispAddr.equals(other.ispAddr))
			return false;
		if (ispOrgName == null) {
			if (other.ispOrgName != null)
				return false;
		} else if (!ispOrgName.equals(other.ispOrgName))
			return false;
		if (userAddr == null) {
			if (other.userAddr != null)
				return false;
		} else if (!userAddr.equals(other.userAddr))
			return false;
		if (userOrgName == null) {
			if (other.userOrgName != null)
				return false;
		} else if (!userOrgName.equals(other.userOrgName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WhoisDetail [ispOrgName=" + ispOrgName + ", ispAddr=" + ispAddr
				+ ", userOrgName=" + userOrgName + ", userAddr=" + userAddr
				+ "]";
	}

}
