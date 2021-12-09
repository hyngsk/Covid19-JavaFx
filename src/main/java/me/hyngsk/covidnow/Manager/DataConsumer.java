/*
 * Copyright (c) 2021.
 * Name : Hyeong Seok, Oh
 * E-mail : hyngsk.o@gmail.com
 * Created at : ${DATE}
 */

package me.hyngsk.covidnow.Manager;

import me.hyngsk.covidnow.Controller.MainController;
import me.hyngsk.covidnow.Model.ModelBuilder;



public class DataConsumer extends Thread {
	public DataManager dataManager;

	@Override
	public void run() {
		System.out.println("------------------------------------------consumer-------------------------------------------------");
		if (dataManager.isReady()) {
//			System.out.println(dataManager.getSharedData());

			MainController.consumer(new ModelBuilder()
					.setName("sdf")
					.setDef_cnt(2)
					.setDeath_cnt(3)
					.setIsol_ing_cnt(3)
					.setOver_flow_cnt(3)
					.setLocal_occ_cnt(3)
					.build());
//			System.out.println(consumed.toString());
			dataManager.setReady(false);
		}
	}
}

