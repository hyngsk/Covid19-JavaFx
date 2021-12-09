package me.hyngsk.covidnow.Utils;

import org.json.*;

import java.util.*;

public class MyParser {
	/**
	 * XML to Map Type
	 * @return List<Map<String, Object>>
	 */
	public static List<Map<String, Object>> XMLToMap(String xml) {
		List<Map<String, Object>> result = new ArrayList<>();
		JSONObject jsonObject = XML.toJSONObject(xml);
//		System.out.println(jsonObject);
		JSONArray items = jsonObject.getJSONObject("response")
				.getJSONObject("body")
				.getJSONObject("items")
				.getJSONArray("item");

		for (int i = 0; i < items.length(); i++) {
			HashMap<String, Object> hashmap = new HashMap<>();
			Iterator<String> iterator = items.getJSONObject(i).keys();
			while (iterator.hasNext()) {
				String key = iterator.next();
				hashmap.put(key, items.getJSONObject(i).get(key));
			}
			result.add(hashmap);
		}
//		System.out.println(result);
		return result;
	}

	/**
	 * List<Map<String,Object>> to JSON Type
	 * @return List<Map<String, Object>>
	 */
	public static JSONArray XmlToJson(String xml) {
		List<Map<String, Object>> result = new ArrayList<>();
		JSONObject jsonObject = XML.toJSONObject(xml);
//		System.out.println(jsonObject);
		JSONArray items = jsonObject.getJSONObject("response")
				.getJSONObject("body")
				.getJSONObject("items")
				.getJSONArray("item");
		return items;
	}


}
