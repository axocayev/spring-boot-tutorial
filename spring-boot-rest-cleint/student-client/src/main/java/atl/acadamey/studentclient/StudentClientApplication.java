package atl.acadamey.studentclient;

import atl.acadamey.studentclient.client.StudentClientRestTemplate;
import atl.acadamey.studentclient.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class StudentClientApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StudentClientApplication.class, args);
    }

    @Autowired
    StudentClientRestTemplate studentClientRestTemplate;

    @Override
    public void run(String... args) throws Exception {
        List<Student> students=studentClientRestTemplate.studentList();
        students.stream().forEach(System.out::println);


    }
}
