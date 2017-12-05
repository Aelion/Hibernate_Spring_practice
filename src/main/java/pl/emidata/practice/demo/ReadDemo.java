package pl.emidata.practice.demo;

import pl.emidata.practice.entities.Employee;
import pl.emidata.practice.service.EmployeeService;
import pl.emidata.practice.service.HibEmployeeService;

public class ReadDemo {
    public static void main(String[] args) {
        EmployeeService es = new HibEmployeeService();
        Employee emp1 = es.getEmployeeById(1);
        System.out.println(emp1);
    }
}
