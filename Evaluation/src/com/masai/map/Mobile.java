package com.masai.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Mobile {
	
	
	HashMap<String,ArrayList<String>> mobiles = new HashMap<>();
	
	
	public String addMobile(String company, String model) {

		String result = "mobile added successfully";
		
		Mobile m = new Mobile();
		
		ArrayList<String> list = new ArrayList<>();
		
		Set <Map.Entry<String, ArrayList<String>>> set = m.mobiles.entrySet();
		
		for(Map.Entry<String, ArrayList<String>> el : set)
			if(el.getKey().equals(company))
				list.addAll(el.getValue());
		
		list.add(model);
				
		m.mobiles.put(company, list);
		
		
		return result;
	}

	public ArrayList<String> getModels(String company){
		//This method return the list of all the models of the supplied company
		//if we supply any invalid company name then it should return null value
		
		ArrayList<String> models = new ArrayList<>();
		
		Mobile m = new Mobile();
		
		Set <Map.Entry<String, ArrayList<String>>> set = m.mobiles.entrySet();
		
		for(Map.Entry<String, ArrayList<String>> el : set)
			if(el.getKey().equals(company))
				models.addAll(el.getValue());
		
		
		return models;
		
	}

}
