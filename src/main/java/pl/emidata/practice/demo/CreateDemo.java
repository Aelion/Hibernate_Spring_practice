package pl.emidata.practice.demo;

import pl.emidata.practice.entities.Employee;
import pl.emidata.practice.service.EmployeeService;
import pl.emidata.practice.service.HibEmployeeService;

public class CreateDemo {
    public static void main(String[] args) {
        EmployeeService es = new HibEmployeeService();
        Employee emp1 = new Employee();
        Employee emp2 = es.getEmployeeById(1);
        emp1.setFirstName("Mario");
        emp1.setLastName("Kovalsky");
        emp1.setCompany("IBM");
        System.out.println("Emp 1 before saving: " + emp1);
        System.out.println("Emp 2 before saving: " + emp2);
        emp2.setFirstName("Johnny");
        emp2.setCompany("Philips");
        es.saveEmployee(emp1);
        es.saveEmployee(emp2);
        System.out.println("Emp 1 after saving: " + emp1);
        System.out.println("Emp 2 after saving: " + emp2);

    }
}
