package pl.emidata.practice.dao;

import pl.emidata.practice.entities.Employee;

import java.util.List;

public interface EmployeeDAO {
    public Employee fetchEmployeeById(int id);

    public List<Employee> fetchEmployeesByLastName(String lastName);

    public Employee insertNewEmployee(Employee employee);

    public Employee updateEmployee(Employee employee);

    public Employee insertOrUpdateEmployee(Employee employee);
}
