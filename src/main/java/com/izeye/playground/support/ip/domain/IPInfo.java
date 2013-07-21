package com.izeye.playground.support.ip.domain;

public class IPInfo {

	private Whois whois;

	public IPInfo(Whois whois) {
		this.whois = whois;
	}

	public Whois getWhois() {
		return whois;
	}

	@Override
	public String toString() {
		return "IPInfo [whois=" + whois + "]";
	}

}
