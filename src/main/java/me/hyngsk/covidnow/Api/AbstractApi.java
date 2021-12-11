/*
 * Copyright (c) 2021.
 * Name : Hyeong Seok, Oh
 * E-mail : hyngsk.o@gmail.com
 * Created at : ${DATE}
 */

package me.hyngsk.covidnow.Api;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class AbstractApi {
	static StringBuilder urlBuilder;
	static String KEY = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";

	protected URL setUrl(int pageNo, int numOfRows, String start, String end) throws UnsupportedEncodingException, MalformedURLException {
		urlBuilder = new StringBuilder("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson"); /*URL*/
		urlBuilder.append("?").append(URLEncoder.encode("serviceKey", "UTF-8")).append("=").append(KEY); /*공공데이터포털에서 받은 인증키*/
		urlBuilder.append("&").append(URLEncoder.encode("pageNo", "UTF-8")).append("=").append(URLEncoder.encode(String.valueOf(pageNo), "UTF-8")); /*페이지번호*/
		urlBuilder.append("&").append(URLEncoder.encode("numOfRows", "UTF-8")).append("=").append(URLEncoder.encode(String.valueOf(numOfRows), "UTF-8")); /*한 페이지 결과 수*/
		urlBuilder.append("&").append(URLEncoder.encode("startCreateDt", "UTF-8")).append("=").append(URLEncoder.encode(start, "UTF-8")); /*검색할 생성일 범위의 시작*/
		urlBuilder.append("&").append(URLEncoder.encode("endCreateDt", "UTF-8")).append("=").append(URLEncoder.encode(end, "UTF-8")); /*검색할 생성일 범위의 종료*/
		return new URL(urlBuilder.toString());
	}
}
