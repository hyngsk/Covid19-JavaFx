/*
 * Copyright (c) 2021.
 * Name : Hyeong Seok, Oh
 * E-mail : hyngsk.o@gmail.com
 * Created at : ${DATE}
 */

package me.hyngsk.covidnow.Api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Api implements ApiInterface {
	static String KEY = "xxxxxxxxxxxxxxxxx";
	static StringBuilder urlBuilder;

	private URL setUrl(int pageNo, int numOfRows, String start, String end) throws UnsupportedEncodingException, MalformedURLException {
		urlBuilder = new StringBuilder("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson"); /*URL*/
		urlBuilder.append("?").append(URLEncoder.encode("serviceKey", "UTF-8")).append("=").append(KEY); /*공공데이터포털에서 받은 인증키*/
		urlBuilder.append("&").append(URLEncoder.encode("pageNo", "UTF-8")).append("=").append(URLEncoder.encode(String.valueOf(pageNo), "UTF-8")); /*페이지번호*/
		urlBuilder.append("&").append(URLEncoder.encode("numOfRows", "UTF-8")).append("=").append(URLEncoder.encode(String.valueOf(numOfRows), "UTF-8")); /*한 페이지 결과 수*/
		urlBuilder.append("&").append(URLEncoder.encode("startCreateDt", "UTF-8")).append("=").append(URLEncoder.encode(start, "UTF-8")); /*검색할 생성일 범위의 시작*/
		urlBuilder.append("&").append(URLEncoder.encode("endCreateDt", "UTF-8")).append("=").append(URLEncoder.encode(end, "UTF-8")); /*검색할 생성일 범위의 종료*/
		return new URL(urlBuilder.toString());
	}


	@Override
	public String getRawData() throws IOException {
		Api api = this;
		LocalDate now = LocalDate.now();
		LocalDate start = now.minusDays(0);
//		System.out.println(now.format(DateTimeFormatter.BASIC_ISO_DATE));
//		System.out.println(api.setUrl(1, 10, now.format(DateTimeFormatter.BASIC_ISO_DATE), now.format(DateTimeFormatter.BASIC_ISO_DATE)));
		URL url = api.setUrl(1, 10, start.format(DateTimeFormatter.BASIC_ISO_DATE), now.format(DateTimeFormatter.BASIC_ISO_DATE));
		System.out.println(url);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;

		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		System.out.println();

		String line = rd.readLine();
		rd.close();
		conn.disconnect();

		return String.valueOf(line);
	}
}