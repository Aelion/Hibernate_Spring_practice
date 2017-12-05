package pl.emidata.practice.dao;

import org.hibernate.Session;
import pl.emidata.practice.entities.Employee;
import pl.emidata.practice.util.HibernateUtil;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public Employee fetchEmployeeById(int id) {
        Employee employee;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        employee = session.get(Employee.class, id);
        session.getTransaction().commit();
        return employee;
    }

    @Override
    public List<Employee> fetchEmployeesByLastName(String lastName) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Employee> employees = (List<Employee>) session.createQuery("from Employee e WHERE e.lastName=:lastName")
                .setParameter("lastName", lastName)
                .list();
        return employees;
    }

    @Override
    public Employee insertOrUpdateEmployee(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        return employee;
    }

    @Override
    public Employee insertNewEmployee(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        int id = (int) session.save(employee);
        session.getTransaction().commit();
        if (id == 0) {
            return null;
        } else {
            return fetchEmployeeById(id);
        }
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Employee resultEmployee;
        if (employee.getId() == 0) {
            resultEmployee = insertNewEmployee(employee);
            return resultEmployee;
        }

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(employee);
        session.getTransaction().commit();
        return employee;
    }
}
