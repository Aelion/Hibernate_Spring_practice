package pl.emidata.practice.service;

import pl.emidata.practice.entities.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee getEmployeeById(int id);

    public List<Employee> getEmployeesByLastName(String lastName);

    public Employee saveEmployee(Employee employee);
}
