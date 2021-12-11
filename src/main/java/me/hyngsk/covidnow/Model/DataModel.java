/*
 * Copyright (c) 2021.
 * Name : Hyeong Seok, Oh
 * E-mail : hyngsk.o@gmail.com
 * Created at : ${DATE}
 */

package me.hyngsk.covidnow.Model;


public class DataModel {
	String loc_name;
	int death_cnt;
	int def_cnt;
	int isol_ing_cnt;
	int over_flow_cnt;
	int local_occ_cnt;
	String update_dt;

	/**
	 * 3. 생성자
	 */
	public DataModel(String loc_name,
	                 int death_cnt,
	                 int def_cnt,
	                 int isol_ing_cnt,
	                 int over_flow_cnt,
	                 int local_occ_cnt,
	                 String update_dt) {
		this.loc_name = loc_name;
		this.death_cnt = death_cnt;
		this.def_cnt = def_cnt;
		this.isol_ing_cnt = isol_ing_cnt;
		this.over_flow_cnt = over_flow_cnt;
		this.local_occ_cnt = local_occ_cnt;
		this.update_dt = update_dt;

	}

	public DataModel(DataModel dataModel) {
		this.loc_name = dataModel.loc_name;
		this.death_cnt = dataModel.death_cnt;
		this.def_cnt = dataModel.def_cnt;
		this.isol_ing_cnt = dataModel.isol_ing_cnt;
		this.over_flow_cnt = dataModel.over_flow_cnt;
		this.local_occ_cnt = dataModel.local_occ_cnt;
		this.update_dt = dataModel.update_dt;

	}

	public DataModel() {

	}

	public String getLoc_name() {
		return loc_name;
	}

	public int getDeath_cnt() {
		return death_cnt;
	}

	public int getDef_cnt() {
		return def_cnt;
	}

	public int getIsol_ing_cnt() {
		return isol_ing_cnt;
	}

	public int getOver_flow_cnt() {
		return over_flow_cnt;
	}

	public int getLocal_occ_cnt() {
		return local_occ_cnt;
	}

	public String getUpdate_dt() {
		return update_dt;
	}

	@Override
	public String toString() {
		return "DataModel{" +
				"loc_name='" + loc_name + '\'' +
				", death_cnt=" + death_cnt +
				", def_cnt=" + def_cnt +
				", isol_ing_cnt=" + isol_ing_cnt +
				", over_flow_cnt=" + over_flow_cnt +
				", local_occ_cnt=" + local_occ_cnt +
				", update_dt='" + update_dt + '\'' +
				'}';
	}
}
