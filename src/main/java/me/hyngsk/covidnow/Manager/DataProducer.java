/*
 * Copyright (c) 2021.
 * Name : Hyeong Seok, Oh
 * E-mail : hyngsk.o@gmail.com
 * Created at : ${DATE}
 */

package me.hyngsk.covidnow.Manager;

import me.hyngsk.covidnow.Api.ApiService;
import me.hyngsk.covidnow.Model.DataModel;
import me.hyngsk.covidnow.Model.Options;

import java.io.IOException;
import java.util.ArrayList;

public class DataProducer implements Runnable {
	public DataManager dataManager;
	String optionCBoxValue;
	private ApiService apiService;

	public DataProducer(Options optionCboxValue) {
		this.optionCBoxValue = optionCboxValue.toString();
		this.apiService = new ApiService();
	}


	@Override
	public void run() {
		System.out.println(optionCBoxValue);
		try {
			System.out.println("------------------------------------------producer-------------------------------------------------");
			if (optionCBoxValue.equals(Options.All.toString())) {
				ArrayList<DataModel> income = (ArrayList<DataModel>) apiService.getDataModel();
				System.out.println(income);
				if (!dataManager.isReady()) {
					dataManager.setSharedData(income);
					dataManager.setReady(true);
				}
			} else {
				DataModel income = (DataModel) apiService.getDataModel(optionCBoxValue);
				System.out.println(income);
				if (!dataManager.isReady()) {
					dataManager.setSharedData(income);
					dataManager.setReady(true);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end!!!!");
	}
}
