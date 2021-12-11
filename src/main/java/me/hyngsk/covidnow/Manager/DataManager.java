/*
 * Copyright (c) 2021.
 * Name : Hyeong Seok, Oh
 * E-mail : hyngsk.o@gmail.com
 * Created at : ${DATE}
 */

package me.hyngsk.covidnow.Manager;


public class DataManager {
	private Object sharedData;

	private boolean isReady;

	public Object getSharedData() {
		return sharedData;
	}

	public void setSharedData(Object sharedData) {
		this.sharedData = sharedData;
	}

	public boolean isReady() {
		return isReady;
	}

	public void setReady(boolean ready) {
		this.isReady = ready;
	}

}
