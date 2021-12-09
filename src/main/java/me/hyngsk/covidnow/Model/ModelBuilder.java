package me.hyngsk.covidnow.Model;

public class ModelBuilder {
	String name;
	int death_cnt;
	int def_cnt;
	int isol_ing_cnt;
	int over_flow_cnt;
	int local_occ_cnt;

	public ModelBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public ModelBuilder setDeath_cnt(int death_cnt) {
		this.death_cnt = death_cnt;
		return this;
	}

	public ModelBuilder setDef_cnt(int def_cnt) {
		this.def_cnt = def_cnt;
		return this;
	}

	public ModelBuilder setIsol_ing_cnt(int isol_ing_cnt) {
		this.isol_ing_cnt = isol_ing_cnt;
		return this;
	}

	public ModelBuilder setOver_flow_cnt(int over_flow_cnt) {
		this.over_flow_cnt = over_flow_cnt;
		return this;
	}

	public ModelBuilder setLocal_occ_cnt(int local_occ_cnt) {
		this.local_occ_cnt = local_occ_cnt;
		return this;
	}

	public DataModel build() {
		return new DataModel(name,
				death_cnt,
				def_cnt,
				isol_ing_cnt,
				over_flow_cnt,
				local_occ_cnt);
	}
}
