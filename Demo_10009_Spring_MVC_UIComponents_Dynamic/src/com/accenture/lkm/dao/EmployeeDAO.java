package com.accenture.lkm.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {

	public Map<String, String> getCountries() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("US", "United States"); // value label
		map.put("SG", "Singapur");
		map.put("DB", "Dubai");
		return map;
	}
	
	
	public List<String> getCountriesSameValueAndLabel() {
		List<String> list = new ArrayList<String>();
		list.addAll(Arrays.asList("USA","Russia","Italy"));
		return list;
	}

	
	public Map<String, String> getCommunities() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("JEEV", "JavaL"); // value label
		map.put("SPRINGSV", "SpringsL");
		map.put("DNV", "DotNetL");
		return map;
	}
	
	public Map<String, String> getGender() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("M", "Male"); // value label
		map.put("F", "Female");
		return map;
	}
}
