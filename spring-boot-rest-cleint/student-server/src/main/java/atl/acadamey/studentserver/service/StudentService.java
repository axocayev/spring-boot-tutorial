package atl.acadamey.studentserver.service;

import atl.acadamey.studentserver.model.Student;
import atl.acadamey.studentserver.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student student(Long id){
        return studentRepository.getOne(id);
    }
    public String hello(){
        return  "Hello, World";
    }
}
