package me.hyngsk.covidnow.Api;


import me.hyngsk.covidnow.Model.DataModel;
import me.hyngsk.covidnow.Model.ModelBuilder;
import me.hyngsk.covidnow.Utils.MyParser;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class ApiService {
	private Api api = null;

	public ApiService() {
		setApi();
	}

	private void setApi() {
		this.api = new Api();
	}

	public String getData() throws IOException {
		return api.getRawData();
	}

	public Object getDataModel(String option) throws IOException {
		JSONArray data = MyParser.XmlToJson(api.getRawData());
		DataModel OneResult = null;
		for (Object i : data) {
			JSONObject k = (JSONObject) i;
//			System.out.println(k.getString("gubun"));
			if (option.equals(k.getString("gubun"))) {
				OneResult = new ModelBuilder()
						.setName(k.getString("gubun"))
						.setDef_cnt(k.getInt("defCnt"))
						.setDeath_cnt(k.getInt("deathCnt"))
						.setIsol_ing_cnt(k.getInt("isolClearCnt"))
						.setOver_flow_cnt(k.getInt("overFlowCnt"))
						.setLocal_occ_cnt(k.getInt("localOccCnt"))
						.build();
//				System.out.println(result.toString());
				return OneResult;
			}
		}

		return null;
	}

	public Object getDataModel() throws IOException {
		JSONArray data = MyParser.XmlToJson(api.getRawData());
		ArrayList<DataModel> AllResult = new ArrayList<DataModel>();
		for (Object o : data) {
			JSONObject k = (JSONObject) o;
			AllResult.add(new ModelBuilder()
					.setName(k.getString("gubun"))
					.setDef_cnt(k.getInt("defCnt"))
					.setDeath_cnt(k.getInt("deathCnt"))
					.setIsol_ing_cnt(k.getInt("isolClearCnt"))
					.setOver_flow_cnt(k.getInt("overFlowCnt"))
					.setLocal_occ_cnt(k.getInt("localOccCnt"))
					.build());
		}
		return AllResult;
	}
}
