package com.accenture.lkm.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAO {

	public Map<String, String> getCustomerType() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("S", "Silver"); // value label
		map.put("G", "Gold");
		map.put("P", "Platinum");
		return map;
	}
	
	
	public List<String> getCustomerTypeSameValueAndLabel() {
		List<String> list = new ArrayList<String>();
		list.addAll(Arrays.asList("Silver","Gold","Platinum"));
		return list;
	}

	
	public Map<String, String> getCustomerServices() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("MV", "Mobile"); // value label
		map.put("EV", "Email");
		map.put("SSV", "Special Services");
		return map;
	}
	
	public Map<String, String> getGender() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("M", "Male"); // value label
		map.put("F", "Female");
		return map;
	}
}
