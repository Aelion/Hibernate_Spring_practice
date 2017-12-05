package pl.emidata.practice.dao;

import pl.emidata.practice.entities.Employee;

public interface EmployeeDAO {
    public Employee fetchEmployeeById(int id);
}
