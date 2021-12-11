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
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 다중 상속
 */
public class Api extends AbstractApi implements ApiInterface {
	@Override
	public String getRawData() throws IOException {
		Api api = this;
		LocalDate now = LocalDate.now();
		LocalDate start = now.minusDays(1);
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
		String line = rd.readLine();
		rd.close();
		conn.disconnect();
		return String.valueOf(line);
	}
}