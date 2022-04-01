package com.masai.usecases;

import java.util.Scanner;

import com.masai.Dao.Dao;
import com.masai.Dao.DaoImpl;
import com.masai.bean.Employee;

public class SaveEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter employee id");
		
		int id = input.nextInt();
		
		System.out.println("Enter employee name");
		
		String name = input.next();
		
		System.out.println("Enter employee address");
		
		String address = input.next();
		
		System.out.println("Enter employee salary");
		
		int salary = input.nextInt();
		
		Employee employee = new Employee(id, name, address, salary);
		
		Dao dao = new DaoImpl();
		
		String result = dao.saveEmployeeDetails(employee);
		
		System.out.println(result);
	}

}
