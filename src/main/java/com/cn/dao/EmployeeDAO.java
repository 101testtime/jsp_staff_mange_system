package com.cn.dao;
import com.cn.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class EmployeeDAO {
	
	 // 获取所有员工信息
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employee";  // SQL查询语句，查询所有员工信息
        try (Connection conn = ConnectionPool.getConnection();  // 获取数据库连接
             Statement stmt = conn.createStatement();  // 创建Statement对象
             ResultSet rs = stmt.executeQuery(sql)) {  // 执行查询并获取结果集
            while (rs.next()) {  // 遍历结果集
                Employee employee = new Employee();  // 创建员工对象
                // 从结果集获取员工信息并设置到员工对象中
                employee.setEmployeeId(rs.getInt("employee_id"));
                employee.setEmployeeName(rs.getString("employee_name"));
                employee.setEmployeeSex(rs.getString("employee_sex"));
                employee.setEmployeeDate(rs.getDate("employee_date"));
                employee.setEmployeeSalary(rs.getDouble("employee_salary"));
                employee.setEmployeePosition(rs.getString("employee_position"));
                employees.add(employee);  // 将员工对象添加到列表中
            }
        } catch (Exception e) {
            e.printStackTrace();  // 捕获异常并打印堆栈跟踪
        }
        return employees;  // 返回员工列表
    }
 // EmployeeDAO.java

    public Employee getEmployeeById(int employeeId) {
        String sql = "SELECT * FROM employee WHERE employee_id = ?";
        Employee employee = null;
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, employeeId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    employee = new Employee();
                    employee.setEmployeeId(rs.getInt("employee_id"));
                    employee.setEmployeeName(rs.getString("employee_name"));
                    employee.setEmployeeSex(rs.getString("employee_sex"));
                    employee.setEmployeeDate(rs.getDate("employee_date"));
                    employee.setEmployeeSalary(rs.getDouble("employee_salary"));
                    employee.setEmployeePosition(rs.getString("employee_position"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }
    //
    public Employee getEmployeeByName(String employeeName) {
        String sql = "SELECT * FROM employee WHERE employee_name = ?";
        Employee employee = null;
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, employeeName);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    employee = new Employee();
                    employee.setEmployeeId(rs.getInt("employee_id"));
                    employee.setEmployeeName(rs.getString("employee_name"));
                    employee.setEmployeeSex(rs.getString("employee_sex"));
                    employee.setEmployeeDate(rs.getDate("employee_date"));
                    employee.setEmployeeSalary(rs.getDouble("employee_salary"));
                    employee.setEmployeePosition(rs.getString("employee_position"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }
    // 添加新员工
    public boolean addEmployee(Employee employee) {
        String sql = "INSERT INTO employee (employee_name, employee_sex, employee_date, employee_salary, employee_position) VALUES (?, ?, ?, ?, ?)";  // SQL插入语句
        try (Connection conn = ConnectionPool.getConnection();  // 获取数据库连接
             PreparedStatement ps = conn.prepareStatement(sql)) {  // 创建PreparedStatement对象
            // 将员工对象的属性值设置到PreparedStatement中
            ps.setString(1, employee.getEmployeeName());
            ps.setString(2, employee.getEmployeeSex());
            ps.setDate(3, new java.sql.Date(employee.getEmployeeDate().getTime()));  // 将java.util.Date转换为java.sql.Date
            ps.setDouble(4, employee.getEmployeeSalary());
            ps.setString(5, employee.getEmployeePosition());
            return ps.executeUpdate() > 0;  // 执行更新操作，返回是否成功
        } catch (SQLException e) {
            e.printStackTrace();  // 捕获异常并打印堆栈跟踪
        }
        return false;  // 如果发生异常或执行失败，返回false
    }
    //修改员工
    public boolean updateEmployee(Employee employee) {
        String sql = "UPDATE employee SET employee_name = ?, employee_sex = ?, employee_date = ?, employee_salary = ?, employee_position = ? WHERE employee_id = ?";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, employee.getEmployeeName());
            ps.setString(2, employee.getEmployeeSex());
            ps.setDate(3, new java.sql.Date(employee.getEmployeeDate().getTime()));
            ps.setDouble(4, employee.getEmployeeSalary());
            ps.setString(5, employee.getEmployeePosition());
            ps.setInt(6, employee.getEmployeeId());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    // 删除员工
    public boolean deleteEmployee(int employeeId) {
        String sql = "DELETE FROM employee WHERE employee_id = ?";  // SQL删除语句
        try (Connection conn = ConnectionPool.getConnection();  // 获取数据库连接
             PreparedStatement ps = conn.prepareStatement(sql)) {  // 创建PreparedStatement对象
            ps.setInt(1, employeeId);  // 设置员工ID为参数
            return ps.executeUpdate() > 0;  // 执行删除操作，返回是否成功
        } catch (SQLException e) {
            e.printStackTrace();  // 捕获异常并打印堆栈跟踪
        }
        return false;  // 如果发生异常或执行失败，返回false
    }
}
