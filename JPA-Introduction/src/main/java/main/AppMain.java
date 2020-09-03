package main;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.Address;
import entity.MarksDetails;
import entity.Person;
import entity.Student;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.Query;

public class AppMain {

    static User userObj;
    static Session sessionObj;
    static SessionFactory sessionFactoryObj;

    private static SessionFactory buildSessionFactory() {
        // Creating Configuration Instance & Passing Hibernate Configuration File
        Configuration configObj = new Configuration();
        configObj.configure("hibernate.cfg.xml");
        configObj.addAnnotatedClass(User.class);
        configObj.addAnnotatedClass(Person.class);
        configObj.addAnnotatedClass(Student.class);
        configObj.addAnnotatedClass(MarksDetails.class);
        configObj.addAnnotatedClass(Address.class);

        // configObj.configure(new File("hibernate.cfg.xml")).buildSessionFactory();

        // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

        // Creating Hibernate SessionFactory Instance
        sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
        return sessionFactoryObj;
    }

    public static void main(String[] args) {
       /* System.out.println(".......Hibernate Maven Example.......\n");

        System.out.println("-------------------- user list ");
        for(User u:getUsers()){
            System.out.println(u);
        }
        System.out.println("-------------------- user list ");
*/

        try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();



            Student studentObj = new Student("Java", "Geek",  "javageek@javacodegeeks.com", "0123456789");
            sessionObj.save(studentObj);

            MarksDetails marksObj1 = new MarksDetails("English", "100", "90",  "Pass");
            marksObj1.setStudent(studentObj);
            sessionObj.save(marksObj1);

            MarksDetails marksObj2 = new MarksDetails("Maths", "100", "99",  "Pass");
            marksObj2.setStudent(studentObj);
            sessionObj.save(marksObj2);

            MarksDetails marksObj3 = new MarksDetails("Science", "100", "94",  "Pass");
            marksObj3.setStudent(studentObj);
            sessionObj.save(marksObj3);


            /*String queryString = "FROM User where  status=1 and  userid=1";
            Query query = sessionObj.createQuery(queryString, User.class);
            List<User> people = query.getResultList();

            for (User p : people) {
                System.out.println(p);
            }*/

           /* for (User p :(List<User>) sessionObj.createSQLQuery("SELECT * FROM users2 where user_id=1")
                                      .addEntity(User.class).getResultList()){
                System.out.println(p);
            };*/



            /*for (int i = 101; i <= 105; i++) {
                userObj = new User();
                userObj.setUserid(i);
                userObj.setUsername("Editor " + i);
                userObj.setCreatedBy("Administrator");
                userObj.setCreatedDate(new Date());

                sessionObj.save(userObj);

            }*/
            /*userObj=new User();

            userObj.setCreatedBy("aaaa");
            userObj.setCreatedDate(new Date());
            userObj.setUsername("bbb");
            userObj.setEmail("aaaaa@test.com");
            userObj.setPassword("testpsw");
            ///sessionObj.save(userObj);

            sessionObj.save(userObj);

            //sessionObj.save(userObj);*/
            System.out.println("\n.......Records Saved Successfully To The Database.......\n");

            // Committing The Transactions To The Database
            sessionObj.getTransaction().commit();
        } catch (Exception sqlException) {sqlException.printStackTrace();
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
    }

    public static  List<User> getUsers(){

        List<User> users=null;
        try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();



            users= (List<User>) sessionObj.createSQLQuery("SELECT * FROM users2 ")
                    .addEntity(User.class).getResultList();



            System.out.println("\n.......Records Saved Successfully To The Database.......\n");


            sessionObj.getTransaction().commit();
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        return users;
    }
}


