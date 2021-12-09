/*
 * Copyright (c) 2021.
 * Name : Hyeong Seok, Oh
 * E-mail : hyngsk.o@gmail.com
 * Created at : ${DATE}
 */

package me.hyngsk.covidnow.Manager;

import me.hyngsk.covidnow.Model.DataModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class DataManager {
	private ArrayList<DataModel> sharedDataJson;
	private DataModel sharedDataMap;

	private boolean isReady;

	public Object getSharedData() {
		return sharedDataJson;
	}


	public void setSharedData(ArrayList<DataModel> sharedData) {
		this.sharedDataJson = sharedData;
	}

	public void setSharedData(DataModel sharedData) {
		this.sharedDataMap = sharedData;
	}

	public boolean isReady() {
		return isReady;
	}

	public void setReady(boolean ready) {
		this.isReady = ready;
	}

	public static void consumer(DataModel dataModel){
		System.out.println(dataModel);

	}
}
