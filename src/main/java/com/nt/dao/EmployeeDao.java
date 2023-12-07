package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.nt.entity.Employee;

@Component
public class EmployeeDao {
	@Autowired
	private JdbcTemplate template;

	public boolean register(Employee e) {

		try {
			Object[] args = { e.getId(), e.getName(), e.getSal() };
			int result = template.update("insert into Employee values(?,?,?)", args);
			if (result == 1)
			return true;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return false;
	}

	public boolean update(int id, int sal) {
		try {
			Object[] args = { sal, id };
			int result = template.update("update Employee set EmpSalary=? where EmpID=?", args);
			System.out.println(result + "record updated");
			if (result == 1)
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public boolean delete(int id) {
		try {
			Object[] args = { id };
			int result = template.update("delete from Employee where EmpID=?", args);
			if (result == 1)
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public Employee findById(int id) {
		try {
			Object[] args = { id };
			Employee emp = template.queryForObject("SELECT * FROM nithya.Employee where EmpID=?",
					new RowMapper<Employee>() {

				@Override
				public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
					int i = rs.getInt("EmpID");
					String name = rs.getString("EmpName");
					int sal = rs.getInt("EmpSalary");
					return new Employee(i, name, sal);
				}
			}, args);
			return emp;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public List<Employee> selectAll() {
		try {
			List<Employee> list = template.query("SELECT * FROM nithya.Employee", new RowMapper<Employee>() {
				@Override
				public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
					int i = rs.getInt("EmpID");
					String name = rs.getString("EmpName");
					int sal = rs.getInt("EmpSalary");
					return new Employee(i, name, sal);
				}

			});
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
