package pl.emidata.practice.service;

import pl.emidata.practice.dao.EmployeeDAO;
import pl.emidata.practice.dao.EmployeeDAOImpl;
import pl.emidata.practice.entities.Employee;

import java.util.List;

public class HibEmployeeService implements EmployeeService {
    private EmployeeDAO empdao = new EmployeeDAOImpl();

    public Employee getEmployeeById(int id) {
        Employee employee = empdao.fetchEmployeeById(id);
        return employee;
    }

    @Override
    public List<Employee> getEmployeesByLastName(String lastName) {
        List<Employee> employees = empdao.fetchEmployeesByLastName(lastName);
        return employees;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        Employee resultEmployee;
        resultEmployee = empdao.updateEmployee(employee);
        return resultEmployee;
    }
}
