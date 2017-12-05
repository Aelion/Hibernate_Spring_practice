package pl.emidata.practice.demo;

import pl.emidata.practice.entities.Employee;
import pl.emidata.practice.service.EmployeeService;
import pl.emidata.practice.service.HibEmployeeService;

import java.util.ArrayList;
import java.util.List;

public class ReadDemo {
    public static void main(String[] args) {
        EmployeeService es = new HibEmployeeService();
        Employee emp1 = es.getEmployeeById(1);
        System.out.println(emp1);

        // getting all employees with Last Name = Wiloch
        System.out.println("\n\n\nGetting all employees with last name Wiloch");
        List<Employee> emp_Wiloch = new ArrayList<>();
        emp_Wiloch = es.getEmployeesByLastName("Wiloch");
        for (Employee emp : emp_Wiloch) {
            System.out.println(emp.getFirstName() + " " + emp.getLastName() + " - " + emp.getCompany());
        }

    }
}
