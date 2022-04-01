package com.masai.usecases;

import java.util.List;

import com.masai.Dao.Dao;
import com.masai.Dao.DaoImpl;
import com.masai.bean.Employee;

public class GetAllEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Dao dao = new DaoImpl();
		
		List<Employee> list = dao.getAllEmployees();
		
		for(Employee el : list)
			System.out.println(el.toString());
		

	}

}
