package com.masai.usecases;

import java.util.Scanner;

import com.masai.Dao.Dao;
import com.masai.Dao.DaoImpl;
import com.masai.bean.Employee;
import com.masai.exception.EmployeeException;

public class GetEmployeeById {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter employee id");
		
		int id = input.nextInt();
		
		Dao dao = new DaoImpl();
		
		try {
			Employee employee = dao.getEmployeeById(id);
			
			System.out.println(employee.toString());
			
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
