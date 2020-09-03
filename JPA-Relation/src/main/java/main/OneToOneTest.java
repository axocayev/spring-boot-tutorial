package main;

import config.HBConfig;
import entity.Address;
import entity.User;
import org.hibernate.Session;

public class OneToOneTest {

    public static void main(String[] args) {
        Session session = HBConfig.buildSessionFactory().openSession();


        try {

            session.beginTransaction();

            Address address=new Address();
            address.setStreet("Haydar Aliyev");
            address.setFlat("25");
            address.setPostCode("AZ0101");
            session.save(address);

            User u=new User();
            u.setEmail("anarxcoayev@gmail.com");
            u.setName("anar xocayev");
            u.setAddress(address);
            session.save(u);




            session.getTransaction().commit();
        } catch (Exception sqlException) {sqlException.printStackTrace();
            if (null != session.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                session.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }


    }
}
