package com.masai.map;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Mobile m = new Mobile();
		
		String result = m.addMobile("apple", "iphone10");
		System.out.println(result);
		
		String result1 = m.addMobile("apple", "iphone11");
		System.out.println(result1);
		
		ArrayList<String> result3 = m.getModels("apple");
		System.out.println(result3);
		

	}

}
