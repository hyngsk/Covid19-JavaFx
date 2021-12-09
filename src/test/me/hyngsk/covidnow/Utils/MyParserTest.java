/*
 * Copyright (c) 2021.
 * Name : Hyeong Seok, Oh
 * E-mail : hyngsk.o@gmail.com
 * Created at : ${DATE}
 */

package me.hyngsk.covidnow.Utils;

import me.hyngsk.covidnow.Api.ApiService;
import me.hyngsk.covidnow.Model.DataModel;
import me.hyngsk.covidnow.Model.Options;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class MyParserTest {

	@Test
	public void XMLToMap() {
	}


	@Test
	public void findByGubun() throws IOException {
		DataModel result = null;
		ApiService apiService = new ApiService();
		for (Object i :
				Options.values()) {
			result = (DataModel) apiService.getDataModel(i.toString());
			assertNotNull(result);
			assertNotEquals(result.getLoc_name(), i);
		}
	}
	@Test
	public void getAllData() throws IOException {
		ArrayList<DataModel> result = null;
		ApiService apiService = new ApiService();
		for (Object i :
				Options.values()) {
			result = (ArrayList<DataModel>) apiService.getDataModel();
			assertNotNull(result);
			assertNotEquals(result.size(),19);
		}
	}

}