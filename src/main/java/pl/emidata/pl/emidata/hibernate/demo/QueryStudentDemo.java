package pl.emidata.pl.emidata.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.emidata.hibernate.demo.entity.Student;

import java.util.List;


public class QueryStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();


            // query students
            List<Student> theStudents = session.createQuery("from Student").list();

            //display the students
            for (Student tempStudent : theStudents) {
                System.out.println(tempStudent);
            }

            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done");


        } finally {
            factory.close();
        }

    }


}