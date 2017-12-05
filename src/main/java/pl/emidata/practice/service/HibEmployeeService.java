package pl.emidata.practice.service;

import pl.emidata.practice.dao.EmployeeDAO;
import pl.emidata.practice.dao.EmployeeDAOImpl;
import pl.emidata.practice.entities.Employee;

public class HibEmployeeService implements EmployeeService {
    public Employee getEmployeeById(int id) {
        EmployeeDAO empdao = new EmployeeDAOImpl();
        Employee employee = empdao.fetchEmployeeById(id);
        return employee;
    }
}
