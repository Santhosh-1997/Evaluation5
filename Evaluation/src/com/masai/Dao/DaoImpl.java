package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.bean.Employee;
import com.masai.exception.EmployeeException;
import com.masai.utility.DataBaseUtility;

public class DaoImpl implements Dao {

	@Override
	public String saveEmployeeDetails(Employee employee) {
		
		String result = "not saved";
		
		
		try(Connection conn = DataBaseUtility.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into employee values(?,?,?,?)");
			
			ps.setInt(1, employee.getEid());
			ps.setString(2, employee.getName());
			ps.setString(3, employee.getAddress());
			ps.setInt(4, employee.getSalary());
			
			int i = ps.executeUpdate();
			
			if(i>0)
				result = "Employee details updated";
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}

	@Override
	public Employee getEmployeeById(int empId) throws EmployeeException {
		
		Employee employee = null;
		
		
		try(Connection conn = DataBaseUtility.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(" select * from employee where eid = ?");
			
			ps.setInt(1, empId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				employee = new Employee(rs.getInt("eid"), rs.getString("name"),rs.getString("address") , rs.getInt("salary"));
				
			}else
				throw new EmployeeException("id not found");
			
		} catch (SQLException e) {
			
			throw new EmployeeException(e.getMessage());
			
		}
		
		
		
		
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		
		List<Employee> list = new ArrayList<>();
		
		try(Connection conn = DataBaseUtility.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(" select * from employee");
			
			ResultSet rs = ps.executeQuery();
		
			while(rs.next()) {
				
				Employee employee = new Employee(rs.getInt("eid"), rs.getString("name"),rs.getString("address") , rs.getInt("salary"));
				
				list.add(employee);
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
		
	}

	@Override
	public String deleteEmployee(int empId) throws EmployeeException {
		
		String result = null;
		
			try(Connection conn = DataBaseUtility.getConnection()){
			
				PreparedStatement ps = conn.prepareStatement("delete from employee where eid = ?");
				
				ps.setInt(1, empId);
				
				int i = ps.executeUpdate();
				
				if(i>0)
					result = "deleted";
				else
					throw new EmployeeException("id not found");
		
			} catch (SQLException e) {
				
				throw new EmployeeException(e.getMessage());
			}
		
		
		return result;
		
	}

	
	
	
	
	
}
