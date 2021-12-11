/*
 * Copyright (c) 2021.
 * Name : Hyeong Seok, Oh
 * E-mail : hyngsk.o@gmail.com
 * Created at : ${DATE}
 */

package me.hyngsk.covidnow.Manager;

import me.hyngsk.covidnow.Controller.MainController;
import me.hyngsk.covidnow.Model.DataModel;

import java.util.ArrayList;


public class DataConsumer extends Thread {
	public DataManager dataManager;

	@Override
	public void run() {
		System.out.println("------------------------------------------consumer-------------------------------------------------");
		if (dataManager.isReady()) {
			Object sharedData = dataManager.getSharedData();
			consumer(sharedData);
			dataManager.setReady(false);
		}
	}
	public static void consumer(Object dataModel) {
		if(dataModel instanceof DataModel){
			MainController.consumed = (DataModel)dataModel;

		}
		else if(dataModel instanceof ArrayList<?>){
			MainController.consumed_arr = (ArrayList<DataModel>) dataModel;
		}

	}
}

