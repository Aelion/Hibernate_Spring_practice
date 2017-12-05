package pl.emidata.practice.dao;

import org.hibernate.Session;
import pl.emidata.practice.entities.Employee;
import pl.emidata.practice.util.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public Employee fetchEmployeeById(int id) {
        Employee employee;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        employee = session.get(Employee.class, id);
        return employee;
    }
}
