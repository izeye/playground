<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
	table {
		table-layout: fixed
	}
	table th, table td {
		word-wrap: break-word
	}
</style>

<script type="text/javascript">
var analyzeIpAddress = function () {
	$.getJSON('/playground/utilities/ip/json', {
		ipAddress: $('#ipAddress').val()
	}).done(function (data) {
		$('#country').text(data.whois.country.name);
		$('#userAddressInKorean').text(data.whois.koreanDetail.userAddr);
		$('#userAddressInEnglish').text(data.whois.englishDetail.userAddr);
		$('#userOrganizationInKorean').text(data.whois.koreanDetail.userOrgName);
		$('#userOrganizationInEnglish').text(data.whois.englishDetail.userOrgName);
		$('#ispAddressInKorean').text(data.whois.koreanDetail.ispAddr);
		$('#ispAddressInEnglish').text(data.whois.englishDetail.ispAddr);
		$('#ispOrganizationInKorean').text(data.whois.koreanDetail.ispOrgName);
		$('#ispOrganizationInEnglish').text(data.whois.englishDetail.ispOrgName);
	});
};
</script>

<p>
This page provides analysis of your IP address or any IP address and the usage of its API version.
</p>

<c:set var="whois" value="${ipInfo.getWhois()}" />
<c:set var="koreanDetail" value="${whois.getKoreanDetail()}" />
<c:set var="englishDetail" value="${whois.getEnglishDetail()}" />

<b>Your IP address is:</b>
<div class="well">
	${whois.getIpAddress()}
</div>

<b>And the analyzed result is:</b>
<table class="table table-striped table-bordered table-condensed" style="font-size: 12px">
	<tr>
		<td colspan="2" style="width: 150px">&nbsp;</td><td>Korean</td><td>English</td>
	</tr>
	<tr>
		<td colspan="2">Country</td><td>N/A</td><td>${whois.getCountry().getName()}</td>
	</tr>
	<tr>
		<td rowspan="2">User</td><td>Address</td><td>${koreanDetail.getUserAddr()}</td><td>${englishDetail.getUserAddr()}</td>
	</tr>
	<tr>
		<td>Organization</td><td>${koreanDetail.getUserOrgName()}</td><td>${englishDetail.getUserOrgName()}</td>
	</tr>
	<tr>
		<td rowspan="2">ISP</td><td>Address</td><td>${koreanDetail.getIspAddr()}</td><td>${englishDetail.getIspAddr()}</td>
	</tr>
	<tr>
		<td>Organization</td><td>${koreanDetail.getIspOrgName()}</td><td>${englishDetail.getIspOrgName()}</td>
	</tr>
</table>

<b>IP address to analyze:</b><br/>
<input id="ipAddress" type="text" /><br/>
<input type="button" value="Analyze" onclick="analyzeIpAddress();" /><br/><br/>

<b>Analyzed result:</b>
<table class="table table-striped table-bordered table-condensed" style="font-size: 12px">
	<tr>
		<td colspan="2" style="width: 150px">&nbsp;</td><td>Korean</td><td>English</td>
	</tr>
	<tr>
		<td colspan="2">Country</td><td>N/A</td><td id="country">N/A</td>
	</tr>
	<tr>
		<td rowspan="2">User</td><td>Address</td><td id="userAddressInKorean">N/A</td><td id="userAddressInEnglish">N/A</td>
	</tr>
	<tr>
		<td>Organization</td><td id="userOrganizationInKorean">N/A</td><td id="userOrganizationInEnglish">N/A</td>
	</tr>
	<tr>
		<td rowspan="2">ISP</td><td>Address</td><td id="ispAddressInKorean">N/A</td><td id="ispAddressInEnglish">N/A</td>
	</tr>
	<tr>
		<td>Organization</td><td id="ispOrganizationInKorean">N/A</td><td id="ispOrganizationInEnglish">N/A</td>
	</tr>
</table>

<b>You can also use this by calling its API version like this:</b>
<div class="well">
http://izeye.cafe24.com/playground/utilities/ip/json?ipAddress=220.95.233.171
</div>

<b>And the result will be a JSON like this:</b>
<div class="well">
{"whois":{"ipAddress":"220.95.233.171","country":{"iso":"KOR","code":"KR","name":"South Korea"},"koreanDetail":{"ispOrgName":"주식회사 케이티","ispAddr":"성남시 분당구 정자동 206 한국통신 e-Biz본부 기획팀","userOrgName":"주식회사 케이티","userAddr":"성남시 분당구 정자동"},"englishDetail":{"ispOrgName":"Korea Telecom","ispAddr":"206 Jungja-dong, Bundang-gu, Sungnam-ci","userOrgName":"Korea Telecom","userAddr":"Jungja-dong, Bundang-gu, Sungnam-ci"}}}
</div>

<div class="well">
<span class="label label-info">Note</span>
This is powered by the KISA Whois Open API.
</div>
