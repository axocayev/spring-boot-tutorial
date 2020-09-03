package az.atl.academy.hrapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    private ApplicationContext appContext;
    @Autowired
    @Qualifier("student1")
    private Student student;

   /* @Autowired

    private Student student;*/
    @Autowired
    MyService myService;

    private Student s=new Student();
    private Student s1=new Student();

    @Autowired
    MyComp1  myComp1;

    MyComp1  myComp1_1=new MyComp1();

    @Autowired
    MyComp2 myComp2;
    MyComp2 myComp2_2 =new MyComp2();

    @Autowired
    MyComp3 myComp3;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("myComp1 "+myComp1.getMyService().hashCode());
        System.out.println("myComp2 "+ myComp2.getMyService().hashCode());
        System.out.println(myComp1.getMyService().equals(myComp2.getMyService()));
        //System.out.println(myComp1_1.getMyService().equals(myComp2_2.getMyService()));

        System.out.println(myService.myService1());
        System.out.println(myService.myService2());

       /* System.out.println(student1.getName());
        System.out.println(student1.getSurnam());
        System.out.println(student1.hashCode());

        System.out.println(student2.getName());
        System.out.println(student2.getSurnam());
        System.out.println(student2.hashCode());*/

        System.out.println(student.getName());
        System.out.println(student.getSurnam());
        System.out.println(student.hashCode());
        System.out.println(s.getName());
        System.out.println(s.getSurnam());
        System.out.println(s.hashCode());

        System.out.println(s1.getName());
        System.out.println(s1.getSurnam());
        System.out.println(s1.hashCode());
        System.out.println("List of beans:");
        String[] beans = appContext.getBeanDefinitionNames();
        for (String bean : beans) {
            System.out.println(bean);
        }
    }
}
